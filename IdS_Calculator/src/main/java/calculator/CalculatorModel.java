package calculator;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import Entity.*;
public final class CalculatorModel {

    private Stack stack;
    private BufferVariable bufVariable;
    private CalculatorController controller;

    public CalculatorModel(Stack stack, BufferVariable bufVariable, CalculatorController controller) {
        this.stack = stack;
        this.bufVariable = bufVariable;
        this.controller = controller;

    }

    public void handleVariables(String variable_operator) throws ErrorHandler {
        //prende in input la stringa: operatore e variabile.
        if (variable_operator == null) {
            return; //se per qualche motivo gli viene passato null allora ritorna direttamente
        }
        if (stack.isEmpty()) {
            throw new ErrorHandler("The stack is empty", 1); //Siccome tutte le operazioni sulle variabili fanno riferimento allo stack, se  vuoto ritorna errore.
        }

        String last_complex_number = (String) stack.peek(); //mi prendo l'ultimo elemento inserito nello stack.
        if (!isValidComplexNumber(last_complex_number)) { //controllo se non è un operatore
            throw new ErrorHandler("Last element in the stack is not a complex number", 3);
        }
        //se sono qui sono sicuro che ho un tipo "<x".
        char Variable = Character.toLowerCase(variable_operator.charAt(1));

        switch (variable_operator.charAt(0)) {
            case '>':
                bufVariable.storeVariable(Variable, last_complex_number);
                break;
            case '<':
                if (!bufVariable.getVariablesMap().containsKey(Variable)) {
                    throw new ErrorHandler("The variable is not been initialized", 1);
                }
                stack.push(bufVariable.valueVariable(Variable));
                break;
            case '+':
                if (!bufVariable.getVariablesMap().containsKey(Variable)) {
                    throw new ErrorHandler("The variable is not been initialized", 1);
                }
                OperationComplexNumber a1 = new OperationComplexNumber(bufVariable.valueVariable(Variable));
                OperationComplexNumber b1 = new OperationComplexNumber(last_complex_number);
                bufVariable.storeVariable(Variable, a1.add(b1).toString());
                break;
            case '-':
                if (!bufVariable.getVariablesMap().containsKey(Variable)) {
                    throw new ErrorHandler("The variable is not been initialized", 1);
                }
                OperationComplexNumber a2 = new OperationComplexNumber(bufVariable.valueVariable(Variable));
                OperationComplexNumber b2 = new OperationComplexNumber(last_complex_number);
                bufVariable.storeVariable(Variable, a2.subtract(b2).toString());
                break;
        }
    }

    public void executeOperations() throws ErrorHandler {
        Stack temp = new Stack(controller.StackTextArea);
        boolean foundOperator;
        while (true) {
            foundOperator = false;

            for (String item : stack.getStack()) {  //APPENA TROVA UN OPERATORE ESCE DAL FOR
                if (isValidOperator(item)) {
                    foundOperator = true;
                    break;
                }
            }

            if (!foundOperator && !temp.isEmpty()) { //ENTRA SOLO SE NON CI SONO PIU OPERATORI NELLO STACK E SE LO STACK TEMP è VUOTO              
                while (!temp.isEmpty()) {            //IN QEUSTO MODO AFFINCHE UN OPERATORE DALLO STACK TEMP NON VIENE SPOSTATO NELLO STACK ORIGINALE
                    String item = temp.pop();        //SI PUO CONTINUARE AD ITERARE SU TEMP SPOSTANDO NUMERI COMPLESSI NELLO STACK ORIGINALE
                    if (item.equals("+")
                            || item.equals("-")
                            || item.equals("×")
                            || item.equals("÷")
                            || item.equals("√")
                            || item.equals("+/-")) {
                        stack.push(item);
                        foundOperator = true;
                        break;
                    } else {
                        stack.push(item);
                    }
                }
            }

            if (!foundOperator && temp.isEmpty()) {  //PUNTO DI USCITA DALLA FUNZIONE
                break;                               //SE NON CI SONO OPERATORI NELLO STACK E LO STACK TEMP è VUOTO SI PUO TERMINARE.
            }

            String item = stack.pop();              //LEGGO ED ELIMINO IL TOP DALLO STACK
            if (item.equals("+")
                    || item.equals("-")
                    || item.equals("×")
                    || item.equals("÷")) {

                if (stack.size() < 2) {
                    // NON CI SONO ABBASTANZA OPERANDI, RIMETTI L'OPERATORE NELLO STACK E TERMINA LANCIANO L'ECCEZIONE
                    stack.push(item);
                    throw new ErrorHandler("Insufficient operands in the stack", 1);
                }

                String operator = item;
                String _1 = stack.pop();
                String _2 = stack.pop();

                // SE LE PROSSIME DUE STRINGHE NON SONO NUMERI COMPLESSI RIMETTILE NELLO STACK, MENTRE L'OPERATORE, CHE è IL TOP, NELLO STACK TEMP 
                //IN QUESTO MODO ALLA PROSSIMA ITERAZIONE IL TOP DELLO STACK SARà L'ELEMENTO SUCCESSIVO
                if (!isValidComplexNumber(_1) || !isValidComplexNumber(_2)) {
                    stack.push(_2);
                    stack.push(_1);
                    temp.push(item);
                    continue;
                }
                //******************************************************//
                //GESTIONE OPERAZIONI BINARIE//
                OperationComplexNumber a = new OperationComplexNumber(_1);
                OperationComplexNumber b = new OperationComplexNumber(_2);
                switch (operator) {
                    case "+":
                        stack.push(b.add(a).toString());
                        break;
                    case "-":
                        stack.push(b.subtract(a).toString());
                        break;
                    case "×":
                        stack.push(b.multiply(a).toString());
                        break;
                    case "÷":
                        if (a.getReal() == 0 && a.getImaginary() == 0) {
                            throw new ErrorHandler("Division impossible", 1);

                        }
                        stack.push(b.divide(a).toString());
                        break;
                }
                //******************************************************//
            } else if (item.equals("√")
                    || item.equals("+/-")) {
                String operator = item;

                if (stack.size() < 1) {
                    // NON CI SONO ABBASTANZA OPERANDI, RIMETTE L'OPERATORE NELLO STACK E TERMINA LANCIANDO L'ECCEZIONE      
                    stack.push(item);
                    throw new ErrorHandler("Insufficient operands in the stack", 1);
                }

                String _1 = stack.pop();

                // SE LA PROSSIMA STRINGA NON è UN NUMERO COMPLESSO LO RIMETTE NELLO STACK, MENTRE L'OPERATORE, CHE è IL TOP, NELLO STACK TEMP 
                //IN QUESTO MODO ALLA PROSSIMA ITERAZIONE IL TOP DELLO STACK SARà L'ELEMENTO SUCCESSIVO
                if (!isValidComplexNumber(_1)) {
                    stack.push(_1);
                    temp.push(item);
                    continue;
                }
                //******************************************************//
                //GESTIONE OPERAZIONI UNARIE//
                OperationComplexNumber a = new OperationComplexNumber(_1);

                switch (operator) {
                    case "√":
                        stack.push(a.sqrt().toString());
                        if (a.sqrt().getImaginary() != 0.0) {
                            stack.push(a.sqrt().inverse().toString());
                        }
                        break;
                    case "+/-":
                        stack.push(a.inverse().toString());
                        break;
                }
                //******************************************************//
            } else {
                temp.push(item); //SE SI è ARRIVATI QUI ALLORA IL TOP DELLO STACK è UN NUMERO COMPLESSO E NON UN OPERATORE
            }

        }
    }

