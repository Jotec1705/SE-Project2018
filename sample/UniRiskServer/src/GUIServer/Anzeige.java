package GUIServer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.stage.Window;
import GUIServer.Controller.Slots;

public class Anzeige {

    private Scene sceneStart, sceneSpielAnlegen, sceneSpielLaden, sceneLobby;
    private Text uniRisk1;
    private Text uniRisk2;
    private Text uniRisk3;
    private Text spielerAnzahl;
    private Text benoetigteMitspielerText;

    //Elemente in Start Scene
    private GridPane gridStart;
    private Label ipAdresseServer;
    private Button neuesSpielAnlegen;
    private Button spielLaden;

    //Elemente in SpielAnlegen Scene
    private GridPane gridSpielAnlegen;
    private TextField spielerAnzahlEingabe;
    private Button spielAnlegen;

    //Elemente in SpielLaden Scene
    private GridPane gridSpielLaden;
    private Label ausgewaehlteDatei;
    private Button laden;
    private Button dateiAuswaehlen;
    private ListView<String> benoetigteMitspieler;
    private ObservableList<String> items;

    //Elemente in Lobby Scene
    private GridPane gridLobby;
    private TableView tabelle;
    private ObservableList<Slots> slots;
    private TableColumn ipAdresse;
    private TableColumn spielerName;
    private TableColumn status;

    private Button spielStarten;

    public Anzeige(){
        //Layout Start Scene
        gridStart = new GridPane();
        gridStart.setAlignment(Pos.TOP_CENTER);
        gridStart.setHgap(10);
        gridStart.setVgap(10);
        gridStart.setPadding(new Insets(10, 10, 10, 10));

        uniRisk1 = new Text("UniRisk");
        uniRisk1.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(uniRisk1, HPos.CENTER);
        gridStart.add(uniRisk1,0,0, 3, 1);

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

        uniRisk2 = new Text("UniRisk");
        uniRisk2.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(uniRisk2, HPos.CENTER);
        gridSpielAnlegen.add(uniRisk2,0, 0, 3, 1);

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
        gridSpielLaden.setPadding(new Insets(5, 5, 5, 5));

        uniRisk3 = new Text("UniRisk");
        uniRisk3.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(uniRisk3, HPos.CENTER);
        gridSpielLaden.add(uniRisk3,0, 0, 3, 1);

        dateiAuswaehlen = new Button("Datei auswählen");
        gridSpielLaden.add(dateiAuswaehlen,0, 1, 1, 1);

        laden = new Button("Spiel laden");
        gridSpielLaden.add(laden,1, 1, 1, 1);

        ausgewaehlteDatei = new Label("Ausgewählte Datei : \n");
        ausgewaehlteDatei.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
        GridPane.setValignment(ausgewaehlteDatei, VPos.TOP );
        gridSpielLaden.add(ausgewaehlteDatei,0, 3, 1, 1);

        benoetigteMitspielerText = new Text("Benötigte Mitspieler");
        benoetigteMitspielerText.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
        GridPane.setHalignment(benoetigteMitspielerText, HPos.CENTER);
        gridSpielLaden.add(benoetigteMitspielerText, 1, 2, 2, 1);

        benoetigteMitspieler = new ListView<>();
        benoetigteMitspieler.setMaxHeight(120);
        benoetigteMitspieler.setMaxWidth(250);
        benoetigteMitspieler.setMinWidth(200);
        items = FXCollections.observableArrayList("","","","","");
        benoetigteMitspieler.setItems(items);
        gridSpielLaden.add(benoetigteMitspieler,1,3,1,1);

        sceneSpielLaden = new Scene(gridSpielLaden, 400, 250);
        //Layout Lobby
        gridLobby = new GridPane();
        gridLobby.setAlignment(Pos.TOP_CENTER);
        gridLobby.setHgap(10);
        gridLobby.setVgap(10);
        gridLobby.setPadding(new Insets(5, 5, 5, 5));

        tabelle = new TableView();
        tabelle.setEditable(true);

        ipAdresse = new TableColumn("IP-Adresse");
        spielerName = new TableColumn("Name");
        status = new TableColumn("Status");
        tabelle.getColumns().addAll(ipAdresse, spielerName, status);
        gridLobby.add(tabelle,0, 0, 1, 1);

        spielStarten = new Button("Spiel starten");
        GridPane.setHalignment(spielStarten, HPos.CENTER);
        gridLobby.add(spielStarten, 0, 1 ,1 ,1);

        sceneLobby = new Scene(gridLobby, 400, 250);
    }



    public void showStart(Stage primaryStage) {
        primaryStage.setTitle("Server Anwendung");
        primaryStage.setMinWidth(420);
        primaryStage.setMaxWidth(420);
        primaryStage.setMaxHeight(285);
        primaryStage.setMinHeight(285);
        primaryStage.setScene(sceneStart);
        primaryStage.show();
    }
    public void showSpielAnlegen(Stage primaryStage) {
        primaryStage.setTitle("Neues Spiel anlegen");
        primaryStage.setMinWidth(420);
        primaryStage.setMaxWidth(420);
        primaryStage.setMaxHeight(285);
        primaryStage.setMinHeight(285);
        primaryStage.setScene(sceneSpielAnlegen);
        primaryStage.show();
    }
    public void showSpielLaden(Stage primaryStage) {
        primaryStage.setTitle("Spiel laden");
        primaryStage.setMinWidth(420);
        primaryStage.setMaxWidth(420);
        primaryStage.setMaxHeight(285);
        primaryStage.setMinHeight(285);
        primaryStage.setScene(sceneSpielLaden);
        primaryStage.show();
    }
    public void showLobby(Stage primaryStage) {
        primaryStage.setTitle("Lobby(Host)");
        primaryStage.setMinWidth(420);
        primaryStage.setMaxWidth(420);
        primaryStage.setMaxHeight(285);
        primaryStage.setMinHeight(285);
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

    public void setBenoetigteMitspieler(ObservableList<String> namen){
        this.items = namen;
        benoetigteMitspieler.setItems(this.items);
    }

    public void setSlots(ObservableList<Slots> slots) {
        this.slots = slots;
        tabelle.setItems(this.slots);
    }
}
