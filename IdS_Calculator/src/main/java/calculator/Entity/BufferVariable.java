/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 *
 * @author ACER
 */
public class BufferVariable {
    private  Map<Character, String> variables;
    private TextArea textArea;
    public BufferVariable(TextArea textArea) {
        variables = new HashMap<>();
        this.textArea=textArea;
        
    }
    
    public Map<Character, String> GetVariablesMap(){
        return variables;
    }
        public String valueVariable(char variableName) {
        return variables.get(variableName); 
        
    }
    public void storeVariable(char variableName, String value) {
            variables.put(variableName, value); 
            updateTextArea();
            
    }
    public void updateTextArea(){
        StringBuilder sb = new StringBuilder();
        // Itera le variabili dalla prima all'ultima
        for (int i = 'a'; i <= 'z'; i++) {
            String complex_number = this.variables.get((char)i);
            if (complex_number != null)
                sb.append((char)i).append(": ").append(complex_number).append("\n");
        }
        String text = sb.toString();
        
        if (text == null || textArea == null) return;

        // Aggiorna la TextArea sul thread dell'interfaccia utente
        Platform.runLater(() -> textArea.setText(text));
    }
}
