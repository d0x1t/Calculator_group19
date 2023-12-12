package Entity;
import java.util.HashMap;
import java.util.Map;
import javafx.application.Platform;
import javafx.scene.control.TextArea;


public class BufferVariable {

    private Map<Character, String> variables;
    private TextArea textArea;

    public BufferVariable(TextArea textArea) {
        variables = new HashMap<>();
        this.textArea = textArea;

    }
    public Map<Character, String> getVariablesMap() {
        return variables;
    }

    public String valueVariable(char variableName) {}

    public void storeVariable(char variableName, String value) {}

    public void updateTextArea() {}
}
