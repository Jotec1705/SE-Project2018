package GUIClient;

import KommunikationClient.IClientKommunikation;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class AnzeigeClient {
    public IClientKommunikation kommunikation;
    //Erstellt das Objekt Hannes oder ich?
    public void setClientKommunikation(IClientKommunikation kommunikation){
        this.kommunikation = kommunikation;
    }

    private Scene sceneAnmelden;
    private Scene sceneLobby;
    private Scene sceneKarte;
    private Scene scenePopupBonuskarten;
    private Scene sceneAngriff;
    private Scene scenePopupWuerfelnAngreifer;
    private Scene scenePopupWuerfelnVerteidiger;
    private Scene scenePopupVerschiebenVonNach;

    private Parent karte;

    private String nameSpieler = null;
    private String passwort = null;
    private String ipAdresse = null;
    private String nameSpieler1 = "Bob";
    private String nameSpieler2;
    private String nameSpieler3;
    private String nameSpieler4;
    private String nameSpieler5;
    private String phaseninfo = "Phase 1, du kannst Bonuskarten eintauschen, Angreifen, Verschieben oder deinen Zug beenden";
    private String time = "16:45";
    private String anzahlBersties = "1x";
    private String anzahlBstudenten = "0x";
    private String anzahlBprofessoren = "2x";
    private String anzahlZuVerteilen = "10x";
    private String textMissionskarte = "Alle Fachbereiche einnehmen";

    private Button anmelden;
    private Button bereit;
    private Button aussteigen;

    private TextField nameEingabe;
    private TextField pwdEingabe;
    private TextField ipEingabe;

    private boolean angemeldet;

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

        TableView tabelle = new TableView();
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
/*
    public void karte(FXMLLoader karteLoader) throws IOException {
        //BorderPane --> übergeordnete Unterteilung des Fensters:
        BorderPane borderPane = new BorderPane();

        //Parent für links, die komplette Karte:
        karte = karteLoader.load();
        //Parent karte = FXMLLoader.load(getClass().getResource("/GUIClient/Karte.fxml"));

        //GridPane rechts für Spieler und Farbgebung:
        GridPane rechts = new GridPane();
        rechts.setAlignment(Pos.TOP_LEFT);
        rechts.setHgap(10);
        rechts.setVgap(10);
        rechts.setMinSize(200, 730);
        rechts.setMaxSize(200, 730);
        rechts.setPadding(new Insets(35, 10, 10, 25));

        Text spieler = new Text("Spieler:");
        spieler.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        spieler.setUnderline(true);
        GridPane.setHalignment(spieler, HPos.CENTER);
        GridPane.setMargin(spieler, new Insets(0, 10, 10, 10));
        Text farbgebung = new Text("Farbgebung:");
        farbgebung.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        farbgebung.setUnderline(true);
        GridPane.setHalignment(farbgebung, HPos.CENTER);
        GridPane.setMargin(farbgebung, new Insets(40, 10, 10, 10));

        rechts.add(spieler, 0, 0, 3, 1);
        rechts.add(farbgebung, 0, 7, 3, 1);

        Text spieler1 = new Text(nameSpieler1);
        spieler1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Circle circle1 = new Circle();
        circle1.setRadius(10.0f);
        circle1.setFill(Color.DARKGREEN);
        GridPane.setMargin(spieler1, new Insets(5, 5, 5, 5));

        Text spieler2 = new Text(nameSpieler2);
        spieler2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Circle circle2 = new Circle();
        circle2.setRadius(10.0f);
        circle2.setFill(Color.PINK);
        GridPane.setMargin(spieler2, new Insets(5, 5, 5, 5));

        Text spieler3 = new Text(nameSpieler3);
        spieler3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Circle circle3 = new Circle();
        circle3.setRadius(10.0f);
        circle3.setFill(Color.DARKBLUE);
        GridPane.setMargin(spieler3, new Insets(5, 5, 5, 5));

        Text spieler4 = new Text(nameSpieler4);
        spieler4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Circle circle4 = new Circle();
        circle4.setRadius(10.0f);
        circle4.setFill(Color.YELLOW);
        GridPane.setMargin(spieler4, new Insets(5, 5, 5, 5));

        Text spieler5 = new Text(nameSpieler5);
        spieler5.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Circle circle5 = new Circle();
        circle5.setRadius(10.0f);
        circle5.setFill(Color.TURQUOISE);
        GridPane.setMargin(spieler5, new Insets(5, 5, 5, 5));

        Text etti = new Text("ETTI");
        //etti.setFill(Color.PINK);
        etti.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Circle circle11 = new Circle();
        circle11.setRadius(10.0f);
        circle11.setFill(Color.DARKGREEN);
        GridPane.setMargin(etti, new Insets(5, 5, 5, 5));

        Text spo = new Text("SPO");
        //spo.setFill(Color.PINK);
        spo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Circle circle22 = new Circle();
        circle22.setRadius(10.0f);
        circle22.setFill(Color.PINK);
        GridPane.setMargin(spo, new Insets(5, 5, 5, 5));

        Text wow = new Text("WOW");
        //wow.setFill(Color.DARKBLUE);
        wow.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Circle circle33 = new Circle();
        circle33.setRadius(10.0f);
        circle33.setFill(Color.DARKBLUE);
        GridPane.setMargin(wow, new Insets(5, 5, 5, 5));

        Text aero = new Text("Aero (Stg)");
        //aero.setFill(Color.YELLOW);
        aero.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Circle circle44 = new Circle();
        circle44.setRadius(10.0f);
        circle44.setFill(Color.YELLOW);
        GridPane.setMargin(aero, new Insets(5, 5, 5, 5));

        Text bau = new Text("BAU");
        //bau.setFill(Color.TURQUOISE);
        bau.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        Circle circle55 = new Circle();
        circle55.setRadius(10.0f);
        circle55.setFill(Color.TURQUOISE);
        GridPane.setMargin(bau, new Insets(5, 5, 5, 5));

        rechts.add(spieler1, 1, 1, 1, 1);
        rechts.add(spieler2, 1, 2, 1, 1);
        rechts.add(spieler3, 1, 3, 1, 1);
        rechts.add(spieler4, 1, 4, 1, 1);
        rechts.add(spieler5, 1, 5, 1, 1);
        rechts.add(circle1, 0, 1, 1, 1);
        rechts.add(circle2, 0, 2, 1, 1);
        rechts.add(circle3, 0, 3, 1, 1);
        rechts.add(circle4, 0, 4, 1, 1);
        rechts.add(circle5, 0, 5, 1, 1);
        rechts.add(etti, 1, 8, 1, 1);
        rechts.add(spo, 1, 9, 1, 1);
        rechts.add(wow, 1, 10, 1, 1);
        rechts.add(aero, 1, 11, 1, 1);
        rechts.add(bau, 1, 12, 1, 1);
        rechts.add(circle11, 0, 8, 1, 1);
        rechts.add(circle22, 0, 9, 1, 1);
        rechts.add(circle33, 0, 10, 1, 1);
        rechts.add(circle44, 0, 11, 1, 1);
        rechts.add(circle55, 0, 12, 1, 1);

        rechts.setStyle("-fx-background-color: #aaaaaa");

        //GridPane für die Buttonleiste:
        GridPane gridPane = new GridPane();
        gridPane.setMinSize(1200, 200);
        gridPane.setMaxSize(1200, 200);
        gridPane.setHgap(10);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(5, 5, 5, 5));
        gridPane.setAlignment(Pos.TOP_LEFT);

        Text phase = new Text("Phase: ");
        Text phasenbeschr = new Text();
        phasenbeschr.setText(phaseninfo);
        Text uhr = new Text("Uhrzeit: ");
        GridPane.setHalignment(uhr, HPos.RIGHT);
        Text uhrzeit = new Text();
        uhrzeit.setText(time);
        GridPane.setHalignment(uhrzeit, HPos.LEFT);
        Text bonuskarten = new Text("Bonuskarten:");
        GridPane.setHalignment(bonuskarten, HPos.CENTER);
        Text ersties = new Text();
        ersties.setText(anzahlBersties);
        GridPane.setHalignment(ersties, HPos.CENTER);
        Text studenten = new Text();
        studenten.setText(anzahlBstudenten);
        GridPane.setHalignment(studenten, HPos.CENTER);
        Text professoren = new Text();
        professoren.setText(anzahlBprofessoren);
        GridPane.setHalignment(professoren, HPos.CENTER);
        Text verteilen = new Text("Zu verteilende Ersties:");
        GridPane.setHalignment(verteilen, HPos.CENTER);
        Text anzahlVerteilen = new Text();
        GridPane.setHalignment(anzahlVerteilen, HPos.RIGHT);
        anzahlVerteilen.setText(anzahlZuVerteilen);
        Text missionskarte = new Text("Missionskarte:");
        Text missionskarteT = new Text();
        missionskarteT.setText(textMissionskarte);
        GridPane.setHalignment(missionskarteT, HPos.CENTER);
        GridPane.setValignment(missionskarteT, VPos.CENTER);

        Button tauschen = new Button("Karten eintauschen");
        GridPane.setHalignment(tauschen, HPos.CENTER);
        GridPane.setValignment(tauschen, VPos.CENTER);
        Button angreifen = new Button("Angreifen");
        GridPane.setValignment(angreifen, VPos.CENTER);
        Button verschieben = new Button("Verschieben");
        GridPane.setValignment(verschieben, VPos.CENTER);
        Button beenden = new Button("Zug beenden");
        GridPane.setHalignment(beenden, HPos.CENTER);
        GridPane.setValignment(beenden, VPos.CENTER);

        Image erstiesBild = new Image(getClass().getResourceAsStream("fragezeichen.png"));
        Image studentenBild = new Image(getClass().getResourceAsStream("ausrufezeichen.png"));
        Image professorenBild = new Image(getClass().getResourceAsStream("professor.png"));
        ImageView imageViewErsties = new ImageView(erstiesBild);
        imageViewErsties.setFitWidth(30);
        imageViewErsties.setFitHeight(50);
        GridPane.setHalignment(imageViewErsties, HPos.CENTER);
        ImageView imageViewErsties2 = new ImageView(erstiesBild);
        imageViewErsties2.setFitWidth(30);
        imageViewErsties2.setFitHeight(50);
        GridPane.setHalignment(imageViewErsties2, HPos.CENTER);
        ImageView imageViewStudenten = new ImageView(studentenBild);
        imageViewStudenten.setFitWidth(35);
        imageViewStudenten.setFitHeight(50);
        GridPane.setHalignment(imageViewStudenten, HPos.CENTER);
        ImageView imageViewProfessoren = new ImageView(professorenBild);
        imageViewProfessoren.setFitWidth(80);
        imageViewProfessoren.setFitHeight(50);
        GridPane.setHalignment(imageViewProfessoren, HPos.CENTER);

        gridPane.add(phase, 0, 0, 1, 1);
        gridPane.add(phasenbeschr, 1, 0, 9, 1);
        gridPane.add(uhr, 10, 0, 1, 1);
        gridPane.add(uhrzeit, 11, 0, 1, 1);
        gridPane.add(bonuskarten, 3, 1, 6, 1);
        gridPane.add(ersties, 3, 2, 1, 1);
        gridPane.add(imageViewErsties, 4, 2, 1, 1);
        gridPane.add(studenten, 5, 2, 1, 1);
        gridPane.add(imageViewStudenten, 6, 2, 1, 1);
        gridPane.add(professoren, 7, 2, 1, 1);
        gridPane.add(imageViewProfessoren, 8, 2, 1, 1);
        gridPane.add(verteilen, 3, 3, 6, 1);
        gridPane.add(anzahlVerteilen, 3, 4, 3, 1);
        gridPane.add(imageViewErsties2, 6, 4, 3, 1);
        gridPane.add(missionskarte, 10,1, 2, 1);
        gridPane.add(missionskarteT, 10, 2, 2, 3);
        gridPane.add(tauschen, 0, 1, 3, 1);
        gridPane.add(angreifen, 0, 2, 2, 2);
        gridPane.add(verschieben, 2, 2, 1, 2);
        gridPane.add(beenden,0,4, 3, 1);

        spieler.setStyle("-fx-font: normal normal 20px 'serif' ");
        farbgebung.setStyle("-fx-font: normal normal 20px 'serif' ");
        phase.setStyle("-fx-font: normal normal 20px 'serif' ");
        uhr.setStyle("-fx-font: normal normal 20px 'serif' ");
        bonuskarten.setStyle("-fx-font: normal normal 20px 'serif' ");
        verteilen.setStyle("-fx-font: normal normal 20px 'serif' ");
        missionskarte.setStyle("-fx-font: normal normal 20px 'serif' ");

        gridPane.setStyle("-fx-background-color: #aaaaaa");

        //Setzen der 3 Felder der BorderPane:
        borderPane.setLeft(karte);
        borderPane.setRight(rechts);
        borderPane.setBottom(gridPane);
        sceneKarte = new Scene(borderPane);
    }

    public void showKarte(Stage stage, FXMLLoader karteLoader) throws IOException {
        karte(karteLoader);
        stage.setTitle("UniRisk");
        stage.setResizable(false);
        stage.setScene(sceneKarte);
        stage.show();
    }
*/
    public void getKarte(Parent karte){
        this.karte = karte;
    }

    public Button getSpielerAnmelden(){
        /*if(nameEingabe.getText() != null && !nameEingabe.getText().isEmpty()
                && pwdEingabe.getText() != null && !pwdEingabe.getText().isEmpty()
                && ipEingabe.getText() != null && !ipEingabe.getText().isEmpty()){*/
            nameSpieler = nameEingabe.getText();
            passwort = pwdEingabe.getText();
            ipAdresse = ipEingabe.getText();
        //}
        return anmelden;
    }

    public Button getSpielerBereit(){
        return bereit;
    }

    public boolean getBereit(){
        return true;//kommunikation.spielerBereitMelden(nameSpieler);
    }

    public boolean getAusgestiegen(){
        return true;//kommunikation.spielerAusgestiegen(nameSpieler);
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
        //kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler);
    }
}
