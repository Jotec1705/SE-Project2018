package KommunikationClient;

import GUIClient.IGUIClientCallback;
import KommunikationServer.ISpiellogikAnzeigedatenRMI;

public class ClientKommunikationNachServer implements IClientKommunikation{

    ISpiellogikAnzeigedatenRMI server;

    public ClientKommunikationNachServer(ISpiellogikAnzeigedatenRMI logikUndAnzeige){
        this.server = logikUndAnzeige;
    }

    @Override
    public boolean spielerAnmelden(String nameSpieler, String passwort) {

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
       //Wird nur einmal in der Main von KommunikationClient aufgerufen, und dann nicht mehr
        /* try {
            return server.beobachterHinzufuegen(beobachter);
        }catch (Exception e){
            System.err.println("Methodenaufruf beim Server exception:");
            e.printStackTrace();
        }*/
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
