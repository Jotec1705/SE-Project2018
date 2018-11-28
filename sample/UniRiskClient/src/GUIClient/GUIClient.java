package GUIClient;

import KommunikationClient.ClientKommunikationNachServer;

import KommunikationClient.IClientKommunikation;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.shape.Line;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GUIClient extends Application implements IGUIClientCallback {
    public IClientKommunikation kommunikation;
    //Erstellt das Objekt Hannes oder ich?
    public void setClientKommunikation(IClientKommunikation kommunikation){
        this.kommunikation = kommunikation;
    }
    //private ListView<String> mitspieler;

    private Scene sceneKarte;
    private Scene sceneAnmelden;
    private Scene scenePopupWuerfelnAngreifer;

    private String nameSpieler1 = "Alicia";
    private String nameSpieler2;
    private String nameSpieler3;
    private String nameSpieler4;
    private String nameSpieler5;

    public static void main (String[] args){
        launch(args);
    }

    @Override
    public boolean aktualisierenLobby() {
        return false;
    }

    @Override
    public boolean aktualisierenKarte() {
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

    //kleiner Test:
    @Override
    public void start(Stage stage) throws IOException {
        anmelden();
        showAnmelden(stage);
        /*
        karte();
        showKarte(stage);
        */
    }

    public void popupWuerfelnAngreifer(){

    }

    public void showPopupWuerfelnAngreifer(Stage stage){
        stage.setTitle("Würfel Angreifer");
        stage.setScene(scenePopupWuerfelnAngreifer);
        stage.show();
    }

    public void anmelden(){
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Text uniRisk = new Text("UniRisk");
        uniRisk.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        GridPane.setHalignment(uniRisk, HPos.CENTER);
        gridPane.add(uniRisk,0,0, 3, 1);

        Text name = new Text("Benutzername:");
        TextField nameEingabe = new TextField();
        Text pwd = new Text("Passwort:");
        PasswordField pwdEingabe = new PasswordField();
        Text ip = new Text("Server IP:");
        TextField ipEingabe = new TextField();
        gridPane.add(name, 0, 2, 1, 1);
        gridPane.add(nameEingabe,1, 2, 1, 1);
        gridPane.add(pwd, 0, 3, 1,  1);
        gridPane.add(pwdEingabe,1, 3, 1, 1);
        gridPane.add(ip, 2, 2, 1,  1);
        gridPane.add(ipEingabe,3, 2, 1, 1);

        Button anmelden = new Button("Am Server anmelden");
        gridPane.add(anmelden, 3, 4, 2, 1);

        sceneAnmelden = new Scene(gridPane, 450, 200);
    }

    public void showAnmelden(Stage stage){
        stage.setTitle("Client Anwendung");
        stage.setScene(sceneAnmelden);
        stage.show();
    }

    //---------------------------------------Layout der Karte:--------------------------------------------------------------
    public void karte() throws IOException{
        //BorderPane --> übergeordnete Unterteilung des Fensters:
        BorderPane borderPane = new BorderPane();

        Parent karte = FXMLLoader.load(getClass().getResource("/GUIClient/Karte.fxml"));

        //V-Box für die Labels mit Spieler und Farbgebung:
        Text spieler = new Text("Spieler:");
        spieler.setUnderline(true);
        Text farbgebung = new Text("Farbgebung:");
        farbgebung.setUnderline(true);

            //HBoxen
            Text spieler1 = new Text(nameSpieler1);
            Circle circle1 = new Circle();
            circle1.setRadius(10.0f);
            circle1.setFill(Color.DARKGREEN);

            HBox hBoxSpieler1 = new HBox();
            hBoxSpieler1.setPadding(new Insets(10,10,10,10));
            hBoxSpieler1.setMargin(spieler1, new Insets(10,10,10,10));
            hBoxSpieler1.setMargin(circle1, new Insets(10,10,10,10));
            ObservableList listhBoxSpieler1 = hBoxSpieler1.getChildren();
            listhBoxSpieler1.addAll(circle1, spieler1);
            hBoxSpieler1.setAlignment(Pos.CENTER);
            hBoxSpieler1.setStyle("-fx-background-color: #aaaaaa");

            Text spieler2 = new Text(nameSpieler2);
            Circle circle2 = new Circle();
            circle2.setRadius(10.0f);
            circle2.setFill(Color.PINK);

            HBox hBoxSpieler2 = new HBox();
            hBoxSpieler2.setPadding(new Insets(10,10,10,10));
            hBoxSpieler2.setMargin(spieler2, new Insets(10,10,10,10));
            hBoxSpieler2.setMargin(circle2, new Insets(10,10,10,10));
            ObservableList listhBoxSpieler2 = hBoxSpieler2.getChildren();
            listhBoxSpieler2.addAll(circle2, spieler2);
            hBoxSpieler2.setAlignment(Pos.CENTER);
            hBoxSpieler2.setStyle("-fx-background-color: #aaaaaa");

            Text spieler3 = new Text(nameSpieler3);
            Circle circle3 = new Circle();
            circle3.setRadius(10.0f);
            circle3.setFill(Color.DARKBLUE);

            HBox hBoxSpieler3 = new HBox();
            hBoxSpieler3.setPadding(new Insets(10,10,10,10));
            hBoxSpieler3.setMargin(spieler3, new Insets(10,10,10,10));
            hBoxSpieler3.setMargin(circle3, new Insets(10,10,10,10));
            ObservableList listhBoxSpieler3 = hBoxSpieler3.getChildren();
            listhBoxSpieler3.addAll(circle3, spieler3);
            hBoxSpieler3.setAlignment(Pos.CENTER);
            hBoxSpieler3.setStyle("-fx-background-color: #aaaaaa");

            Text spieler4 = new Text(nameSpieler4);
            Circle circle4 = new Circle();
            circle4.setRadius(10.0f);
            circle4.setFill(Color.YELLOW);

            HBox hBoxSpieler4 = new HBox();
            hBoxSpieler4.setPadding(new Insets(10,10,10,10));
            hBoxSpieler4.setMargin(spieler4, new Insets(10,10,10,10));
            hBoxSpieler4.setMargin(circle4, new Insets(10,10,10,10));
            ObservableList listhBoxSpieler4 = hBoxSpieler4.getChildren();
            listhBoxSpieler4.addAll(circle4, spieler4);
            hBoxSpieler4.setAlignment(Pos.CENTER);
            hBoxSpieler4.setStyle("-fx-background-color: #aaaaaa");

            Text spieler5 = new Text(nameSpieler5);
            Circle circle5 = new Circle();
            circle5.setRadius(10.0f);
            circle5.setFill(Color.TURQUOISE);

            HBox hBoxSpieler5 = new HBox();
            hBoxSpieler5.setPadding(new Insets(10,10,10,10));
            hBoxSpieler5.setMargin(spieler5, new Insets(10,10,10,10));
            hBoxSpieler5.setMargin(circle5, new Insets(10,10,10,10));
            ObservableList listhBoxSpieler5 = hBoxSpieler5.getChildren();
            listhBoxSpieler5.addAll(circle5, spieler5);
            hBoxSpieler5.setAlignment(Pos.CENTER);
            hBoxSpieler5.setStyle("-fx-background-color: #aaaaaa");
/*
            GridPane gridPane1 = new GridPane();
            gridPane1.setPadding(new Insets(10, 10, 10, 10));
            gridPane1.setMargin(spieler1, new Insets(10, 10, 10, 10));
            gridPane1.setMargin(spieler2, new Insets(10, 10, 10, 10));
            gridPane1.setMargin(spieler3, new Insets(10, 10, 10, 10));
            gridPane1.setMargin(spieler4, new Insets(10, 10, 10, 10));
            gridPane1.setMargin(spieler5, new Insets(10, 10, 10, 10));
            gridPane1.setMargin(circle1, new Insets(10, 10, 10, 10));
            gridPane1.setMargin(circle2, new Insets(10, 10, 10, 10));
            gridPane1.setMargin(circle3, new Insets(10, 10, 10, 10));
            gridPane1.setMargin(circle4, new Insets(10, 10, 10, 10));
            gridPane1.setMargin(circle5, new Insets(10, 10, 10, 10));
            //gridPane1.setVgap(5);
            //gridPane1.setHgap(5);
            gridPane1.setAlignment(Pos.TOP_LEFT);

            gridPane1.add(circle1, 0,0);
            gridPane1.add(spieler1, 1, 0);
            gridPane1.add(circle2, 0, 1);
            gridPane1.add(spieler2, 1, 1);
            gridPane1.add(circle3, 0, 2);
            gridPane1.add(spieler3, 1, 2);
            gridPane1.add(circle4, 0, 3);
            gridPane1.add(spieler4, 1, 3);
            gridPane1.add(circle5, 0, 4);
            gridPane1.add(spieler5, 1, 4);
*/
            Text etti = new Text("ETTI");
            etti.setFill(Color.DARKGREEN);
            etti.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            Circle circle11 = new Circle();
            circle11.setRadius(10.0f);
            circle11.setFill(Color.DARKGREEN);

            HBox hBoxEtti = new HBox();
            hBoxEtti.setPadding(new Insets(10,10,10,10));
            hBoxEtti.setMargin(etti, new Insets(10,10,10,10));
            hBoxEtti.setMargin(circle11, new Insets(10,10,10,10));
            ObservableList listhBoxEtti = hBoxEtti.getChildren();
            listhBoxEtti.addAll(circle11, etti);
            hBoxEtti.setAlignment(Pos.CENTER);
            hBoxEtti.setStyle("-fx-background-color: #aaaaaa");

            Text spo = new Text("SPO");
            spo.setFill(Color.PINK);
            spo.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            Circle circle22 = new Circle();
            circle22.setRadius(10.0f);
            circle22.setFill(Color.PINK);

            HBox hBoxSpo = new HBox();
            hBoxSpo.setPadding(new Insets(10,10,10,10));
            hBoxSpo.setMargin(spo, new Insets(10,10,10,10));
            hBoxSpo.setMargin(circle22, new Insets(10,10,10,10));
            ObservableList listhBoxSpo = hBoxSpo.getChildren();
            listhBoxSpo.addAll(circle22, spo);
            hBoxSpo.setAlignment(Pos.CENTER);
            hBoxSpo.setStyle("-fx-background-color: #aaaaaa");

            Text wow = new Text("WOW");
            wow.setFill(Color.DARKBLUE);
            wow.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            Circle circle33 = new Circle();
            circle33.setRadius(10.0f);
            circle33.setFill(Color.DARKBLUE);

            HBox hBoxWow = new HBox();
            hBoxWow.setPadding(new Insets(10,10,10,10));
            hBoxWow.setMargin(wow, new Insets(10,10,10,10));
            hBoxWow.setMargin(circle33, new Insets(10,10,10,10));
            ObservableList listhBoxWow = hBoxWow.getChildren();
            listhBoxWow.addAll(circle33, wow);
            hBoxWow.setAlignment(Pos.CENTER);
            hBoxWow.setStyle("-fx-background-color: #aaaaaa");

            Text aero = new Text("Aero (Stg)");
            aero.setFill(Color.YELLOW);
            aero.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            Circle circle44 = new Circle();
            circle44.setRadius(10.0f);
            circle44.setFill(Color.YELLOW);

            HBox hBoxAero = new HBox();
            hBoxAero.setPadding(new Insets(10,10,10,10));
            hBoxAero.setMargin(aero, new Insets(10,10,10,10));
            hBoxAero.setMargin(circle44, new Insets(10,10,10,10));
            ObservableList listhBoxAero = hBoxAero.getChildren();
            listhBoxAero.addAll(circle44, aero);
            hBoxAero.setAlignment(Pos.CENTER);
            hBoxAero.setStyle("-fx-background-color: #aaaaaa");

            Text bau = new Text("BAU");
            bau.setFill(Color.TURQUOISE);
            bau.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
            Circle circle55 = new Circle();
            circle55.setRadius(10.0f);
            circle55.setFill(Color.TURQUOISE);

            HBox hBoxBau = new HBox();
            hBoxBau.setPadding(new Insets(10,10,10,10));
            hBoxBau.setMargin(bau, new Insets(10,10,10,10));
            hBoxBau.setMargin(circle55, new Insets(10,10,10,10));
            ObservableList listhBoxBau = hBoxBau.getChildren();
            listhBoxBau.addAll(circle55, bau);
            hBoxBau.setAlignment(Pos.CENTER);
            hBoxBau.setStyle("-fx-background-color: #aaaaaa");


        VBox vBox = new VBox();
        vBox.setMinSize(200,400);
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setMargin(spieler, new Insets(0,10,0,10));
        vBox.setMargin(hBoxSpieler1, new Insets(5,0,0,0));
      /*  vBox.setMargin(hBoxSpieler2, new Insets(5,5,5,5));
        vBox.setMargin(hBoxSpieler3, new Insets(5,5,5,5));
        vBox.setMargin(hBoxSpieler4, new Insets(5,5,5,5));
        vBox.setMargin(hBoxSpieler5, new Insets(5,5,5,5));
*/
        vBox.setMargin(farbgebung, new Insets(10,10,10,10));
        vBox.setMargin(hBoxEtti, new Insets(5,0,0,0));
        /*vBox.setMargin(hBoxSpo, new Insets(5,5,5,5));
        vBox.setMargin(hBoxWow, new Insets(5,5,5,5));
        vBox.setMargin(hBoxAero, new Insets(5,5,5,5));
        vBox.setMargin(hBoxBau, new Insets(5,5,5,5));
*/
        ObservableList list = vBox.getChildren();
        list.addAll(spieler, hBoxSpieler1, hBoxSpieler2, hBoxSpieler3, hBoxSpieler4, hBoxSpieler5, farbgebung, hBoxEtti, hBoxSpo, hBoxWow, hBoxAero, hBoxBau);
        vBox.setAlignment(Pos.BASELINE_LEFT);
        vBox.setStyle("-fx-background-color: #aaaaaa");

        //GridPane für die Buttonleiste:
        Text phase = new Text("Phase: ");
        Text uhr = new Text("Uhrzeit: ");
        Text bonuskarten = new Text("Bonuskarten:");
        Text ersties = new Text("Ersties");
        Text studenten = new Text("Studenten");
        Text professoren = new Text("Professoren");
        Text verteilen = new Text("Zu verteilende Ersties:");
        Text missionskarte = new Text("Missionskarte:");

        Button tauschen = new Button("Karten eintauschen");
        Button setzen = new Button("Setzen beenden");
        Button angreifen = new Button("Angreifen");
        Button verschieben = new Button("Verschieben");
        Button beenden = new Button("Zug beenden");

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400, 200);
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setAlignment(Pos.BASELINE_LEFT);

        gridPane.add(phase, 0, 0);
        gridPane.add(uhr, 6, 0);
        gridPane.add(bonuskarten, 2, 1);
        gridPane.add(ersties, 2, 2);
        gridPane.add(studenten, 3, 2);
        gridPane.add(professoren, 4, 2);
        gridPane.add(verteilen, 2, 3);
        gridPane.add(missionskarte, 5,1);
        gridPane.add(tauschen, 0, 2);
        gridPane.add(setzen, 1, 2);
        gridPane.add(angreifen, 0, 3);
        gridPane.add(verschieben, 1, 3);
        gridPane.add(beenden,0,4);

        spieler.setStyle("-fx-font: normal normal 20px 'serif' ");
        farbgebung.setStyle("-fx-font: normal normal 20px 'serif' ");
        phase.setStyle("-fx-font: normal normal 20px 'serif' ");
        uhr.setStyle("-fx-font: normal normal 20px 'serif' ");
        bonuskarten.setStyle("-fx-font: normal normal 20px 'serif' ");
        verteilen.setStyle("-fx-font: normal normal 20px 'serif' ");
        missionskarte.setStyle("-fx-font: normal normal 20px 'serif' ");

        tauschen.setStyle("-fx-background-color: #3a8b8a; -fx-text-fill: #ffffff;");
        setzen.setStyle("-fx-background-color: #3a8b8a; -fx-text-fill: white;");
        angreifen.setStyle("-fx-background-color: #3a8b8a; -fx-text-fill: white;");
        verschieben.setStyle("-fx-background-color: #3a8b8a; -fx-text-fill: white;");
        beenden.setStyle("-fx-background-color: #3a8b8a; -fx-text-fill: white;");

        gridPane.setStyle("-fx-background-color: #aaaaaa");

        //Setzen der 3 Felder der BorderPane:
        borderPane.setLeft(karte);
        borderPane.setRight(vBox);
        borderPane.setBottom(gridPane);
        sceneKarte = new Scene(borderPane);
    }

    public void showKarte(Stage stage){
        stage.setTitle("UniRisk");
        stage.setScene(sceneKarte);
        stage.show();
    }

    //--------------------------------Gebäude Buttons Handler Methoden:-----------------------------------------------------
    public void onclicked1(MouseEvent mouseEvent) {
        Integer ID = 1;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked2(MouseEvent mouseEvent) {
        Integer ID = 2;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked3(MouseEvent mouseEvent) {
        Integer ID = 3;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked4(MouseEvent mouseEvent) {
        Integer ID = 4;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked5(MouseEvent mouseEvent) {
        Integer ID = 5;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked6(MouseEvent mouseEvent) {
        Integer ID = 6;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked7(MouseEvent mouseEvent) {
        Integer ID = 7;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked8(MouseEvent mouseEvent) {
        Integer ID = 8;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked9(MouseEvent mouseEvent) {
        Integer ID = 9;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked10(MouseEvent mouseEvent) {
        Integer ID = 10;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked11(MouseEvent mouseEvent) {
        Integer ID = 11;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked12(MouseEvent mouseEvent) {
        Integer ID = 12;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked13(MouseEvent mouseEvent) {
        Integer ID = 13;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked14(MouseEvent mouseEvent) {
        Integer ID = 14;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked15(MouseEvent mouseEvent) {
        Integer ID = 15;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked16(MouseEvent mouseEvent) {
        Integer ID = 16;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked17(MouseEvent mouseEvent) {
        Integer ID = 17;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked18(MouseEvent mouseEvent) {
        Integer ID = 18;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked19(MouseEvent mouseEvent) {
        Integer ID = 19;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked20(MouseEvent mouseEvent) {
        Integer ID = 20;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked21(MouseEvent mouseEvent) {
        Integer ID = 21;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked22(MouseEvent mouseEvent) {
        Integer ID = 22;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked23(MouseEvent mouseEvent) {
        Integer ID = 23;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked24(MouseEvent mouseEvent) {
        Integer ID = 24;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked25(MouseEvent mouseEvent) {
        Integer ID = 25;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked26(MouseEvent mouseEvent) {
        Integer ID = 26;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked27(MouseEvent mouseEvent) {
        Integer ID = 27;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked28(MouseEvent mouseEvent) {
        Integer ID = 28;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked29(MouseEvent mouseEvent) {
        Integer ID = 29;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked30(MouseEvent mouseEvent) {
        Integer ID = 30;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked31(MouseEvent mouseEvent) {
        Integer ID = 31;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked32(MouseEvent mouseEvent) {
        Integer ID = 32;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }

    public void onclicked33(MouseEvent mouseEvent) {
        Integer ID = 33;
        kommunikation.erstiesAnzahlErhoehen(ID, nameSpieler1);
    }
}