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
import Entity.*;

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
    }

    @FXML
    private void handleOperationsButton(ActionEvent event) {
    }

    @FXML
    private void addToStack(ActionEvent event) {
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
