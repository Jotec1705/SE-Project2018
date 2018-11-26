package KommunikationServer;




import Spieldaten.IAnzeigedaten;
import Spiellogik.ISpiellogik;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.Naming;


public class KommunikationServer{

    //Konstruktor. Hat kein Argument. Ruft den Konstrukter der Superklasse (Object) auf
    public KommunikationServer() {
        super();
    }

    //Objekte anlegen
    private static ISpiellogik logik;
    private static IAnzeigedaten anzeige;

    //setter methoden dafür, siehe SpiellogikAnzeigedatenRMI
    public void setSpiellogik(ISpiellogik logik){

        this.logik = logik;

    }

    public void setAnzeige(IAnzeigedaten anzeige){

        this.anzeige = anzeige;
    }

    public static void main(String[] args) {

        System.setProperty("sun.rmi.transport.connectionTimeout", "5000");
        System.getProperties().forEach((key, value) -> System.out.println(key + " : " + value));

        //RMI registry einbinden (Registry Port ist per default 1099)
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            System.out.println("Registry Bereit");
        } catch (Exception e) {
            System.out.println("Registry exception: " + e.getMessage());
        }

        try {
            //Erstellen des ersten Remote Objekt
            String name1 = "SpiellogikUndAnzeige";
            ISpiellogikAnzeigedatenRMI logikUndAnzeige = new SpiellogikAnzeigedatenRMI();
            //rufe die beiden Settermethoden auf. mit Parameter von Bosin.
            ((SpiellogikAnzeigedatenRMI) logikUndAnzeige).setSpiellogik(logik);
            ((SpiellogikAnzeigedatenRMI) logikUndAnzeige).setAnzeige(anzeige);

            //Objekt exportieren (Wird dadurch erreicht dass die Klasse des Objekts direkt von UnicastRemoteObject erbt)

            //Objekt mit Namen und zugehörigen "Stumpf" in die RMI registry einfügen
            Naming.rebind(name1, logikUndAnzeige);
            System.out.println("Spiellogik und Anzeigedaten gebunden(In die Registry eingefügt).");

        } catch (Exception e) {
            System.err.println("KommunikationServer Objekt1 exception:");
            e.printStackTrace();
        }

    }

}