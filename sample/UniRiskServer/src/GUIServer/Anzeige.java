package GUIServer;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Anzeige {

    private Scene sceneStart, sceneSpielAnlegen, sceneSpielLaden, sceneLobby;

    //Elemente in Start Scene
    private Label labelUniRisk;
    private Label ipAdresse;
    private Button neuesSpielAnlegen;
    private Button spielLaden;

    //Elemente in SpielAnlegen Scene
    private Label spielerAnzahl;
    private TextField spielerAnzahlEingabe;
    private Button spielAnlegen;

    //Elemente in SpielLaden Scene
    private Label ausgewaehlteDatei;
    private Label benoetigteMitspieler;
    private Button laden;
    private Button dateiAuswaehlen;

    //Elemente in Lobby Scene
    private Label nameSpieler1;
    private Label nameSpieler2;
    private Label nameSpieler3;
    private Label nameSpieler4;
    private Label nameSpieler5;

    private Label ipSpieler1;
    private Label ipSpieler2;
    private Label ipSpieler3;
    private Label ipSpieler4;
    private Label ipSpieler5;

    private Label bereitSpieler1;
    private Label bereitSpieler2;
    private Label bereitSpieler3;
    private Label bereitSpieler4;
    private Label bereitSpieler5;

    private Button spielStarten;



    public void showStart(Stage primaryStage) {
        primaryStage.setTitle("Server Anwendung");
        primaryStage.setScene(sceneStart);
        primaryStage.show();
    }
    public void showSpielStarten(Stage primaryStage) {
        primaryStage.setTitle("Neues Spiel anlegen");
        primaryStage.setScene(sceneSpielAnlegen);
        primaryStage.show();
    }
    public void showSpielLaden(Stage primaryStage) {
        primaryStage.setTitle("Spiel laden");
        primaryStage.setScene(sceneSpielLaden);
        primaryStage.show();
    }
    public void showLobby(Stage primaryStage) {
        primaryStage.setTitle("Lobby(Host)");
        primaryStage.setScene(sceneLobby);
        primaryStage.show();
    }
}
