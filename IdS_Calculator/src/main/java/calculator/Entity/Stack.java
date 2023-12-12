package Entity;
import javafx.application.Platform;
import javafx.scene.control.TextArea;
import java.util.ArrayList;



public class Stack {
    private final ArrayList<String> stack;
    private final TextArea textArea;
   


    public ArrayList<String> getStack() {
        return stack;
    }

    public Stack(TextArea textArea) {
        stack = new ArrayList<>();
        this.textArea = textArea;
    }
    
    
    
    public boolean equals(Stack otherStack) {
        // Controlla prima la dimensione degli stack
        if (this.size() != otherStack.size()) {
            return false;
        }

        // Confronta gli elementi uno per uno
        for (int i = 0; i < this.size(); i++) {
            if (!this.stack.get(i).equals(otherStack.stack.get(i))) {
                return false;
            }
        }

        // Tutti gli elementi sono uguali
        return true;
    }

    public void push(String item) {
        
        stack.add(item);
        stackUpdater();
       
    }

    public String  pop() {
        if (!isEmpty()) {
            String temp= stack.remove(stack.size() - 1);
            stackUpdater();
            return temp;
        }
        return null;
    }

    public String peek() {
        if (!isEmpty()) {
          String temp= stack.get(stack.size() - 1); 
            stackUpdater();
            return temp;
        }
        return null;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
        
    }

    public void clear() {
        stack.clear();
        stackUpdater();
    }

    public void drop() {
        if (!isEmpty()) {
            stack.remove(stack.size() - 1);
            stackUpdater();
        }
    }

    public void dup() {
        if (!isEmpty()) {
            stack.add(stack.get(stack.size() - 1));
            stackUpdater();
        }
    }

    public void swap() {
        if (stack.size() >= 2) {
            int lastIndex = stack.size() - 1;
            String last = stack.get(lastIndex);
            String secondLast = stack.get(lastIndex - 1);
            stack.set(lastIndex - 1, last);
            stack.set(lastIndex, secondLast);
            stackUpdater();
        }
    }

    public void over() {
        if (stack.size() >= 2) {
            stack.add(stack.get(stack.size() - 2));
            stackUpdater();
        }
    }
    
    public int size() {
        return stack.size();
    }
    public void stackUpdater(){
        
        StringBuffer sb = new StringBuffer();
        // Itera lo stack dall'ultimo elemento al primo
        for (int i = stack.size() - 1; i >= 0; i--) {
            sb.append(stack.get(i)).append("\n");
        }
        String text =sb.toString();
        
        if (text == null || textArea == null) return;

        // Aggiorna la TextArea sul thread dell'interfaccia utente
        Platform.runLater(() -> textArea.setText(text));

    }
}

