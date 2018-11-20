package Spiellogik;

import GUIServer.IGUIServerCallback;
import KommunikationServer.IKommunikationServerCallback;
import Spieldaten.*;

public class Spiellogik implements ISpiellogik, ISpielkontrolle{


    ISpieldaten daten = null;

    public void setSpieldaten(ISpieldaten daten){
        this.daten = daten;
    }

    Integer anzahlGebaeudeSpieler;
    Integer [] nachbarGebaeude;
    String besitzerGebaeude;
    boolean [] spielerBereit;


    boolean istSpielGeladen(){
        return true;
    }

    boolean alleSpielerBereit(){
       spielerBereit = daten.spielerBereit();
       for(boolean b : spielerBereit) if(!b) return false;
            return true;
    }

    boolean vergleicheNameSpieler(){
        return true;
    }

    boolean vergleicheNachbargebaeude(){
        return true;
    }

    boolean mindEinErstieGebaeude(Integer gebaeude){
        if(daten.anzahlErstiesGebaeude(gebaeude) >= 1)
        return true;
        return false;
    }

    boolean vergleicheMissionskarte(){
        return true;
    }


    @Override
    public boolean spielAnlegen(int spielerAnzahl) {
        return daten.spielAnlegen(spielerAnzahl);
    }

    @Override
    public boolean spielLaden(String dateipfad) {
        return false;
    }

    @Override
    public boolean spielStarten() {
        return false;
    }

    @Override
    public boolean spielBeenden() {
        return false;
    }

    @Override
    public boolean spielSpeichern(String dateipfad) {
        return false;
    }

    @Override
    public boolean beobachterHinzufuegen(IGUIServerCallback beobachter) {
        return false;
    }

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
}
