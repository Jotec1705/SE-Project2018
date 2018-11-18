package Spieldaten;

public interface ISpieldaten {

    /**
     * Diese Methode soll die Anzahl der besetzten Gebäude eines Spielers zurückgeben.
     * @param nameSpieler Name des Spielers als String
     * @return Anzahl der besetzten Gebäude als Integer
     */
    Integer anzahlGebaeudeSpieler(String nameSpieler);


    /**
     * Diese Methode soll den Namen des Besitzers eines Gebäudes zurückgeben
     * @param gebaeude ID des Gebäudes
     * @return Name des Besitzers als String
     */
    String besitzerGebaeude(Integer gebaeude);


    /**
     * Die Methode soll die Besitzer der Gebäude nachdem Angreifen und Abwehren anpassen.
     * @param gebaeude ID des Gebäudes als Integer
     * @param nameSpieler Name des Spielers als String
     * @return ob Anpassen der Gebäude erfolgreich war
     */
    boolean besitzerGebaeudeAnpassen(Integer gebaeude, String nameSpieler);


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
     * Die Methode soll die Anzahl der Ersties nachdem Setzen, Angreifen, Abwehren und Verschieben anpassen.
     * @param gebaeude ID des Gebädude als Integer welches angepasst werden soll
     * @param anzahlErsties Anzahl der Ersties als Integer die abgezogen oder addiert werden soll
     * @return ob Anpassen der Ersties auf den Gebäuden erfolgreich war
     */
    boolean anzahlErstiesAnpassen(Integer gebaeude, Integer anzahlErsties);



    /**
     * Diese Methode soll die Anzahl der besetzten Fachbereiche eines Spielers zurückgeben.
     * @param nameSpieler Name des Spielers als String
     * @return Anzahl der Fachbereiche als Integer
     */
    Integer anzahlFachbereicheSpieler(String nameSpieler);


    /**
     * Die Methode soll die Besitzer der Fachbereiche nachdem Angreifen und Abwehren anpassen.
     * @param fachbereich ID des Fachbereiches als Integer
     * @param nameSpieler Name des Spielers als String
     * @return ob Anpassen der Fachbereiche erfolgreich war
     */
    boolean besitzerFachbereichAnpassen(Integer fachbereich, String nameSpieler);


    /**
     * Diese Methode soll die Anzahl der Bonuskarten des jeweiligen Spielers zurückgeben.
     * @param nameSpieler Name des Spielers als String
     * @param typBonuskarte Typ als ... der Bonuskarte die auf Anzahl überprüft werden soll
     * @return Anzahl der Bonuskarten als Integer
     */
    Integer anzahlDerBonuskarten(String nameSpieler, Bonuskarte typBonuskarte);


    /**
     * Die Methode soll die Anzahl der Bonuskarten für den jeweiligen Spieler anpassen.
     * @param nameSpieler Name des Spielers als String
     * @param typBonuskarte Typ als ... der Bonuskarte die Angepasst werden soll
     * @param anzahlBonuskarten Anzahl als Integer auf die die jeweilige Bonuskarte angepasst werden soll
     * @return ob Anpassen der Bonuskarten erfolgreich war
     */
    boolean anzahlDerBonuskartenAnpassen(String nameSpieler, Bonuskarte typBonuskarte, Integer anzahlBonuskarten);


    /**
     * Die Methode soll die Missionskarte des jeweiligen Spielers zurückgeben.
     * @param nameSpieler Name des Spielers als String
     * @return Missionskarte als ENUM
     */
    Missionskarte missionskarteSpieler(String nameSpieler);


    /**
     * Diese Methode soll die aktuelle Phase setzen.
     * @param phase jeweiligen Phasenbeschreibung als String
     * @return ob Setzen der Phase erfolgreich war
     */
    boolean aktuellePhaseSetzen(String phase);


    /**
     * Die Methode soll den nächsten Spieler als durchführenden Spieler setzen
     * @return ob nächster Spieler erfolgreich war
     */
    boolean naechsterSpieler();


    /**
     * Die Methode soll ein Spiel anlegen
     * @param spielerAnzahl Anzahl der Spieler als Integer die Mitspielen sollen
     * @return ob Spielanlegen erfolgreich war
     */
    boolean spielAnlegen(int spielerAnzahl);


    /**
     * Diese Methode meldet einen Spieler an.
     * @param nameSpieler entspricht dem Spielernamen.
     * @param passwort ist das Passwort des Spielers.
     * @return gibt zurück ob das Anmelden erfolgreich war.
     */
    boolean spielerAnmelden(String nameSpieler, String passwort);


    /**
     * Diese Methode soll zurückgeben ob Spieler bereit ist
     * @return true wenn Spieler bereit zum Spiel
     */
    boolean[] spielerBereit();


    /**
     * Die Methode soll den aktuellen Spieler zurückgeben
     * @return gibt aktuellen Spieler als String zurück
     */
    String aktuellerSpieler();


    /**
     * Die Methode soll den aktuellen Spielzustand zurückgeben
     * @return gibt den Spielzustand als Zustand zurück
     */
    Zustand spielZustandHolen();


    /**
     * Die Methode soll den aktuellen Zustand im Spiel setzen
     * @param aktuellerZustand zusetzenden Zustand als Zustand
     * @return ob Setzen des Zustandes erfolgreich war
     */
    boolean spielZustandSetzen(Zustand aktuellerZustand);

}
