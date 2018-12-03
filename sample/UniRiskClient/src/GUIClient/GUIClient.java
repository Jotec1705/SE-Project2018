package GUIClient;

import KommunikationClient.CallbackRMIAufLokal;
import KommunikationClient.ClientKommunikationNachServer;
import KommunikationClient.ICallbackRMIC;
import KommunikationClient.IClientKommunikation;
import KommunikationServer.ICallbackRMI;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.ComboBox;

import java.io.IOException;

public class GUIClient extends Application implements IGUIClientCallback{
    private ControllerClient controllerClient;
    public ClientKommunikationNachServer kommunikation = new ClientKommunikationNachServer();
    private DatenClient datenClient;

    private Scene sceneAnmelden;
    private Scene sceneLobby;
    private Scene sceneKarte;
    private Scene scenePopupBonuskarten;
    private Scene sceneAngriff;
    private Scene scenePopupWuerfelnAngreifer;
    private Scene scenePopupWuerfelnVerteidiger;
    private Scene scenePopupVerschiebenVonNach;

    private String nameSpieler;
    private String passwort;
    private String ipAdresse;
    private String nameSpieler1;
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

    int i = 0;
    private Button anmelden;

    public static void main (String[] args){
        launch(args);
    }

    @Override
    public boolean aktualisierenLobby() {
        System.out.println("Lobby aktualisiert");
        return true;
    }

    @Override
    public boolean aktualisierenKarte() {
        karteAnzeigen();
        return false;
    }

    @Override
    public boolean zugZuteilung(String nameSpieler) {
        return false;
    }

    @Override
    public boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb) {
        return false;
    }

    @Override
    public boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen) {
        return false;
    }

    @Override
    public boolean spielBeendet() {
        return false;
    }

    public void setClient(CallbackRMIAufLokal callbackRMI){
        callbackRMI.guiClient = this;
    }

    //kleiner Test:
    @Override
    public void start(Stage stage) throws IOException {
        datenClient = new DatenClient(stage);
        controllerClient = new ControllerClient(datenClient);
        kommunikation.setClient(this);
        controllerClient.setKommunikation(kommunikation);
        karte();
        controllerClient.showAnmelden();
/*
        showKarte(stage);

        popupBonuskarten();
        showBonuskarten(stage);

        popupAngriffVonNach();
        showPopupAngriffVonNach(stage);

        popupWuerfelnAngreifer();
        showPopupWuerfelnAngreifer(stage);
       popupWuerfelnVerteidiger();
        showPopupWuerfelnVerteidiger(stage);

        popupVerschiebenVonNach();
        showPopupVerschiebenVonNach(stage);
*/
    }

    public void karteAnzeigen(){
        showKarte(datenClient.getStage());
    }

