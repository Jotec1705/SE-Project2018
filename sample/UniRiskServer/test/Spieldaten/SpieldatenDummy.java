package Spieldaten;

public class SpieldatenDummy implements IAnzeigedaten{
    public String Testwert = "Test12345";

    @Override
    public Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        Integer[] wert = {1,2};
        return wert;
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
        boolean[] wert = {true};
        return wert;
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
        return new Integer[0];
    }
}
