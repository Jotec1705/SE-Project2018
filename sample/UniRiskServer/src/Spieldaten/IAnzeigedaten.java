package Spieldaten;

public interface IAnzeigedaten {

    Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler);

    Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler);

    String[] spielerNamen();

    boolean[] spielerBereit();

    String[] ipAdressen();

    Integer[] anzahlErstiesAufGebaeude();

    Integer[] anzahlBonuskarten(String nameSpieler);

    Integer[] farbeSpieler();

    Integer anzahlZuVerteilendeErsties(String nameSpieler);

    String missionskarteInhalt(String nameSpieler);

    String aktuellePhase();




}
