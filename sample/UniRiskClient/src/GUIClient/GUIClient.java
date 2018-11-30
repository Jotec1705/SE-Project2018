package GUIClient;

import KommunikationClient.IClientKommunikation;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.Event;
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
import javafx.scene.layout.HBox;
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
    public IClientKommunikation kommunikation;
    private DatenClient datenClient;

    //Erstellt das Objekt Hannes oder ich?
    /*public void setClientKommunikation(IClientKommunikation kommunikation){
        this.kommunikation = kommunikation;
    }*/
    //private ListView<String> mitspieler;

    private Scene sceneAnmelden;
    private Scene sceneLobby;
    private Scene sceneKarte;
    private Scene scenePopupBonuskarten;
    private Scene sceneAngriff;
    private Scene scenePopupWuerfelnAngreifer;
    private Scene scenePopupWuerfelnVerteidiger;
    private Scene scenePopupVerschiebenVonNach;

    private String nameSpieler = "Alicia";
    private String passwort;
    private String ipAdresse;
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

    int i = 0;
    private Button anmelden;

    public static void main (String[] args){
        launch(args);
    }

    @Override
    public boolean aktualisierenLobby() {
        return true;
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
        datenClient = new DatenClient(stage);
        controllerClient = new ControllerClient(datenClient);
        controllerClient.showAnmelden();
        /*
        anmelden();
        showAnmelden(stage);

        if(i == 1){
            lobbyClient();
            showLobbyClient(stage);
        }
/*
        karte();
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

//---------------------------------------Layout der Karte:--------------------------------------------------------------
    public void karte() throws IOException{

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
    public void popupBonuskarten(){
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

    public void showBonuskarten(Stage stage){
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stage);
        dialog.setTitle("Bonuskarten eintauschen");
        dialog.setResizable(false);
        dialog.setScene(scenePopupBonuskarten);
        dialog.show();
    }

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

}