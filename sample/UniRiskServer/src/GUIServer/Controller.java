package GUIServer;

import Spieldaten.Spieldaten;
import Spiellogik.Spiellogik;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Controller {
    private DatenModell daten;
    private Anzeige anzeige;
    public Spieldaten spieldaten;
    public Spiellogik logik;

    public Controller(DatenModell daten, Spieldaten spieldaten, Spiellogik logik){
        this.spieldaten = spieldaten;
        this.logik = logik;
        this.daten = daten;
        this.anzeige = new Anzeige();
        this.anzeige.setIpAdresseServer("Server IP : " + this.daten.getServerIP());
    }

    public void showStart(){
        anzeige.showStart(daten.getPrimaryStage());
    }

    public void showSpielAnlegen() {
        anzeige.showSpielAnlegen(daten.getPrimaryStage());
    }

    public void showSpielLaden() {
        anzeige.showSpielLaden(daten.getPrimaryStage());
    }

    public void showLobby() {
        anzeige.showLobby(daten.getPrimaryStage());
    }

    class Slots {
        private String ipAdresse;
        private String name;
        private boolean status;

        public Slots(String ipAdresse, String name, boolean status){
            this.ipAdresse = ipAdresse;
            this.name = name;
            this.status = status;
        }

    }

    private void benoetigteMitspielerCreateAndView(){
        ObservableList<String> benoetigteMitspieler = null;
        benoetigteMitspieler = FXCollections.observableArrayList(daten.getBenoetigteMitspieler());
        anzeige.setBenoetigteMitspieler(benoetigteMitspieler);
    }

    private void slotsCreateAndView(){
        ObservableList<Slots> slotsList = null;

        Slots[] slots = new Slots[daten.getSpielerNamen().length];

        for(int i = 0; i < daten.getSpielerNamen().length;i++){
            slots[i] = new Slots(daten.getSpielerIP()[i], daten.getSpielerNamen()[i], daten.getSpielerBereit()[i]);
        }

        slotsList = FXCollections.observableArrayList(slots);
        anzeige.setSlots(slotsList);

    }



    private void setSpielerNamenInDatenModell(){
        daten.setSpielerNamen(spieldaten.spielerNamen());
    }

    private void setSpielerIPInDatenModell(){

    }

    private void setSpielerBereitInDatenModell(){

    }

    private void setbenoetigteMitspielerInDatenModell(){

    }

    public boolean datenModellAktualisieren(){

        return true;
    }
}
