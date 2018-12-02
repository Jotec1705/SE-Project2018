package KommunikationServer;

import Spieldaten.IAnzeigedaten;
import Spiellogik.ISpiellogik;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class SpiellogikAnzeigedatenRMI extends UnicastRemoteObject implements ISpiellogikAnzeigedatenRMI {

    public SpiellogikAnzeigedatenRMI() throws RemoteException {
    }

    SpiellogikSpieldatenDummy dummy = new SpiellogikSpieldatenDummy();

    ICallbackRMI clientObjekt;

    ISpiellogik logik;
    IAnzeigedaten anzeige;
    Map<String, ICallbackRMI> clients;

    public void setMap(Map clients){
        this.clients = clients;
    }

    public void setSpiellogik(ISpiellogik logik){

        this.logik = logik;

    }

    public void setAnzeige(IAnzeigedaten anzeige){

        this.anzeige = anzeige;
    }


    @Override
    public boolean spielerAnmelden(String nameSpieler, String passwort) throws RemoteException {
        clients.put(nameSpieler, clientObjekt);
        System.out.println(clients);
        return dummy.spielerAnmelden(nameSpieler, passwort);
        //return logik.spielerAnmelden(nameSpieler, passwort);

    }

    @Override
    public boolean spielerAusgestiegen(String nameSpieler) throws RemoteException {
        return dummy.spielerAusgestiegen(nameSpieler);
    }

    @Override
    public boolean spielerBereitMelden(String nameSpieler) throws RemoteException {
        return dummy.spielerBereitMelden(nameSpieler);
    }

    @Override
    public boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler) throws RemoteException {
        return dummy.erstiesAnzahlErhoehen(gebaeude, nameSpieler);
    }

    @Override
    public boolean angriffVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) throws RemoteException {
        return dummy.angriffVonNach(gebaeudeUrsprung, anzahlUrsprung, gebaeudeZiel, nameSpieler);
    }

    @Override
    public boolean versetzenVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) throws RemoteException {
        return dummy.versetzenVonNach(gebaeudeUrsprung, anzahlUrsprung, gebaeudeZiel, nameSpieler);
    }

    @Override
    public boolean zugBeendet(String nameSpieler) throws RemoteException {
        return dummy.zugBeendet(nameSpieler);
    }

    @Override
    public boolean gewuerfelt(String nameSpieler) throws RemoteException {
        return dummy.gewuerfelt(nameSpieler);
    }

    @Override
    public Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) throws RemoteException {
        return dummy.angreifbareNachbarGebaeude(gebaeude, nameSpieler);
    }

    @Override
    public Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler) throws RemoteException {
        return dummy.eigeneNachbarGebaeude(gebaeude, nameSpieler);
    }

    @Override
    public String[] spielerNamen() throws RemoteException {
        return dummy.spielerNamen();
    }

    @Override
    public boolean[] spielerBereit() throws RemoteException {
        return dummy.spielerBereit();
    }

    @Override
    public String[] ipAdressen() throws RemoteException {
        return dummy.ipAdressen();
    }

    @Override
    public Integer[] anzahlErstiesAufGebaeude() throws RemoteException {
        return dummy.anzahlErstiesAufGebaeude();
    }

    @Override
    public Integer[] anzahlBonuskarten(String nameSpieler) throws RemoteException {
        return dummy.anzahlBonuskarten(nameSpieler);
    }

    @Override
    public Integer[] farbeSpieler() throws RemoteException {
        return dummy.farbeSpieler();
    }

    @Override
    public Integer anzahlZuVerteilendeErsties(String nameSpieler) throws RemoteException {
        return dummy.anzahlZuVerteilendeErsties(nameSpieler);
    }

    @Override
    public String missionskarteInhalt(String nameSpieler) throws RemoteException {
        return dummy.missionskarteInhalt(nameSpieler);
    }

    @Override
    public String aktuellePhase() throws RemoteException {
        return dummy.aktuellePhase();
    }

    @Override
    public Integer[] eigeneGebaeude(String nameSpieler) throws RemoteException {
        return dummy.eigeneGebaeude(nameSpieler);
    }

    @Override
    public boolean beobachterHinzufuegen(ICallbackRMI beobachter) throws RemoteException {
        //Remote Interface vom Client hierüber übergeben
        if(beobachter == null){
            System.out.println("Fehler2");
        }
        dummy.beobachterHinzufuegen(beobachter);
        this.clientObjekt = beobachter;

        //Setze das Clientobjekt in das Objekt, welches via RMI kommuniziert
        ICallbackRMI callbackObjektOnline = new CallbackRMI();
        ((CallbackRMI) callbackObjektOnline).setClientObjekt(beobachter);
        ((CallbackRMI) callbackObjektOnline).setMap(clients);

        //Setze das Objekt, dass via RMI kommuniziert in das Objekt welches lokal zur verfügung steht und nicht kommuniziert.
        IKommunikationServerCallback callbackObjektOffline = new KommunikationServerCallback();
        ((KommunikationServerCallback) callbackObjektOffline).setOnlineObjekt(callbackObjektOnline);

        //Setze das Callbackobjekt in die Spiellogik
        //logik.beobachterHinzufuegen(callbackObjektOffline);
        return true;
    }
}
