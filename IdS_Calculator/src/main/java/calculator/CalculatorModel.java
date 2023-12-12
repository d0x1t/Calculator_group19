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

    public void executeOperations() throws ErrorHandler {}

    public int showAChoiceDialogue() {}

    public boolean isValidComplexNumber(String text) {}

    public String clearComplexNumber(String text) {}

    public boolean isValidOperator(String text) {}

    public boolean isValidVariable(String text) {}

    public String clearVariable(String text) {}

}
