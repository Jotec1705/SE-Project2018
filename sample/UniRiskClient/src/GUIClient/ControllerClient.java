package GUIClient;

import KommunikationClient.ClientKommunikationNachServer;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;

import java.util.logging.Level;

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
        private SimpleStringProperty ip;
        private StringProperty name;
        private StringProperty status;

        public Slots(String ipAdresse, String spielerName, String status) {
            this.ip = new SimpleStringProperty(ipAdresse);
            this.name = new SimpleStringProperty(spielerName);
            this.status = new SimpleStringProperty(status);
           /* if (spielerName == null)
                this.name = "1";
            if (ipAdresse == null)
                this.ip = "0";*/
        }

        public String getIp(){
            return ip.get();
        }
        public StringProperty ipProperty(){
            if (ip == null)
                ip = new SimpleStringProperty("");
            return ip;
        }
        public void setIp(String ip){
            this.ip.set(ip);
        }
        public String getName(){
            return name.get();
        }
        public StringProperty nameProperty(){
            return name;
        }
        public void setName(String name){
            this.name.set(name);
        }
        public String getStatus(){
            return status.get();
        }
        public StringProperty statusProperty(){
            return status;
        }
        public void setStatus(String status){
            this.status.set(status);
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
        Slots[] slots = new Slots[datenClient.getSpielerNamen().length];

        for (int i = 0; i < datenClient.getSpielerNamen().length; i++){
            slots[i] = new Slots(datenClient.getSpielerIP()[i], datenClient.getSpielerNamen()[i], datenClient.getSpielerBereit()[i]);
        }
        anzeige.setSlots(slots);
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
