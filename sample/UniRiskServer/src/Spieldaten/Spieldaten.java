package Spieldaten;

import java.util.List;

public class Spieldaten implements ISpieldaten{


   // Gebaeude geb = new Gebaeude("test",1,1,"tom");
   // Gebaeude geb2 = new Gebaeude("test2",21,2,"tim");
    @Override
    public Integer anzahlGebaeudeSpieler(String nameSpieler) {

        return null;
    }

    @Override
    public String besitzerGebaeude(Integer gebaeude) {

        return null;
    }

    @Override
    public boolean besitzerGebaeudeAnpassen(Integer gebaeude, String nameSpieler) {
        return false;
    }

    @Override
    public Integer[] nachbarGebaeude(Integer gebaeude) {
        //Abbruchkriterien
        Integer[] nachbarGebaeude;
        switch(gebaeude){
            case 1: nachbarGebaeude = new Integer[]{2, 3, 12, 13};
                break;
            case 2: nachbarGebaeude = new Integer[]{1,3,16,22,27,33};
                break;
            case 3: nachbarGebaeude = new Integer[]{1,2,4,6,7,13};
                break;
            case 4: nachbarGebaeude = new Integer[]{3,5,6};
                break;
            case 5: nachbarGebaeude = new Integer[] {4,6};
                break;
            case 6: nachbarGebaeude = new Integer[]{3,4,5,7,9};
                break;
            case 7: nachbarGebaeude = new Integer[]{3,6,8,9};
                break;
            case 8: nachbarGebaeude = new Integer[]{7,9};
                break;
            case 9: nachbarGebaeude = new Integer[]{6,7,8,16};
                break;
            case 10: nachbarGebaeude = new Integer[]{11,12,17,18};
                break;
            case 11: nachbarGebaeude = new Integer[]{10,12};
                break;
            case 12: nachbarGebaeude = new Integer[]{1,10,11,13,15};
                break;
            case 13: nachbarGebaeude = new Integer[]{1,3,12,14,15};
                break;
            case 14: nachbarGebaeude = new Integer[]{13,15};
                break;
            case 15: nachbarGebaeude = new Integer[]{12,13,14,16};
                break;
            case 16: nachbarGebaeude = new Integer[]{2,9,15,22,27,33};
                break;
            case 17: nachbarGebaeude = new Integer[]{10,18};
                break;
            case 18: nachbarGebaeude = new Integer[]{10,17,19,20};
                break;
            case 19: nachbarGebaeude = new Integer[]{18,20,21};
                break;
            case 20: nachbarGebaeude = new Integer[]{18,19,21,25,26};
                break;
            case 21: nachbarGebaeude = new Integer[]{19,20,22};
                break;
            case 22: nachbarGebaeude = new Integer[]{2,16,21,27,33};
                break;
            case 23: nachbarGebaeude = new Integer[]{24,27,28};
                break;
            case 24: nachbarGebaeude = new Integer[]{23,25,26,29};
                break;
            case 25: nachbarGebaeude = new Integer[]{20,24,26};
                break;
            case 26: nachbarGebaeude = new Integer[]{20,24,25,29,30};
                break;
            case 27: nachbarGebaeude = new Integer[]{2,16,22,23,28,30};
                break;
            case 28: nachbarGebaeude = new Integer[]{23,27,29};
                break;
            case 29: nachbarGebaeude = new Integer[]{24,26,28,30};
                break;
            case 30: nachbarGebaeude = new Integer[]{26,29};
                break;
            case 31: nachbarGebaeude = new Integer[]{32,33};
                break;
            case 32: nachbarGebaeude = new Integer[]{31,33};
                break;
            case 33: nachbarGebaeude = new Integer[]{2,16,22,27,31,32};
                break;
            default: nachbarGebaeude = new Integer[]{0};
        }
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
        return new boolean[0];
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

    @Override
    public boolean anzahlDerBonuskartenAnpassen(String nameSpieler, Bonuskarte typBonuskarte, Integer anzahlBonuskarten) {
        return false;
    }

    @Override
    public Integer anzahlDerBonuskarten(String nameSpieler, Bonuskarte typBonuskarte) {
        return null;
    }
}
