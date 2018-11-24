package GUIClient;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
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
    //private ListView<String> mitspieler;

    private String nameSpieler1 = "Alicia";
    private String nameSpieler2;
    private String nameSpieler3;
    private String nameSpieler4;
    private String nameSpieler5;

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
        //BorderPane --> übergeordnete Unterteilung des Fensters:
        BorderPane borderPane = new BorderPane();

        //Bild einfügen:
        /*Image image = new Image(new FileInputStream("C:\\Users\\Alicia Siefert\\Documents\\SE-Project2018\\Karte.png"));
        ImageView imageView = new ImageView(image);
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitHeight(1000);
        imageView.setFitWidth(1000);
        imageView.setPreserveRatio(true);
        Group root = new Group(imageView);
*/
        Parent karte = FXMLLoader.load(getClass().getResource("Karte.fxml"));

        //V-Box für die Labels mit Spieler und Farbgebung:
        Text spieler = new Text("Spieler:");
        spieler.setUnderline(true);
        Text farbgebung = new Text("Farbgebung:");
        farbgebung.setUnderline(true);

            //HBoxen:
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
        vBox.setMargin(spieler, new Insets(0,10,10,10));
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
        Scene scene = new Scene(borderPane);

        stage.setTitle("UniRisk");

        stage.setScene(scene);

        stage.show();
    }
    public static void main (String[] args){
        launch(args);
    }
}
