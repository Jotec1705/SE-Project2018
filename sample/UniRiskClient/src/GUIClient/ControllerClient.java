package GUIClient;

import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;

import java.io.IOException;

public class ControllerClient {
    private DatenClient datenClient;
    public AnzeigeClient anzeige;
    private boolean angemeldet;

    public ControllerClient(DatenClient datenClient) throws IOException {
        this.datenClient = datenClient;
        this.anzeige = new AnzeigeClient();

        Parent karte = FXMLLoader.load(getClass().getResource("@Karte.fxml"));
        this.anzeige.setKarte(karte);

        this.anzeige.getSpielerAnmelden().setOnAction(e -> {
            if (this.anzeige.getAngemeldet())
                showLobbyClient();
        });

        this.anzeige.getSpielerBereit().setOnAction(e -> {
            this.anzeige.getBereit();
               // showKarte();
        });

        this.anzeige.getSpielerAusgestiegen().setOnAction(e -> {

        });
    }

    public void showAnmelden() {
        anzeige.showAnmelden(datenClient.getStage());
    }

    public void showLobbyClient() {
        anzeige.showLobbyClient(datenClient.getStage());
    }

    public void showKarte(){
        anzeige.showKarte(datenClient.getStage());
    }

    public void onclicked1(MouseEvent mouseEvent) {
        Integer ID = 1;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked2(MouseEvent mouseEvent) {
        Integer ID = 2;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked3(MouseEvent mouseEvent) {
        Integer ID = 3;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked4(MouseEvent mouseEvent) {
        Integer ID = 4;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked5(MouseEvent mouseEvent) {
        Integer ID = 5;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked6(MouseEvent mouseEvent) {
        Integer ID = 6;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked7(MouseEvent mouseEvent) {
        Integer ID = 7;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked8(MouseEvent mouseEvent) {
        Integer ID = 8;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked9(MouseEvent mouseEvent) {
        Integer ID = 9;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked10(MouseEvent mouseEvent) {
        Integer ID = 10;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked11(MouseEvent mouseEvent) {
        Integer ID = 11;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked12(MouseEvent mouseEvent) {
        Integer ID = 12;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked13(MouseEvent mouseEvent) {
        Integer ID = 13;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked14(MouseEvent mouseEvent) {
        Integer ID = 14;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked15(MouseEvent mouseEvent) {
        Integer ID = 15;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked16(MouseEvent mouseEvent) {
        Integer ID = 16;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked17(MouseEvent mouseEvent) {
        Integer ID = 17;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked18(MouseEvent mouseEvent) {
        Integer ID = 18;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked19(MouseEvent mouseEvent) {
        Integer ID = 19;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked20(MouseEvent mouseEvent) {
        Integer ID = 20;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked21(MouseEvent mouseEvent) {
        Integer ID = 21;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked22(MouseEvent mouseEvent) {
        Integer ID = 22;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked23(MouseEvent mouseEvent) {
        Integer ID = 23;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked24(MouseEvent mouseEvent) {
        Integer ID = 24;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked25(MouseEvent mouseEvent) {
        Integer ID = 25;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked26(MouseEvent mouseEvent) {
        Integer ID = 26;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked27(MouseEvent mouseEvent) {
        Integer ID = 27;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked28(MouseEvent mouseEvent) {
        Integer ID = 28;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked29(MouseEvent mouseEvent) {
        Integer ID = 29;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked30(MouseEvent mouseEvent) {
        Integer ID = 30;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked31(MouseEvent mouseEvent) {
        Integer ID = 31;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked32(MouseEvent mouseEvent) {
        Integer ID = 32;
        this.anzeige.getErstiesAnzahl(ID);
    }

    public void onclicked33(MouseEvent mouseEvent) {
        Integer ID = 33;
        this.anzeige.getErstiesAnzahl(ID);
    }
}
