package Spiellogik;

import Spieldaten.*;

public class Spiellogik implements ISpieldaten{

    Spieldaten daten = new Spieldaten();

    Integer anzahlGebaeudeSpieler;
    Integer [] nachbarGebaeude;
    String besitzerGebaeude;
    boolean [] spielerBereit;


    boolean istSpielGeladen(){
        return true;
    }

    boolean alleSpielerBereit(){
       spielerBereit = spielerBereit();
       for(boolean b : spielerBereit) if(!b) return false;
            return true;
    }

    boolean vergleicheNameSpieler(){
        return true;
    }

    boolean vergleicheNachbargebaeude(){
        return true;
    }

    boolean mindEinErstieGebaeude(){
        return true;
    }

    boolean vergleicheMissionskarte(){
        return true;
    }


    //####################### ISpieldaten ##################
    @Override
    public Integer anzahlGebaeudeSpieler(String nameSpieler) {
        return anzahlGebaeudeSpieler;
    }

    @Override
    public String besitzerGebaeude(Integer gebaeude) {
        return besitzerGebaeude;
    }

    @Override
    public boolean besitzerGebaeudeAnpassen(Integer gebaeude, String nameSpieler) {
        return false;
    }

    @Override
    public Integer[] nachbarGebaeude(Integer gebaeude) {
        return nachbarGebaeude;
    }

    @Override
    public Integer anzahlErstiesGebaeude(Integer gebaeude) {
        return null;
    }

    @Override
    public boolean anzahlErstiesAnpassen(Integer gebaeude, Integer anzahlErsties) {
        return false;
    }

    @Override
    public Integer anzahlFachbereicheSpieler(String nameSpieler) {
        return null;
    }

    @Override
    public boolean besitzerFachbereichAnpassen(Integer fachbereich, String nameSpieler) {
        return false;
    }

    @Override
    public Integer anzahlDerBonuskarten(String nameSpieler, Bonuskarte typBonuskarte) {
        return null;
    }

    @Override
    public boolean anzahlDerBonuskartenAnpassen(String nameSpieler, Bonuskarte typBonuskarte, Integer anzahlBonuskarten) {
        return false;
    }

    @Override
    public Missionskarte missionskarteSpieler(String nameSpieler) {
        return null;
    }

    @Override
    public boolean aktuellePhaseSetzen(String phase) {
        return false;
    }

    @Override
    public boolean naechsterSpieler() {
        return false;
    }

    @Override
    public boolean spielAnlegen(int spielerAnzahl) {
        return false;
    }

    @Override
    public boolean spielerAnmelden(String nameSpieler, String passwort) {
        return false;
    }

    @Override
    public boolean[] spielerBereit() {
        return new boolean[4];
    }

    @Override
    public String aktuellerSpieler() {
        return null;
    }

    @Override
    public Zustand spielZustandHolen() {
        return null;
    }

    @Override
    public boolean spielZustandSetzen(Zustand aktuellerZustand) {
        return false;
    }
}
