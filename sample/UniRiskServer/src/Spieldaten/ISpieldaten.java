package Spieldaten;

public interface ISpieldaten {

    /**
     * Diese Methode soll den Namen des Besitzers eines Gebäudes zurückgeben
     * @param gebaeude ID des Gebäudes
     * @return Name des Besitzers als String
     */
    String besitzerGebaeude(Integer gebaeude);

    /**
     * Diese Methode soll die Anzahl der besetzten Gebäude eines Spielers zurückgeben.
     * @param nameSpieler Name des Spielers als String
     * @return Anzahl der besetzten Gebäude als Integer
     */
    Integer anzahlGebaeudeSpieler(String nameSpieler);


    /**
     * Diese Methode soll die Nachbargebäude eines Gebäudes zurückgeben.
     * @param gebaeude ID als Integer des Gebäudes das überprüft werden soll
     * @return Nachbargebäude IDs als Integer Array
     */
    Integer[] nachbarGebaeude(Integer gebaeude);


    /**
     * Diese Methode soll die Anzahl der Ersties auf den jeweiligen Gebäuden zurückgeben.
     * @param gebaeude ID als Integer des Gebäudes das überprüft werden soll
     * @return Anzahl der Ersties auf dem Gebäude als Integer
     */
    Integer anzahlErstiesGebaeude(Integer gebaeude);

    /**
     * Diese Methode soll die Anzahl der besetzten Fachbereiche eines Spielers zurückgeben.
     * @param nameSpieler Name des Spielers als String
     * @return Anzahl der Fachbereiche als Integer
     */
    Integer anzahlFachbereicheSpieler(String nameSpieler);


    /**
     * Diese Methode soll die Anzahl der Bonuskarten des jeweiligen Spielers zurückgeben.
     * @param nameSpieler Name des Spielers als String
     * @param typBonuskarte Typ als ... der Bonuskarte die auf Anzahl überprüft werden soll
     * @return Anzahl der Bonuskarten als Integer
     */
    Integer anzahlDerBonuskarten(String nameSpieler, Bonuskarte typBonuskarte);


    /**
     * Die Methode soll die Missionskarte des jeweiligen Spielers zurückgeben.
     * @param nameSpieler Name des Spielers als String
     * @return Missionskarte als ENUM
     */
    Missionskarte missionskarteSpieler(String nameSpieler);


    /**
     * Die Methode soll die Anzahl der Ersties nachdem Setzen, Angreifen, Abwehren und Verschieben anpassen.
     * @param gebaeude ID des Gebädude als Integer welches angepasst werden soll
     * @param anzahlErsties Anzahl der Ersties als Integer die abgezogen oder addiert werden soll
     * @return ob Anpassen der Ersties auf den Gebäuden erfolgreich war
     */
    boolean anzahlErstiesAnpassen(Integer gebaeude, Integer anzahlErsties);


    /**
     * Die Methode soll die Besitzer der Gebäude nachdem Angreifen und Abwehren anpassen.
     * @param gebaeude ID des Gebäudes als Integer
     * @param nameSpieler Name des Spielers als String
     * @return ob Anpassen der Gebäude erfolgreich war
     */
    boolean besitzerGebaeudeAnpassen(Integer gebaeude, String nameSpieler);


    /**
     * Die Methode soll die Anzahl der Bonuskarten für den jeweiligen Spieler anpassen.
     * @param nameSpieler Name des Spielers als String
     * @param typBonuskarte Typ als ... der Bonuskarte die Angepasst werden soll
     * @param anzahlBonuskarten Anzahl als Integer auf die die jeweilige Bonuskarte angepasst werden soll
     * @return ob Anpassen der Bonuskarten erfolgreich war
     */
    boolean anzahlDerBonuskartenAnpassen(String nameSpieler, Bonuskarte typBonuskarte, Integer anzahlBonuskarten);


    /**
     * Die Methode soll die Besitzer der Fachbereiche nachdem Angreifen und Abwehren anpassen.
     * @param fachbereich ID des Fachbereiches als Integer
     * @param nameSpieler Name des Spielers als String
     * @return ob Anpassen der Fachbereiche erfolgreich war
     */
    boolean besitzerFachbereichAnpassen(Integer fachbereich, String nameSpieler);


    /**
     * Diese Methode soll die aktuelle Phase setzen.
     * @param phase jeweiligen Phasenbeschreibung als String
     * @return ob Setzen der Phase erfolgreich war
     */
    boolean aktuellePhaseSetzen(String phase);

}
