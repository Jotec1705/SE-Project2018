package GUIClient;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUIClient extends Application implements IGUIClientCallback {
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
    public void start(Stage stage) {
        BorderPane root = new BorderPane();

        Label label = new Label("Center of the BorderPane!");
        root.setCenter(label);

        Scene scene = new Scene(root, 200, 100);
        stage.setTitle("The Title of GUIClient");
        stage.setScene(scene);
        stage.show();
    }
    public static void main (String[] args){
        launch(args);
    }
}
