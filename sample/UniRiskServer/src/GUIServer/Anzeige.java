package GUIServer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
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
    private Text benoetigteMitspielerText;

    //Elemente in Start Scene
    private GridPane gridStart;
    private Label ipAdresseServer;
    private Button neuesSpielAnlegen;
    private Button spielLaden;

    //Elemente in SpielAnlegen Scene
    GridPane gridSpielAnlegen;
    private TextField spielerAnzahlEingabe;
    private Button spielAnlegen;

    //Elemente in SpielLaden Scene
    GridPane gridSpielLaden;
    private Label ausgewaehlteDatei;
    private Button laden;
    private Button dateiAuswaehlen;
    private ListView<String> benoetigteMitspieler;
    private ObservableList<String> items;

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
        GridPane.setHalignment(uniRisk, HPos.CENTER);
        gridStart.add(uniRisk,0,0, 2, 1);

        neuesSpielAnlegen = new Button("Neues Spiel anlegen");
        spielLaden = new Button("Spiel laden");
        gridStart.add(neuesSpielAnlegen, 0, 2, 1, 1);
        gridStart.add(spielLaden, 1, 2, 1,  1);

        ipAdresseServer = new Label("Server IP : ");
        ipAdresseServer.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        gridStart.add(ipAdresseServer, 0, 3, 2, 1);

        sceneStart = new Scene(gridStart, 400, 150);
        //Layout Spiel anlegen Scene
        gridSpielAnlegen = new GridPane();
        gridSpielAnlegen.setAlignment(Pos.TOP_CENTER);
        gridSpielAnlegen.setHgap(10);
        gridSpielAnlegen.setVgap(10);
        gridSpielAnlegen.setPadding(new Insets(10, 10, 10, 10));

        gridSpielAnlegen.add(uniRisk,0, 0, 3, 1);

        spielerAnzahl = new Text("Spieler Anzahl : ");
        gridSpielAnlegen.add(spielerAnzahl,0, 1, 1,1);

        spielerAnzahlEingabe = new TextField();
        spielerAnzahlEingabe.setMinWidth(15);
        spielerAnzahlEingabe.setMaxWidth(30);
        gridSpielAnlegen.add(spielerAnzahlEingabe, 1,1,1,1);

        spielAnlegen = new Button("Spiel anlegen");
        gridSpielAnlegen.add(spielAnlegen,2, 1, 1, 1);

        sceneSpielAnlegen = new Scene(gridSpielAnlegen, 400, 150);
        //Layout Spiel laden Scene
        gridSpielLaden = new GridPane();
        gridSpielLaden.setAlignment(Pos.TOP_CENTER);
        gridSpielLaden.setHgap(10);
        gridSpielLaden.setVgap(10);
        gridSpielLaden.setPadding(new Insets(10, 10, 10, 10));

        gridSpielLaden.add(uniRisk,0, 0, 3, 1);

        dateiAuswaehlen = new Button("Datei auswählen");
        gridSpielLaden.add(dateiAuswaehlen,0, 1, 1, 1);

        laden = new Button("Spiel laden");
        gridSpielLaden.add(laden,1, 1, 1, 1);

        ausgewaehlteDatei = new Label("Ausgewählte Datei : ");
        ausgewaehlteDatei.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        GridPane.setValignment(ausgewaehlteDatei, VPos.TOP );
        gridSpielLaden.add(ausgewaehlteDatei,0, 2, 1, 1);

        benoetigteMitspielerText = new Text("Benötigte Mitspieler");
        benoetigteMitspieler = new ListView<>();
        items = FXCollections.observableArrayList(benoetigteMitspielerText.getText(),"","","","","");
        benoetigteMitspieler.setItems(items);
        gridSpielLaden.add(benoetigteMitspieler,1,2,1,1);

        sceneSpielLaden = new Scene(gridSpielLaden, 500, 250);
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

    public void setIpAdresseServer(String ipAdresseServer) {
        this.ipAdresseServer.setText(ipAdresseServer);
    }

    public String getspielerAnzahlEingabe(){
        return spielerAnzahlEingabe.getText();
    }

    public Button getLaden() {
        return laden;
    }

    public Button getDateiAuswaehlen() {
        return dateiAuswaehlen;
    }

    public Button getSpielStarten() {
        return spielStarten;
    }

    public void setAusgewaehlteDatei(String ausgewaehlteDatei) {
        this.ausgewaehlteDatei.setText(ausgewaehlteDatei);
    }

    public void setBenoetigteMitspieler(String[] spielerNamen){
        items = FXCollections.observableArrayList(spielerNamen);
        benoetigteMitspieler.setItems(items);
    }
}
