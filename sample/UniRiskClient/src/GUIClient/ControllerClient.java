package GUIClient;

import KommunikationClient.ClientKommunikationNachServer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;

public class ControllerClient {
    private DatenClient datenClient;
    public AnzeigeClient anzeige;

    public ControllerClient(DatenClient datenClient) {
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

    class Slots {
        private String name;
        private String ipAdresse;
        private boolean status;

        public Slots(String name, String ipAdresse, boolean status) {
            this.name = name;
            this.ipAdresse = ipAdresse;
            this.status = status;
            if (name == null)
                this.name = "1";
            if (ipAdresse == null)
                this.ipAdresse = "0";
        }
    }

    public void setKartenScene(Scene sceneKarte) {
        anzeige.getKartenScene(sceneKarte);
    }

    public void setKommunikation(ClientKommunikationNachServer kommunikation) {
        anzeige.setClientKommunikation(kommunikation);
    }

    public void setSpielerNamenInTabelle(String[] spielerNamen){
        datenClient.setSpielerNamen(spielerNamen);
    }

    public void setSpielerIPInTabelle(String[] spielerIP){
        datenClient.setSpielerIP(spielerIP);
    }
    public void setSpielerBereitInTabelle(boolean[] spielerBereit){
        datenClient.setSpielerBereit(spielerBereit);
    }
    public void slotsAnlegenUndAnzeigen() {
        ObservableList slotsList;
        String[] slots = new String[datenClient.getSpielerNamen().length];

        for (int i = 0; i < datenClient.getSpielerNamen().length; i++){
            slots[i] = String.valueOf(new String[]{datenClient.getSpielerNamen()[i], datenClient.getSpielerIP()[i], datenClient.getSpielerBereit()[i]});
        }
        slotsList = FXCollections.observableArrayList(slots);
        anzeige.setSlots(slotsList);
    }

    public void showAnmelden() {
        anzeige.showAnmelden(datenClient.getStage());
    }

    public void showLobbyClient() {
        anzeige.showLobbyClient(datenClient.getStage());
    }

    public void getClickGebaeude(Integer ID) {
        this.anzeige.getErstiesAnzahl(ID);
    }
}
