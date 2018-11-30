package GUIClient;

import javafx.stage.Stage;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DatenClient {
    private Stage stage;
    private InetAddress client;

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
}
