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

        spieldaten = new Spieldaten();
        logik = new Spiellogik();
        logik.setSpieldaten(spieldaten);
        kommunikation = new KommunikationServer();
        kommunikation.setSpiellogik(logik);
        kommunikation.setAnzeige(spieldaten);
        daten = new DatenModell(primaryStage);
        controller = new Controller(daten, spieldaten, logik);
        controller.showStart();
    }

    @Override
    public boolean aktualisierung() {
         if(daten.getPrimaryStage().getTitle() == "Spiel laden"){
             return controller.datenModellAktualisierenSpielLaden();
         }
         if(daten.getPrimaryStage().getTitle() == "Lobby(Host)"){
             return controller.datenModellAktualisierenLobby();
         }
         return true;
    }
}