//---------------------------------------Layout der Karte:--------------------------------------------------------------
    public void karte() throws IOException{
        //BorderPane --> übergeordnete Unterteilung des Fensters:
        BorderPane borderPane = new BorderPane();

        //Parent für links, die komplette Karte:
        Parent karte = FXMLLoader.load(getClass().getResource("/GUIClient/Karte.fxml"));

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

    public void showKarte(Stage stage){
        stage.setTitle("UniRisk");
        stage.setResizable(false);
        stage.setScene(sceneKarte);
        stage.show();
    }

//-------------------------------------Layout Angriff von nach:---------------------------------------------------------
    public void popupAngriffVonNach(){
        VBox angriff = new VBox();
        angriff.setAlignment(Pos.TOP_CENTER);
        angriff.setMinSize(400,300);
        angriff.setMaxSize(400,300);
        angriff.setPadding(new Insets(10, 10, 10, 10));

        Text von = new Text("Mit welchem Gebäude willst du angreifen?");
        Text nach = new Text("Welches Gebäude willst du angreifen?");
        Text erstiesAnzahl = new Text("Mit wievielen Ersties willst du den Angriff wagen?");
        ComboBox<String> vonDropDown = new ComboBox<String>();
        vonDropDown.getItems().addAll("Hotel Alpenblick", "BND Baracke", "Tempel des Wissens", "Flight");
        vonDropDown.setEditable(true);
        ComboBox<String> nachDropDown = new ComboBox<String>();
        nachDropDown.getItems().addAll("Hotel Alpenblick", "BND Baracke", "Tempel des Wissens", "Flight");
        nachDropDown.setEditable(true);
        TextField anzahl = new TextField();
        anzahl.setMaxWidth(55);

        Button angriffButton = new Button("Angriff!");
        angriffButton.setStyle("-fx-background-color: LIGHTGREEN");
        angriff.setMargin(von, new Insets(10, 10, 10, 10));
        angriff.setMargin(vonDropDown, new Insets(10, 10, 10, 10));
        angriff.setMargin(nach, new Insets(10, 10, 10, 10));
        angriff.setMargin(nachDropDown, new Insets(10, 10, 10, 10));
        angriff.setMargin(erstiesAnzahl, new Insets(10, 10, 10, 10));
        angriff.setMargin(anzahl, new Insets(10, 10, 10, 10));
        angriff.setMargin(angriffButton, new Insets(10, 10, 10, 10));

        angriff.getChildren().addAll(von, vonDropDown, nach, nachDropDown, erstiesAnzahl, anzahl, angriffButton);
        angriff.setAlignment(Pos.CENTER);

        sceneAngriff = new Scene(angriff);
    }

    public void showPopupAngriffVonNach(Stage stage){
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialog.setTitle("Angriff");
        dialog.setResizable(false);
        dialog.setScene(sceneAngriff);
        dialog.show();
    }

//-------------------------------------Layout Verschieben von nach:-----------------------------------------------------
    public void popupVerschiebenVonNach(){
        VBox verschieben = new VBox();
        verschieben.setAlignment(Pos.TOP_CENTER);
        verschieben.setMinSize(400,300);
        verschieben.setMaxSize(400,300);
        verschieben.setPadding(new Insets(10, 10, 10, 10));

        Text von = new Text("Von welchem Gebäude aus willst du verschieben?");
        Text nach = new Text("Zu welchem Gebäude willst du verschieben?");
        Text erstiesAnzahl = new Text("Wieviele Ersties willst du verschieben?");
        ComboBox<String> vonDropDown = new ComboBox<String>();
        vonDropDown.getItems().addAll("Hotel Alpenblick", "BND Baracke", "Tempel des Wissens", "Flight");
        vonDropDown.setEditable(true);
        ComboBox<String> nachDropDown = new ComboBox<String>();
        nachDropDown.getItems().addAll("Hotel Alpenblick", "BND Baracke", "Tempel des Wissens", "Flight");
        nachDropDown.setEditable(true);
        TextField anzahl = new TextField();
        anzahl.setMaxWidth(55);

        Button verschiebenButton = new Button("Verschieben");
        verschiebenButton.setStyle("-fx-background-color: LIGHTGREEN");
        verschieben.setMargin(von, new Insets(10, 10, 10, 10));
        verschieben.setMargin(vonDropDown, new Insets(10, 10, 10, 10));
        verschieben.setMargin(nach, new Insets(10, 10, 10, 10));
        verschieben.setMargin(nachDropDown, new Insets(10, 10, 10, 10));
        verschieben.setMargin(erstiesAnzahl, new Insets(10, 10, 10, 10));
        verschieben.setMargin(anzahl, new Insets(10, 10, 10, 10));
        verschieben.setMargin(verschiebenButton, new Insets(10, 10, 10, 10));

        verschieben.getChildren().addAll(von, vonDropDown, nach, nachDropDown, erstiesAnzahl, anzahl, verschiebenButton);
        verschieben.setAlignment(Pos.CENTER);

        scenePopupVerschiebenVonNach = new Scene(verschieben);
    }

    public void showPopupVerschiebenVonNach(Stage stage){
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialog.setTitle("Verschieben");
        dialog.setResizable(false);
        dialog.setScene(scenePopupVerschiebenVonNach);
        dialog.show();
    }

//-------------------------------------Layout Bonuskarten eintauschen:--------------------------------------------------


//-------------------------------------Layout Würfel Angreifer:---------------------------------------------------------
    public void popupWuerfelnAngreifer(){

    }

    public void showPopupWuerfelnAngreifer(Stage stage){
        stage.setTitle("Würfel Angreifer");
        stage.setResizable(false);
        stage.setScene(scenePopupWuerfelnAngreifer);
        stage.show();
    }

//-------------------------------------Layout Würfel Verteidiger:-------------------------------------------------------
    public void popupWuerfelnVerteidiger(){

    }

    public void showPopupWuerfelnVerteidiger(Stage stage){
        stage.setTitle("Würfel Verteidiger");
        stage.setResizable(false);
        stage.setScene(scenePopupWuerfelnVerteidiger);
        stage.show();
    }

//--------------------------------Gebäude Buttons Handler Methoden:-----------------------------------------------------
    public void onclicked1(MouseEvent mouseEvent) {
        Integer ID = 1;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked2(MouseEvent mouseEvent) {
        Integer ID = 2;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked3(MouseEvent mouseEvent) {
        Integer ID = 3;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked4(MouseEvent mouseEvent) {
        Integer ID = 4;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked5(MouseEvent mouseEvent) {
        Integer ID = 5;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked6(MouseEvent mouseEvent) {
        Integer ID = 6;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked7(MouseEvent mouseEvent) {
        Integer ID = 7;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked8(MouseEvent mouseEvent) {
        Integer ID = 8;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked9(MouseEvent mouseEvent) {
        Integer ID = 9;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked10(MouseEvent mouseEvent) {
        Integer ID = 10;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked11(MouseEvent mouseEvent) {
        Integer ID = 11;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked12(MouseEvent mouseEvent) {
        Integer ID = 12;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked13(MouseEvent mouseEvent) {
        Integer ID = 13;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked14(MouseEvent mouseEvent) {
        Integer ID = 14;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked15(MouseEvent mouseEvent) {
        Integer ID = 15;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked16(MouseEvent mouseEvent) {
        Integer ID = 16;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked17(MouseEvent mouseEvent) {
        Integer ID = 17;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked18(MouseEvent mouseEvent) {
        Integer ID = 18;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked19(MouseEvent mouseEvent) {
        Integer ID = 19;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked20(MouseEvent mouseEvent) {
        Integer ID = 20;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked21(MouseEvent mouseEvent) {
        Integer ID = 21;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked22(MouseEvent mouseEvent) {
        Integer ID = 22;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked23(MouseEvent mouseEvent) {
        Integer ID = 23;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked24(MouseEvent mouseEvent) {
        Integer ID = 24;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked25(MouseEvent mouseEvent) {
        Integer ID = 25;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked26(MouseEvent mouseEvent) {
        Integer ID = 26;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked27(MouseEvent mouseEvent) {
        Integer ID = 27;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked28(MouseEvent mouseEvent) {
        Integer ID = 28;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked29(MouseEvent mouseEvent) {
        Integer ID = 29;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked30(MouseEvent mouseEvent) {
        Integer ID = 30;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked31(MouseEvent mouseEvent) {
        Integer ID = 31;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked32(MouseEvent mouseEvent) {
        Integer ID = 32;
        controllerClient.getClickGebaeude(ID);
    }

    public void onclicked33(MouseEvent mouseEvent) {
        Integer ID = 33;
        controllerClient.getClickGebaeude(ID);
    }
}