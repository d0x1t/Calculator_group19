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
        // TODO
    }    

    @FXML
    private void handleTextedButton(ActionEvent event) {
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
