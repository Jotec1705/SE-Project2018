package Spieldaten;

public interface ISpieldaten {

    /**
     * Diese Methode soll die Nachbargebäude zurückgeben.
     *
     * @param gebaeude
     */
    void Nachbargebaeude(String gebaeude);


    /**
     * Diese Methode soll die Anzahl der Ersties auf den jeweiligen Gebäuden zurückgeben.
     * @param gebaeude
     */
    void AnzahlErstiesGebaeude(String gebaeude);


    /**
     * Diese Methode soll die Anzahl und den Typ der jeweiligen eigenen Karten zurückgeben.
     * @param spieler
     */
    void TypderEigenenKarten(String spieler);


    /**
     * Diese Methode soll die Anzahl der besetzten Gebäude eines Spielers zurückgeben.
     * @param spieler
     */
    void AnzahlLaenderSpieler(String spieler);


}
