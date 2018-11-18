package GUIServer;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUIServer extends Application implements IGUIServerCallback {
    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public boolean aktualisierung() {

        return false;
    }

    @Override
    public void start(Stage primaryStage) {
        DatenModell daten = new DatenModell(primaryStage);

        Controller controller = new Controller(daten);
        controller.showStart();
    }
}
