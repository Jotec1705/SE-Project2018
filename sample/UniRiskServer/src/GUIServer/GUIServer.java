package GUIServer;

import KommunikationServer.KommunikationServer;
import Spieldaten.Spieldaten;
import Spiellogik.Spiellogik;
import javafx.application.Application;
import javafx.application.Platform;
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
        logik.beobachterHinzufuegen(this);
        kommunikation = new KommunikationServer();
        kommunikation.setSpiellogik(logik);
        kommunikation.setAnzeige(spieldaten);
        kommunikation.main();
        daten = new DatenModell(primaryStage);
        controller = new Controller(daten, spieldaten, logik);
        controller.showStart();

    }

    @Override
    public boolean aktualisierung() {

        Platform.runLater(()->{
            if(daten.getPrimaryStage().getTitle().equals("Spiel laden")){
                controller.datenModellAktualisierenSpielLaden();
        }
            //if(daten.getPrimaryStage().getTitle().equals("Lobby(Host)")){
                controller.datenModellAktualisierenLobby();
            /*}*/});

         return true;
    }
}
