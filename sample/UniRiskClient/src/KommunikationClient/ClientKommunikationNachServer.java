package KommunikationClient;

import GUIClient.IGUIClientCallback;
import KommunikationServer.IKommunikationServerCallback;
import KommunikationServer.ISpiellogikAnzeigedatenRMI;

import java.rmi.Naming;

public class ClientKommunikationNachServer implements IClientKommunikation{

    ISpiellogikAnzeigedatenRMI server;

    public void setRMIObjekt(ISpiellogikAnzeigedatenRMI logikUndAnzeige){

        this.server = logikUndAnzeige;
    }

    @Override
    public boolean spielerAnmelden(String nameSpieler, String passwort, String ipAdresse) {

        //Server Location sieht so aus: "127.0.0.1:1099"
        String serverLokation = ipAdresse;

        try {

            //Remote Objekt holen
            String name1 = "SpiellogikUndAnzeige";
            //RMI Registry vom Host holen (Registry Port ist per default 1099)
            ISpiellogikAnzeigedatenRMI logikUndAnzeige = (ISpiellogikAnzeigedatenRMI) Naming.lookup("//" + serverLokation + "/" + name1);
            System.out.println("Das Objekt SpiellogikUndAnzeige vom Host geholt.");

            //Remote Interface an den Server übergeben, um die Callback Funktionalität zu ermöglichen.
            ICallbackRMI beobachter = new CallbackRMIAufLokal();
            logikUndAnzeige.beobachterHinzufuegen((IKommunikationServerCallback) beobachter);

            //Die Klasse ClientKommunikationNachServer mit dem entfernten Objekt "versorgen"
            ClientKommunikationNachServer zumServer = new ClientKommunikationNachServer();
            zumServer.setRMIObjekt(logikUndAnzeige);


        } catch (Exception e) {
            System.err.println("Verbindungs exception");
            e.printStackTrace();
        }

        try {
            return server.spielerAnmelden(nameSpieler, passwort);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        //Das hier wird nicht ausgeführt wenn keine Exception auftritt
        return false;

    }

    @Override
    public boolean spielerAusgestiegen(String nameSpieler) {

        try {
            return server.spielerAusgestiegen(nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean spielerBereitMelden(String nameSpieler) {
        try {
            return server.spielerBereitMelden(nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String aktuellePhase() {
        try {
            return server.aktuellePhase();
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler) {
        try {
            return server.erstiesAnzahlErhoehen(gebaeude, nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer[] anzahlBonuskarten(String nameSpieler) {
        try {
            return server.anzahlBonuskarten(nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return new Integer[0];
    }

    @Override
    public boolean tauschBonuskarten(String nameSpieler, Integer[] bonuskarten) {
        /*try {
            return server.tauschBonuskarten(nameSpieler, bonuskarten);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }*/
        return false;
    }

    @Override
    public Integer anzahlZuVerteilendeErsties(String nameSpieler) {
        try {
            return server.anzahlZuVerteilendeErsties(nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer[] anzahlErstiesAufGebaeude() {
        try {
            return server.anzahlErstiesAufGebaeude();
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return new Integer[0];
    }

    @Override
    public boolean angriffVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) {
        try {
            return server.angriffVonNach(gebaeudeUrsprung, anzahlUrsprung, gebaeudeZiel, nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer[] eigeneGebaeude(String nameSpieler) {
        try {
            return server.eigeneGebaeude(nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return new Integer[0];
    }

    @Override
    public Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        try {
            return server.angreifbareNachbarGebaeude(gebaeude, nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return new Integer[0];
    }

    @Override
    public boolean gewuerfelt(String nameSpieler) {
        try {
            return server.gewuerfelt(nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean versetzenVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) {
        try {
            return server.versetzenVonNach(gebaeudeUrsprung, anzahlUrsprung, gebaeudeZiel, nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        try {
            return server.eigeneNachbarGebaeude(gebaeude, nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return new Integer[0];
    }

    @Override
    public boolean zugBeendet(String nameSpieler) {
        try {
            return server.zugBeendet(nameSpieler);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean beobachterHinzufuegen(IGUIClientCallback beobachter) {

        try {
            return server.beobachterHinzufuegen((IKommunikationServerCallback) beobachter);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Integer[] farbeSpieler() {
        try {
            return server.farbeSpieler();
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }
        return new Integer[0];
    }
}
