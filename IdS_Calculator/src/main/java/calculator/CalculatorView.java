package calculator;

import java.util.Locale;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 *
 * @author Admin
 */
public class CalculatorView extends Application {

    public static CalculatorController controller;
    public static ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    @Override
    public void start(Stage stage) throws Exception {

        // Carica il file FXML e ottiene il controller
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorView.class.getResource("primary.fxml"));
        Parent root = fxmlLoader.load();
        stage.setTitle("Complex Calculator");
        // Ottieni il controller e passa la referenza dello Stage
        controller = fxmlLoader.getController();
        controller.setPrimaryStage(stage);

        stage.setResizable(false);

        Scene scene = new Scene(root, 375, 241);
        stage.setScene(scene);
        stage.show();

    }

    @Override
    public void stop() {
        if (scheduler != null) {
            scheduler.shutdownNow();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Imposta il Locale predefinito su inglese (sostituisce tutte le virgole europee con i punti americani nei decimali)
        Locale.setDefault(Locale.ENGLISH);
        controller = new CalculatorController();

        launch(args);
    }

}
