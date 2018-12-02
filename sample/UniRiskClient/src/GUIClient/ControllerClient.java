package GUIClient;

import KommunikationClient.ClientKommunikationNachServer;
import KommunikationClient.IClientKommunikation;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ControllerClient {
    private DatenClient datenClient;
    public AnzeigeClient anzeige;

    public ControllerClient(DatenClient datenClient){
        this.datenClient = datenClient;
        this.anzeige = new AnzeigeClient();

        this.anzeige.getSpielerAnmelden().setOnAction(e -> {
            if (this.anzeige.getAngemeldet())
                showLobbyClient();
        });

        this.anzeige.getSpielerBereit().setOnAction(e -> {
            this.anzeige.getBereit();
        });

        this.anzeige.getSpielerAusgestiegen().setOnAction(e -> {
            this.anzeige.getAusgestiegen();
        });
    }

    public void setKommunikation(ClientKommunikationNachServer kommunikation){
        anzeige.setClientKommunikation(kommunikation);
    }

    public void showAnmelden() {
        anzeige.showAnmelden(datenClient.getStage());
    }

    public void showLobbyClient() {
        anzeige.showLobbyClient(datenClient.getStage());
    }

    public void showKarte(FXMLLoader karteLoader) throws IOException {
       //anzeige.showKarte(datenClient.getStage(), karteLoader);
    }

    public void setKarte(Parent karte){
        this.anzeige.getKarte(karte);
    }

    public void getClickGebaeude(Integer ID) {
        this.anzeige.getErstiesAnzahl(ID);
    }
}
