package GUIClient;

import KommunikationClient.ClientKommunikationNachServer;

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

    public void getClickGebaeude(Integer ID) {
        this.anzeige.getErstiesAnzahl(ID);
    }
}
