package GUIServer;

import javafx.stage.Stage;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DatenModell {
    private Stage primaryStage = null;
    private String[] spielerNamen = null;
    private String[] spielerIP = null;
    private boolean[] spielerBereit = null;
    private InetAddress host = null;

    public DatenModell(Stage primaryStage){
        this.primaryStage = primaryStage;
        try {
            host = InetAddress.getLocalHost();
        }
        catch (UnknownHostException e){
            System.out.println("Der Localhost ist nicht ermittelbar");
        }
    }

    public void setSpielerNamen(String[] spielerNamen){
        this.spielerNamen = spielerNamen;
    }

    public void setSpielerIP(String[] spielerIP){
        this.spielerIP = spielerIP;
    }

    public void setSpielerBereit(boolean[] spielerBereit){
        this.spielerBereit = spielerBereit;
    }

    public String[] getSpielerNamen(){
        return this.spielerNamen;
    }

    public String[] getSpielerIP() {
        return this.spielerIP;
    }

    public boolean[] getSpielerBereit() {
        return this.spielerBereit;
    }

    public String getHostIP() {
        return this.host.getHostAddress();
    }

    public Stage getPrimaryStage() {
        return this.primaryStage;
    }
}
