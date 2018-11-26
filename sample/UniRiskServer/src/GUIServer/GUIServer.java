package GUIServer;

import KommunikationServer.KommunikationServer;
import Spieldaten.Spieldaten;
import Spiellogik.Spiellogik;
import javafx.application.Application;
import javafx.stage.Stage;


public class GUIServer extends Application implements IGUIServerCallback {
    private Controller controller;
    public KommunikationServer kommunikation;
    public Spieldaten spieldaten;
    public Spiellogik logik;
    private DatenModell daten;
    public static void main(String[] args) {
        launch(args);
    }





    @Override
    public void start(Stage primaryStage) {
        kommunikation = new KommunikationServer();
        spieldaten = new Spieldaten();
        logik = new Spiellogik();

        daten = new DatenModell(primaryStage);
        controller = new Controller(daten, spieldaten, logik);
        controller.showLobby();
    }

    @Override
    public boolean aktualisierung() {

        return controller.datenModellAktualisieren();
    }
}