    public int showAChoiceDialogue() {
        System.out.println(stack.size());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Scelta Operazione");
        alert.setHeaderText("Considerare 'j' come:");
        alert.setContentText("Scegli l'opzione corretta:");

        ButtonType btnVariabile = new ButtonType("Variabile");
        ButtonType btnNumeroComplesso = new ButtonType("Numero Complesso");

        // Imposta i bottoni sul dialogo
        alert.getButtonTypes().setAll(btnVariabile, btnNumeroComplesso);

        // Mostra il dialogo e attendi la risposta dell'utente
        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent()) {
            if (result.get() == btnVariabile) {
                // L'utente ha scelto "Variabile"
                return 1;
            } else if (result.get() == btnNumeroComplesso) {
                // L'utente ha scelto "Numero Complesso"
                return 2;
            }
        }
        return 0;
    } 

    public boolean isValidComplexNumber(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }

        // Rimuove gli spazi e converte tutto in minuscolo per semplificare l'analisi
        text = text.replaceAll(" ", "").toLowerCase();

        String regex = "([+-]?(\\d+\\.\\d+|\\d+))?([+-]?(\\d+\\.\\d+|\\d+)?j)?|([+-]?(\\d+\\.\\d+|\\d+)?j)?([+-]?(\\d+\\.\\d+|\\d+))?";

        /*
        Spiegazione del regex:
        ([+-]?(\\d+\\.\\d+|\\d+))?

        ([+-]?): Questo gruppo corrisponde a un segno opzionale + o -. Il punto interrogativo ? rende il segno facoltativo.
        (\\d+\\.\\d+|\\d+): Questo Ã¨ un gruppo di scelta che corrisponde a un numero. \\d+\\.\\d+ corrisponde a un numero decimale (es. 12.34), dove \\d+ corrisponde a una o piÃ¹ cifre e \\.\\d+ corrisponde al punto decimale seguito da una o piÃ¹ cifre. Il simbolo | significa "OR", quindi \\d+ corrisponde a un numero intero senza parte decimale.
        L'intero gruppo Ã¨ racchiuso in parentesi con un punto interrogativo finale, rendendo l'intera parte reale facoltativa.
        
        ([+-]?(\\d+\\.\\d+|\\d+)?j)? : Questa parte Ã¨ simile alla prima, ma con l'aggiunta di j alla fine. Questo rappresenta la parte immaginaria del numero complesso.
        La parte ([+-]?(\\d+\\.\\d+|\\d+)?) corrisponde a un numero opzionale (intero o decimale) con un segno opzionale davanti.
        j Ã¨ la rappresentazione standard della parte immaginaria in un numero complesso.
        Ancora una volta, l'intero gruppo Ã¨ opzionale.
        Il carattere '|' Ã¨ l'operatore OR. Divide l'espressione regolare in due parti, permettendo di corrispondere a stringhe che hanno la parte reale seguita dalla parte immaginaria o viceversa.
        
        ([+-]?(\\d+\\.\\d+|\\d+)?j)?([+-]?(\\d+\\.\\d+|\\d+))? : Questa parte Ã¨ una ripetizione delle due precedenti ma in ordine inverso, permettendo la parte immaginaria di apparire prima della parte reale.
         */
        // Verifica se la stringa corrisponde al pattern del numero complesso
        return text.matches(regex);
    }

    public String clearComplexNumber(String text) {}

    public boolean isValidOperator(String text) {}

    public boolean isValidVariable(String text) {}

    public String clearVariable(String text) {}

}
