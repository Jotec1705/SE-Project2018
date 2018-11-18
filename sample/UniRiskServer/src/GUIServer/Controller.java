package GUIServer;

public class Controller {
    private DatenModell daten;
    private Anzeige anzeige;

    public Controller(DatenModell daten){
        this.daten = daten;
        this.anzeige = new Anzeige();
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
}
