/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import calculator.Entity.*;

/**
 *
 * @author Admin
 */
public final class CalculatorController implements Initializable {

    @FXML
    public TextArea StackTextArea;
    @FXML
    public TextArea VariablesTextArea;
    @FXML
    private Button toggleStackButton;
    @FXML
    private ToggleButton toggleMemoryButton;
    @FXML
    private TextField main_textfield;
    @FXML
    private SplitPane split_line;
    @FXML
    private Button ADD_Button;

    private Stage primaryStage;
    private boolean isWindowExpanded = false;
    private boolean isMemoryExpanded = false;
    private boolean all_keys_disabled = false;
    private double saved_percentage = 0.25;
    private Stack stack;
    private BufferVariable bufVariable;
    private CalculatorModel model;

   @Override
    public void initialize(URL url, ResourceBundle rb) {
        stack = new Stack(StackTextArea);
        bufVariable = new BufferVariable(VariablesTextArea);
        model = new CalculatorModel(stack, bufVariable, this);
        ADD_Button.requestFocus();

        SplitPane.Divider divider = split_line.getDividers().get(0);

        divider.positionProperty().addListener((observable, oldvalue, newvalue) -> {
            if (isMemoryExpanded) {
                divider.setPosition(saved_percentage);
            } else {
                divider.setPosition(0.0);
            }
        });
    }

    @FXML
    public void handleTextedButton(ActionEvent event) {
        if (all_keys_disabled) {
            return;
        }

        ADD_Button.requestFocus();

        Button btn = (Button) event.getSource();

        if (main_textfield.getText().equals("0") && !btn.getText().equals(".") && !btn.getText().equals("0")) {
            main_textfield.setText(btn.getText());
        } else {
            main_textfield.setText(main_textfield.getText() + btn.getText());
        }
    }

    @FXML
    private void clearTextfield(ActionEvent event) {
        if (all_keys_disabled) {
            return;
        }

        ADD_Button.requestFocus();
        main_textfield.setText("");
    }

    @FXML
    public void handleOperationsButton(ActionEvent event) throws ErrorHandler {
        if (all_keys_disabled) {
            return;
        }
        //NON CI SONO OPERAZIONI DA EFFETTUARE SE LO STACK Ă¨ VUOTO
        if (stack.isEmpty()) {
            throw new ErrorHandler("The stack is empty!", 1);
        }

        //CONTROLLO SE NELLO STACK CI STA ALMENO UN OPERATORE
        boolean operators_exists = false;
        for (String item : stack.getStack()) {
            if (model.isValidOperator(item)) {
                operators_exists = true;
            }
        }
        if (!operators_exists) {
            throw new ErrorHandler("No valid operation in the stack.", 1);
        }

        //ESEGUO TUTTE LE OPERAZIONI 
        model.executeOperations();

        //PULISCO L'AREA DI TESTO
        main_textfield.setText("");
    }

    @FXML
    public void addToStack(ActionEvent event) throws ErrorHandler {
        if (all_keys_disabled) {
            return;
        }
        //ottiene il testo dall'area di testo
        String temp_string = main_textfield.getText();
        //ripulisce il testo
        String cleaned_temp_string = temp_string.replaceAll(" ", "").toLowerCase();

        if (cleaned_temp_string.equals("+j") || cleaned_temp_string.equals("-j")) {
            int scelta = model.showAChoiceDialogue();
            if (scelta == 2 && model.isValidComplexNumber(temp_string)) {
                main_textfield.setText("");

                stack.push(model.clearComplexNumber(temp_string));
            } else if (scelta == 1 && model.isValidVariable(temp_string)) {
                model.handleVariables(model.clearVariable(temp_string));
                main_textfield.setText("");
            }
        } else {
            main_textfield.setText("");

            if (model.isValidOperator(temp_string) || model.isValidComplexNumber(temp_string)) {
                stack.push((model.clearComplexNumber(temp_string)));

            } else if (model.isValidVariable(temp_string)) {
                model.handleVariables(model.clearVariable(temp_string));
            } else {
                throw new ErrorHandler("Invalid complex number or operator", 2);
            }
        }
    }

      @FXML
    public void handleStackWindowButtonAction() {
        ADD_Button.requestFocus();
        if (isWindowExpanded) {
            contractWindow();
        } else {
            expandWindow();
        }
        isWindowExpanded = !isWindowExpanded;
        toggleStackButton.setText(isWindowExpanded ? "≪" : "≫");
    }

    @FXML
    public void handleMemoryWindowButtonAction(ActionEvent event) {
        ADD_Button.requestFocus();
        if (isMemoryExpanded) {
            contractWindow();
            split_line.setDividerPositions(0.0);
        } else {
            expandWindow();
            double percentage = (278.0 / (split_line.getWidth())) + 0.003;
            saved_percentage = percentage;
            split_line.setDividerPositions(percentage);
        }
        isMemoryExpanded = !isMemoryExpanded;
        toggleMemoryButton.setText(isMemoryExpanded ? "≫ A-Z Memory ≫" : "≪ A-Z Memory ≪");
    }

    @FXML
    private void handleStackButtons(ActionEvent event) {
    }
       public void expandWindow() {
        double currentWidth = primaryStage.getWidth();
        primaryStage.setWidth(currentWidth + 278);
    }

    public void contractWindow() {
        double currentWidth = primaryStage.getWidth();
        // Impedisci che la finestra diventi più piccola della larghezza iniziale
        if (currentWidth > 299) {
            primaryStage.setWidth(currentWidth - 278);
        }
    }
      public TextField getMainTextField() {
        return main_textfield;
    }

    public String getMainTextFieldText() {
        return main_textfield.getText();
    }

    public void setMainTextFieldText(String text) {
        main_textfield.setText(text);
    }

    public void enableDisableAllKeys(boolean Disabled) {
        all_keys_disabled = Disabled;
    }

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

}
