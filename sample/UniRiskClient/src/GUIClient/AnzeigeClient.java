package GUIClient;

import KommunikationClient.ClientKommunikationNachServer;
import GUIClient.ControllerClient.Slots;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AnzeigeClient {
    public ClientKommunikationNachServer kommunikation;
    public void setClientKommunikation(ClientKommunikationNachServer kommunikation){
        this.kommunikation = kommunikation;
    }

    private Scene sceneAnmelden;
    private Scene sceneLobby;
    private Scene scenePopupBonuskarten;
    private Scene sceneKarte;
    private Scene sceneAngriff;
    private Scene scenePopupWuerfelnAngreifer;
    private Scene scenePopupWuerfelnVerteidiger;
    private Scene scenePopupVerschiebenVonNach;

    private String nameSpieler = null;
    private String passwort = null;
    private String ipAdresse = null;

    private Button anmelden;
    private Button bereit;
    private Button aussteigen;

    private TextField nameEingabe;
    private TextField pwdEingabe;
    private TextField ipEingabe;

    private ObservableList<Slots> slots;
    private TableView tabelle;


    public AnzeigeClient(){

        //ANMELDEN-DIALOG:-------------------------------------------------------------------------------
        GridPane gridPaneAnmelden = new GridPane();
        gridPaneAnmelden.setAlignment(Pos.TOP_CENTER);
        gridPaneAnmelden.setHgap(10);
        gridPaneAnmelden.setVgap(10);
        gridPaneAnmelden.setMinSize(450, 200);
        gridPaneAnmelden.setMaxSize(450, 200);
        gridPaneAnmelden.setPadding(new Insets(10, 10, 10, 10));

        Text uniRisk = new Text("UniRisk");
        uniRisk.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(uniRisk, HPos.CENTER);

        gridPaneAnmelden.add(uniRisk, 0, 0, 4, 1);

        Text name = new Text("Benutzername:");
        nameEingabe = new TextField();
        Text pwd = new Text("Passwort:");
        pwdEingabe = new TextField();
        Text ip = new Text("Server IP:");
        ipEingabe = new TextField();
        gridPaneAnmelden.add(name, 0, 2, 1, 1);
        gridPaneAnmelden.add(nameEingabe, 1, 2, 1, 1);
        gridPaneAnmelden.add(pwd, 0, 3, 1, 1);
        gridPaneAnmelden.add(pwdEingabe, 1, 3, 1, 1);
        gridPaneAnmelden.add(ip, 2, 2, 1, 1);
        gridPaneAnmelden.add(ipEingabe, 3, 2, 1, 1);

        anmelden = new Button("Am Server anmelden");
        GridPane.setHalignment(anmelden, HPos.CENTER);
        gridPaneAnmelden.add(anmelden, 2, 4, 2, 1);

        sceneAnmelden = new Scene(gridPaneAnmelden, 450, 200);

        //LOBBY-CLIENT:-------------------------------------------------------------------------------------
        GridPane gridLobby = new GridPane();
        gridLobby.setAlignment(Pos.TOP_CENTER);
        gridLobby.setHgap(10);
        gridLobby.setVgap(10);
        gridLobby.setPadding(new Insets(5, 5, 5, 5));

        tabelle = new TableView();
        tabelle.setEditable(true);
        tabelle.setMinSize(250, 200);

        TableColumn ipAdresse = new TableColumn("IP-Adresse");
        TableColumn spielerName = new TableColumn("Name");
        TableColumn status = new TableColumn("Status");
        tabelle.getColumns().addAll(ipAdresse, spielerName, status);
        GridPane.setHalignment(tabelle, HPos.CENTER);
        gridLobby.add(tabelle,0, 0, 4, 1);

        bereit = new Button("Bereit");
        aussteigen = new Button("Aussteigen");
        bereit.setStyle("-fx-background-color: LIGHTGREEN");
        aussteigen.setStyle("-fx-background-color: TOMATO");
        GridPane.setHalignment(bereit, HPos.CENTER);
        GridPane.setHalignment(aussteigen, HPos.CENTER);
        gridLobby.add(bereit, 0, 1 ,2 ,1);
        gridLobby.add(aussteigen, 2, 1, 2, 1);

        sceneLobby = new Scene(gridLobby, 400, 250);

        //POPUP-BONUSKARTEN:---------------------------------------------------------------------------------
        GridPane bonuskarten = new GridPane();
        bonuskarten.setAlignment(Pos.TOP_CENTER);
        bonuskarten.setHgap(10);
        bonuskarten.setVgap(10);
        bonuskarten.setMinSize(550,270);
        bonuskarten.setMaxSize(550,270);
        bonuskarten.setPadding(new Insets(10, 10, 10, 10));

        Image ersties = new Image(getClass().getResourceAsStream("fragezeichen.png"));
        Image studenten = new Image(getClass().getResourceAsStream("ausrufezeichen.png"));
        Image professoren = new Image(getClass().getResourceAsStream("professor.png"));
        ImageView imageViewErsties = new ImageView(ersties);
        ImageView imageViewStudenten = new ImageView(studenten);
        ImageView imageViewProfessoren = new ImageView(professoren);
        TextField anzahlErsties = new TextField();
        anzahlErsties.setMaxWidth(50);
        GridPane.setHalignment(anzahlErsties, HPos.CENTER);
        TextField anzahlStudenten = new TextField();
        anzahlStudenten.setMaxWidth(50);
        GridPane.setHalignment(anzahlStudenten, HPos.CENTER);
        TextField anzahlProfessoren = new TextField();
        anzahlProfessoren.setMaxWidth(50);
        GridPane.setHalignment(anzahlProfessoren, HPos.CENTER);
        Button tauschen = new Button("tauschen");
        tauschen.setStyle("-fx-background-color: LIGHTGREEN");
        GridPane.setHalignment(tauschen, HPos.CENTER);

        bonuskarten.add(imageViewErsties, 0,0, 1, 1);
        bonuskarten.add(imageViewStudenten, 1,0,1,1);
        bonuskarten.add(imageViewProfessoren, 2, 0, 1, 1);
        bonuskarten.add(anzahlErsties, 0, 1, 1, 1);
        bonuskarten.add(anzahlStudenten, 1, 1, 1, 1);
        bonuskarten.add(anzahlProfessoren, 2, 1, 1, 1);
        bonuskarten.add(tauschen, 0, 2, 4, 1);

        scenePopupBonuskarten = new Scene(bonuskarten);
    }

    public void showAnmelden(Stage stage){
        stage.setTitle("Client Anwendung");
        stage.setResizable(false);
        stage.setScene(sceneAnmelden);
        stage.show();
    }

    public void showLobbyClient(Stage stage){
        stage.setTitle("Lobby (Client)");
        stage.setResizable(false);
        stage.setScene(sceneLobby);
        stage.show();
    }

    public void showBonuskarten(Stage stage){
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialog.setTitle("Bonuskarten eintauschen");
        dialog.setResizable(false);
        dialog.setScene(scenePopupBonuskarten);
        dialog.show();
    }

    public void showKarte(Stage stage){
        stage.setTitle("UniRisk");
        stage.setResizable(false);
        stage.setScene(sceneKarte);
        stage.show();
    }

    public void getKartenScene(Scene sceneKarte){
        this.sceneKarte = sceneKarte;
    }

    public Button getSpielerAnmelden(){
        return anmelden;
    }

    public Button getSpielerBereit(){
        return bereit;
    }

    public boolean getBereit(){
        return kommunikation.spielerBereitMelden(nameSpieler);
    }

    public boolean getAusgestiegen(){
        return kommunikation.spielerAusgestiegen(nameSpieler);
    }

    public Button getSpielerAusgestiegen(){
        return aussteigen;
    }

    public boolean getAngemeldet(){
        nameSpieler = nameEingabe.getText();
        passwort = pwdEingabe.getText();
        ipAdresse = ipEingabe.getText();
        return kommunikation.spielerAnmelden(nameSpieler, passwort, ipAdresse);
    }

    public  void getErstiesAnzahl(Integer ID){
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler);
    }

    public void setSlots(ObservableList<Slots> slots) {
        this.slots = slots;
        tabelle.setItems(this.slots);
    }
}
