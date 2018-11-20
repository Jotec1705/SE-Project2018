package KommunikationServer;




import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;


public class KommunikationServer{

    //Konstruktor. Hat kein Argument. Ruft den Konstrukter der Superklasse (Object) auf
    public KommunikationServer() {
        super();
    }

    public static void main(String[] args) {

        System.setProperty("sun.rmi.transport.connectionTimeout", "5000");
        System.getProperties().forEach((key, value) -> System.out.println(key + " : " + value));

        //RMI registry einbinden (Registry Port ist per default 1099)
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.out.println("Registry ready");
        } catch (Exception e) {
            System.out.println("Registry exception: " + e.getMessage());
        }

        try {
            //Erstellen des ersten Remote Objekt
            String name1 = "SpiellogikUndAnzeige";
            ISpiellogikAnzeigedatenRMI logikUndAnzeige = new SpiellogikAnzeigedatenRMI();

            //Objekt exportieren (Wird dadurch erreicht dass die Klasse des Objekts direkt von UnicastRemoteObject erbt)

            //Objekt mit Namen und zugehörigen "Stumpf" in die RMI registry einfügen
            Naming.rebind(name1, logikUndAnzeige);
            System.out.println("Spiellogik und Anzeigedaten gebunden(In die Registry eingefügt).");

        } catch (Exception e) {
            System.err.println("KommunikationServer Objekt1 exception:");
            e.printStackTrace();
        }

        try {
            //Erstellen des zweiten Remote Objekt
            String name2 = "ServerCallback";
            ICallbackRMI serverCallback = new CallbackRMI();

            //Objekt exportieren (Wird dadurch erreicht dass die Klasse des Objekts direkt von UnicastRemoteObject erbt)

            //Objekt mit Namen und zugehörigen "Stumpf" in die RMI registry einfügen
            Naming.rebind(name2, serverCallback);
            System.out.println("ServerCallback gebunden(In die Registry eingefügt).");
        } catch (Exception e){
            System.err.println("KommunikationServer Objekt2 exception:");
            e.printStackTrace();
        }

    }

}