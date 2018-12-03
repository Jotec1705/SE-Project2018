package GUIClient;

import javafx.stage.Stage;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DatenClient {
    private Stage stage;
    private InetAddress client;
    private String[] spielerNamen;
    private String[] spielerIP;
    private boolean[] spielerBereit;

    public DatenClient(Stage stage){
        this.stage = stage;
        try {
            client = InetAddress.getLocalHost();
        }catch (UnknownHostException e){
            System.out.println("Der Localhost ist nicht ermittelbar");
        }
    }

    public Stage getStage() {
        return this.stage;
    }

    public void setSpielerNamen(String[] spielerNamen) {
        this.spielerNamen = spielerNamen;
    }

    public void setSpielerIP(String[] spielerIP) {
        this.spielerIP = spielerIP;
    }

    public void setSpielerBereit(boolean[] spielerBereit){
        this.spielerBereit = spielerBereit;
    }

    public String[] getSpielerNamen(){
        return this.spielerNamen;
    }

    public String[] getSpielerIP(){
        return this.spielerIP;
    }

    public String[] getSpielerBereit(){
        String[] spielerBereit = null;
        for(int i = 0; i < this.spielerBereit.length; i++){
            if(this.spielerBereit[i] == true) {
                spielerBereit[i] = "\u2713";
            }
            else {
                spielerBereit[i] = "\u2718";
            }
        }
        return spielerBereit;
    }
}
