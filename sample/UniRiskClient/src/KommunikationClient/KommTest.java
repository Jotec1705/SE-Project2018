package KommunikationClient;

public class KommTest {

    public static void main(String[] args) {
        ClientKommunikationNachServer nachServer = new ClientKommunikationNachServer();

        boolean result = false;

        result = nachServer.spielerAnmelden("Horst", "blutwurst1", "127.0.0.1");
        System.out.println("Spieler angemeldet:" + result);






    }
}
