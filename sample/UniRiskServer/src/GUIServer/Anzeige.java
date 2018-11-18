package GUIServer;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class Anzeige {

    private Scene sceneStart, sceneSpielAnlegen, sceneSpielLaden, sceneLobby;
    private Text uniRisk;
    private Text spielerAnzahl;

    //Elemente in Start Scene
    private GridPane gridStart;
    private Label ipAdresseServer;
    private Button neuesSpielAnlegen;
    private Button spielLaden;

    //Elemente in SpielAnlegen Scene
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

    public Anzeige(){
        //Layout Start Scene
        gridStart = new GridPane();
        gridStart.setAlignment(Pos.TOP_CENTER);
        gridStart.setHgap(10);
        gridStart.setVgap(10);
        gridStart.setPadding(new Insets(10, 10, 10, 10));

        uniRisk = new Text("UniRisk");
        uniRisk.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridStart.add(uniRisk,0,0, 1, 1);

        neuesSpielAnlegen = new Button("Neues Spiel anlegen");
        spielLaden = new Button("Spiel laden");
        gridStart.add(neuesSpielAnlegen, 0, 1, 2, 2);
        gridStart.add(spielLaden, 1, 1, 3,  2);

        sceneStart = new Scene(gridStart, 500, 500);
        //Layout Spiel anlegen Scene

        //Layout Spiel laden Scene

        //Layout Lobby

    }


    public void showStart(Stage primaryStage) {
        primaryStage.setTitle("Server Anwendung");
        primaryStage.setScene(sceneStart);
        primaryStage.show();
    }
    public void showSpielAnlegen(Stage primaryStage) {
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
