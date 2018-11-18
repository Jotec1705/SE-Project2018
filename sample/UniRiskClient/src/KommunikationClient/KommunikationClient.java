package KommunikationClient;

import GUIClient.IGUIClientCallback;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class KommunikationClient {
    //Konstruktor. Hat kein Argument. Ruft den Konstrukter der Superklasse (Object) auf
    public KommunikationClient(){
        super();
    }


    public static void main(String args[]) {
        //IP-Adresse des Hosts, auf dem das Remote Object liegt.
        args[0] = "192.168.0.100";

        //Der Manager schützt davor dass heruntergeladener Code Zugriff auf System Ressourcen bekommt.
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            //RMI Registry vom Host holen (Registry Port ist per default 1099)
            Registry registry = LocateRegistry.getRegistry(args[0]);

            //Erstes Remote Objekt holen
            String name1 = "Spiellogik";
            Object logik = (Object) registry.lookup(name1);
            System.out.println("Das Objekt Spiellogik vom Host geholt.");

            //Zweites Remote Objekt holen
            String name2 = "Anzeigedaten";
            Object anzeige = (Object) registry.lookup(name2);
            System.out.println("Das Objekt Anzeigedaten vom Host geholt.");


        } catch (Exception e) {
            System.err.println("KommunikationClient exception");
            e.printStackTrace();
        }
    }

}
