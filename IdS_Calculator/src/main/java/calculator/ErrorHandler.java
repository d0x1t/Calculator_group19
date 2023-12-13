package calculator;
import java.util.concurrent.TimeUnit;
import javafx.application.Platform;
import javafx.scene.control.TextField;


public class ErrorHandler extends Exception {
    public class ErrorHandler extends Exception {

    private void resetTextFieldAfterDelay(TextField textField, String initialText, long delay, TimeUnit unit) {
        if (textField == null || initialText == null || delay <= 0 || CalculatorView.controller == null) {
            return;
        }

        CalculatorView.scheduler.schedule(() -> {
            Platform.runLater(() -> {
                CalculatorView.controller.enableDisableAllKeys(false);
                textField.setText(initialText);
            });
        }, delay, unit);
    }

    private void displayMessage(String message, long seconds) {
        if (message == null || seconds <= 0 || CalculatorView.controller == null) {
            return;
        }

        CalculatorView.controller.enableDisableAllKeys(true);
        String bak_string = CalculatorView.controller.getMainTextFieldText();
        CalculatorView.controller.setMainTextFieldText(message);
        resetTextFieldAfterDelay(CalculatorView.controller.getMainTextField(), bak_string, seconds, TimeUnit.SECONDS);

    }

    public ErrorHandler() {
        displayMessage("Generic error", 1);
    }

    public ErrorHandler(String errorMessage, int seconds) {
        super(errorMessage);

        if (errorMessage == null || seconds <= 0) {
            return;
        }

        displayMessage(errorMessage, 1);
    }

}
