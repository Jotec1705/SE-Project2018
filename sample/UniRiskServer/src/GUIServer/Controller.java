package GUIServer;

import Spieldaten.Spieldaten;
import Spiellogik.Spiellogik;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.FileWriter;
import java.io.IOException;

//import javax.json.*;


public class Controller {
    private DatenModell daten;
    public Anzeige anzeige;
    public Spieldaten spieldaten;
    public Spiellogik logik;

    public Controller(DatenModell daten, Spieldaten spieldaten, Spiellogik logik){
        this.spieldaten = spieldaten;
        this.logik = logik;
        this.daten = daten;
        this.anzeige = new Anzeige();
        this.anzeige.setIpAdresseServer("Server IP : " + this.daten.getServerIP());

        this.anzeige.getNeuesSpielAnlegen().setOnAction(e -> buttonNeuesSpielAnlegenOnClick());
        this.anzeige.getSpielAnlegen().setOnAction(e -> buttonSpielAnlegenOnClick());
        this.anzeige.getSpielLaden().setOnAction(e -> buttonSpielLadenOnClick());
        this.anzeige.getDateiAuswaehlen().setOnAction(e -> buttonDateiAuswaehlenOnClick());
        this.anzeige.getSpielStarten().setOnAction(e -> buttonSpielStartenOnClick());
    }

    public void buttonNeuesSpielAnlegenOnClick(){
        showSpielAnlegen();
    }

    public void  buttonSpielAnlegenOnClick(){
        String spielerAnzahl = anzeige.getspielerAnzahlEingabe();
        if(spielerAnzahl.equals("3") || spielerAnzahl.equals("4") || spielerAnzahl.equals("5")){
            logik.spielAnlegen(Integer.parseInt(spielerAnzahl));
            showLobby();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Falsche Spieleranzahl eingegeben");
            alert.setContentText("Bitte eine Spieleranzahl von 3-5 Spielern eingeben");
            alert.showAndWait();
        }

    }

    public void buttonSpielLadenOnClick(){
        showSpielLaden();
    }

    public void buttonDateiAuswaehlenOnClick(){
        daten.setAusgewaehlteDateiZumLaden(anzeige.getFileChooser().showOpenDialog(daten.getPrimaryStage()));
        anzeige.setAusgewaehlteDatei("Ausgewählte Datei : \n" + daten.getAusgewaehlteDateiZumLaden().getName());
        logik.spielLaden(daten.getAusgewaehlteDateiZumLaden().getPath());
    }

    public void buttonSpielStartenOnClick(){
        logik.spielStarten();
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

    public void spielSpeichern(){

/*
        JsonObjectBuilder builder = Json.createObjectBuilder();
        builder.add("vorname", "Paul");
        builder.add("nachname", "Schmitz");
        builder.add("alter", 14);

        JsonArrayBuilder arrb = Json.createArrayBuilder();

        JsonObjectBuilder job = Json.createObjectBuilder();
        job.add("stil", "rock");
        job.add("band", "U2");
        arrb.add(job);

        job = Json.createObjectBuilder();
        job.add("stil", "metal");
        job.add("band", "Black Sabbath");
        arrb.add(job);

        builder.add("musik", arrb);
        builder.add("hungrig", true);
        JsonObject jo = builder.build();

        try {
            FileWriter fw = new FileWriter("test.txt");
            JsonWriter jsonWriter = Json.createWriter(fw);
            jsonWriter.writeObject(jo);
            jsonWriter.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }



    public class Slots {
        private StringProperty ipAdresse;
        private StringProperty name;
        private BooleanProperty status;

        public Slots(String ipAdresse, String name, Boolean status){

            this.ipAdresse = new SimpleStringProperty(ipAdresse);

            this.name = new SimpleStringProperty(name);
            this.status = new SimpleBooleanProperty(status);

            /*if(ipAdresse == null){
                this.ipAdresse = new SimpleStringProperty("o");
            }
            if(name == null){
                this.name = new SimpleStringProperty("2");
            }*/
        }

        public String getIpAdresse() {
            return ipAdresse.get();
        }

        public StringProperty ipAdresseProperty() {
            return ipAdresse;
        }

        public void setIpAdresse(String ipAdresse) {
            this.ipAdresse.set(ipAdresse);
        }

        public String getName() {
            return name.get();
        }

        public StringProperty nameProperty() {
            return name;
        }

        public void setName(String name) {
            this.name.set(name);
        }

        public boolean isStatus() {
            return status.get();
        }

        public BooleanProperty statusProperty() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status.set(status);
        }
    }


    private void benoetigteMitspielerCreateAndView(){
        ObservableList<String> benoetigteMitspieler = null;
        benoetigteMitspieler = FXCollections.observableArrayList(daten.getBenoetigteMitspieler());
        anzeige.setBenoetigteMitspieler(benoetigteMitspieler);
    }

    private void slotsCreateAndView(){
        ObservableList<Slots> slotsList = anzeige.getSlots();
        slotsList.clear();


        for(int i = 1; i < daten.getSpielerNamen().length;i++){
            slotsList.add(new Slots(daten.getSpielerIP()[i], daten.getSpielerNamen()[i], daten.getSpielerBereit()[i]));
        }


    }



    private void setSpielerNamenInDatenModell(){
        daten.setSpielerNamen(spieldaten.spielerNamen());
    }

    private void setSpielerIPInDatenModell(){
        daten.setSpielerIP(spieldaten.ipAdressen());
    }

    private void setSpielerBereitInDatenModell(){
        daten.setSpielerBereit(spieldaten.spielerBereit());
    }

    private void setbenoetigteMitspielerInDatenModell(){

    }

    public boolean datenModellAktualisierenSpielLaden(){
        setbenoetigteMitspielerInDatenModell();
        return true;
    }
    public boolean datenModellAktualisierenLobby(){
        try {
            setSpielerNamenInDatenModell();
            setSpielerIPInDatenModell();
            setSpielerBereitInDatenModell();
            slotsCreateAndView();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
}
