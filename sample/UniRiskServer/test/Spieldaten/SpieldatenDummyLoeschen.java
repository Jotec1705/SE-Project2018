package Spieldaten;

public class SpieldatenDummyLoeschen implements IAnzeigedaten{
    public String Testwert = "Test12345";

    @Override
    public Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        Integer[] wert = {1,2};
        return wert;
    }

    @Override
    public Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        Integer[] wert = {1,2};
        return wert;
    }

    @Override
    public String[] spielerNamen() {
        String[] wertStrArr = {"testA","TestB"};
        return wertStrArr;
    }

    @Override
    public boolean[] spielerBereit() {
        boolean[] wert = {true};
        return wert;
    }

    @Override
    public String[] ipAdressen() {
        String[] wertStrArr = {"testA","TestB"};
        return wertStrArr;    }

    @Override
    public Integer[] anzahlErstiesAufGebaeude() {
        Integer[] wert = {1,2};
        return wert;
    }

    @Override
    public Integer[] anzahlBonuskarten(String nameSpieler) {
        Integer[] wert = {1,2};
        return wert;
    }

    @Override
    public Integer[] farbeSpieler() {

        Integer[] wert = {1,2};
        return wert;
    }

    @Override
    public Integer anzahlZuVerteilendeErsties(String nameSpieler) {
        Integer wert = 1;
        return wert;
    }

    @Override
    public String missionskarteInhalt(String nameSpieler) {
        String wert = "Test";
        return wert;
    }

    @Override
    public String aktuellePhase() {
        String wert = "Test";
        return wert;
    }

    @Override
    public Integer[] eigeneGebaeude(String nameSpieler) {

        Integer[] wert = {1,2};
        return wert;
    }
}
