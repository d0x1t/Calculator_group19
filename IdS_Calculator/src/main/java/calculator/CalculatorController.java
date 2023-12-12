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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ACER
 */
public class CalculatorController implements Initializable {

    @FXML
    private SplitPane split_line;
    @FXML
    private TextArea VariablesTextArea;
    @FXML
    private Button ADD_Button;
    @FXML
    private ToggleButton toggleMemoryButton;
    @FXML
    private Button toggleStackButton;
    @FXML
    private TextArea StackTextArea;
    @FXML
    private TextField main_textfield;
   
    private Stage primaryStage;
    @FXML
    private Button button0;
    @FXML
    private Button button1;
    @FXML
    private Button button4;
    @FXML
    private Button button7;
    @FXML
    private Button button5;
    @FXML
    private Button button2;
    @FXML
    private Button button9;
    @FXML
    private Button button6;
    @FXML
    private Button button3;
    @FXML
    private Button button8;

    /**
     * Initializes the controller class.
     */
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
    private void handleMemoryWindowButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleStackWindowButtonAction(ActionEvent event) {
    }

    @FXML
    private void handleStackButtons(ActionEvent event) {
    }
       public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }
    
}
