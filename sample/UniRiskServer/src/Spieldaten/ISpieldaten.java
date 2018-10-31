package Spieldaten;

public interface ISpieldaten {

    /**
     * Diese Methode soll die Nachbargebäude IDs zurückgeben.
     *
     * @param gebaeude
     */
    Integer[] nachbarGebaeude(Integer gebaeude);


    /**
     * Diese Methode soll die Anzahl der Ersties auf den jeweiligen Gebäuden zurückgeben.
     * @param gebaeude
     */
    Integer anzahlErstiesGebaeude(Integer gebaeude);


    /**
     * Diese Methode soll die Anzahl und den Typ der jeweiligen eigenen Karten zurückgeben.
     * @param spieler
     */
    Integer anzahlDerBonuskarten(String spieler, Bonuskarte typ);

    boolean anzahlDerBonuskartenAnpassen(String spieler, Bonuskarte typ, Integer anzahl);



    boolean anzahlErstiesAnpassen(Integer gebaeude, Integer anzahlErsties);

    String besitzerGebaeude(Integer gebaeude);

    boolean besitzerGebaeudeAnpassen(Integer gebaeude, String nameSpieler);


    /**
     * Diese Methode soll die Anzahl der besetzten Gebäude eines Spielers zurückgeben.
     * @param spieler
     */
    Integer anzahlGebaeudeSpieler(String nameSpieler);

    Integer anzahlFachbereicheSpieler(String nameSpieler);

    Missionskarte missionskarteSpieler(String nameSpieler);

    boolean aktuellePhaseSetzen(String phase);


}
