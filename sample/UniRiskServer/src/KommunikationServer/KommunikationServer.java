package KommunikationServer;
import Spieldaten.IAnzeigedaten;
import Spiellogik.ISpiellogik;


import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class KommunikationServer implements ISpiellogik, IAnzeigedaten, IKommunikationServerCallback{

    //Konstruktor. Hat kein Argument. Ruft den Konstrukter der Superklasse (Object) auf
    public KommunikationServer(){
        super();
    }

    public static void main(String[] args) {

        //Der Manager schützt davor dass heruntergeladener Code Zugriff auf System Ressourcen bekommt.
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        try {
            //RMI registry einbinden (Registry Port ist per default 1099)
            Registry registry = LocateRegistry.getRegistry();


            //Erstellen des ersten Remote Objekt
            String name1 = "Spiellogik";
            ISpiellogik logik = new KommunikationServer();
            //Objekt exportieren
            ISpiellogik stubLogik = (ISpiellogik) UnicastRemoteObject.exportObject(logik, 0);
            //Objekt mit Namen und zugehörigen "Stumpf" in die RMI registry einfügen
            registry.rebind(name1, stubLogik);
            System.out.println("Spiellogik gebunden.");

            //Erstellen des zweiten Remote Objekt
            String name2 = "Anzeigedaten";
            IAnzeigedaten anzeige = new KommunikationServer();
            //Objekt exportieren
            IAnzeigedaten stubAnzeige = (IAnzeigedaten) UnicastRemoteObject.exportObject(anzeige, 0);
            //Objekt mit Namen und zugehörigen "Stumpf" in die RMI registry einfügen
            registry.rebind(name2, stubAnzeige);
            System.out.println("Spiellogik gebunden.");

        }catch(Exception e){
            System.err.println("KommunikationServer exception:");
            e.printStackTrace();
        }

    }

    //###############################IANZEIGEDATEN######################################################################
    @Override
    public Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        return new Integer[0];
    }

    @Override
    public Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        return new Integer[0];
    }

    @Override
    public String[] spielerNamen() {
        return new String[0];
    }

    @Override
    public boolean[] spielerBereit() {
        return new boolean[0];
    }

    @Override
    public String[] ipAdressen() {
        return new String[0];
    }

    @Override
    public Integer[] anzahlErstiesAufGebaeude() {
        return new Integer[0];
    }

    @Override
    public Integer[] anzahlBonuskarten(String nameSpieler) {
        return new Integer[0];
    }

    @Override
    public Integer[] farbeSpieler() {
        return new Integer[0];
    }

    @Override
    public Integer anzahlZuVerteilendeErsties(String nameSpieler) {
        return null;
    }

    @Override
    public String missionskarteInhalt(String nameSpieler) {
        return null;
    }

    @Override
    public String aktuellePhase() {
        return null;
    }

    @Override
    public Integer[] eigeneGebaeude(String nameSpieler) {
        return new Integer[0];
    }

    //######################################################ISPIELLOGIK#########################################################

    @Override
    public boolean spielerAnmelden(String nameSpieler, String passwort) {
        return false;
    }

    @Override
    public boolean spielerAusgestiegen(String nameSpieler) {
        return false;
    }

    @Override
    public boolean spielerBereitMelden(String nameSpieler) {
        return false;
    }

    @Override
    public boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler) {
        return false;
    }

    @Override
    public boolean angriffVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) {
        return false;
    }

    @Override
    public boolean versetzenVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) {
        return false;
    }

    @Override
    public boolean zugBeendet(String nameSpieler) {
        return false;
    }

    @Override
    public boolean gewuerfelt(String nameSpieler) {
        return false;
    }

    @Override
    public boolean beobachterHinzufuegen(IKommunikationServerCallback beobachter) {
        return false;
    }
    //#########################################IKOMMUNIKATIONSERVERCALLBACK###################################################
    @Override
    public boolean spielBeendet() {
        return false;
    }

    @Override
    public boolean zugZuteilung(String nameSpieler) {
        return false;
    }

    @Override
    public boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb) {
        return false;
    }

    @Override
    public boolean aktualisierenKarte() {
        return false;
    }

    @Override
    public boolean aktualisierenLobby() {
        return false;
    }

    @Override
    public boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen) {
        return false;
    }
}
