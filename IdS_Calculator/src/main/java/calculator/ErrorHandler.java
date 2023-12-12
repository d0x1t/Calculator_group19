package calculator;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.scene.control.TextField;


public class ErrorHandler extends Exception {
    public ErrorHandler() {
        DisplayMessage("Generic error", 1);
    }

    public ErrorHandler(String errorMessage, int seconds) {
        super(errorMessage);

        if (errorMessage == null || seconds <= 0) {
            return;
        }

        DisplayMessage(errorMessage, 1);
    }


   private void resetTextFieldAfterDelay(TextField textField, String initialText, long delay, TimeUnit unit) {
    }

    private void displayMessage(String message, long seconds) {


    }
}
