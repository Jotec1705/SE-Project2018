package GUIServer;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUIServer extends Application implements IGUIServerCallback {
    private Controller controller;

    public static void main(String[] args) {
        launch(args);
    }





    @Override
    public void start(Stage primaryStage) {
        DatenModell daten = new DatenModell(primaryStage);

        controller = new Controller(daten);
        controller.showLobby();
    }

    @Override
    public boolean aktualisierung() {

        return controller.datenModellAktualisieren();
    }
}
