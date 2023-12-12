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

    public void handleVariables(String variable_operator) throws ErrorHandler { }

    public void executeOperations() throws ErrorHandler {}

    public int showAChoiceDialogue() {}

    public boolean isValidComplexNumber(String text) {}

    public String clearComplexNumber(String text) {}

    public boolean isValidOperator(String text) {}

    public boolean isValidVariable(String text) {}

    public String clearVariable(String text) {}

}
