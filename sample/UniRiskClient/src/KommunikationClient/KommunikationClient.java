package KommunikationClient;

import GUIClient.IGUIClientCallback;
import KommunikationServer.IKommunikationServerCallback;
import KommunikationServer.ISpiellogikAnzeigedatenRMI;

import java.rmi.registry.*;
import java.rmi.Naming;
import java.rmi.server.*;



public class KommunikationClient {
    //Konstruktor. Hat kein Argument. Ruft den Konstrukter der Superklasse (Object) auf
    public KommunikationClient(){
        super();
    }

    private static String serverLokation = "127.0.0.1:1099";




    /*private static void interruptRMIReaper() {
        Thread.getAllStackTraces().keySet().forEach(t -> {
            if ("RMI Reaper".equals(t.getName())) {
                t.interrupt();
                try {
                    t.join();
                } catch (InterruptedException ex) {
                }
            }
        });
    }*/

    public static void main(String args[]) {
        //IP-Adresse des Hosts, auf dem das Remote Object liegt.
        serverLokation = args[0];

        try {
            //RMI Registry vom Host holen (Registry Port ist per default 1099)
            //Registry registry = LocateRegistry.getRegistry(args[0]);

            //Erstes Remote Objekt holen
            String name1 = "SpiellogikUndAnzeige";
            ISpiellogikAnzeigedatenRMI logikUndAnzeige = (ISpiellogikAnzeigedatenRMI) Naming.lookup("//" + serverLokation + "/" + name1);
            System.out.println("Das Objekt SpiellogikUndAnzeige vom Host geholt.");

            //Remote Interface an den Server übergeben, um die Callback Funktionalität zu ermöglichen.
            ICallbackRMI beobachter = new CallbackRMIAufLokal();
            logikUndAnzeige.beobachterHinzufuegen((IKommunikationServerCallback) beobachter);

            //Die Klasse ClientKommunikationNachServer mit dem entfernten Objekt "versorgen"
            IClientKommunikation zumServer = new ClientKommunikationNachServer(logikUndAnzeige);

            /*//Zweites Remote Objekt holen
            String name2 = "Anzeigedaten";
            Object anzeige = (Object) registry.lookup(name2);
            System.out.println("Das Objekt Anzeigedaten vom Host geholt.");*/

        } catch (Exception e) {
            System.err.println("KommunikationClient exception");
            e.printStackTrace();
        }


    }

}
