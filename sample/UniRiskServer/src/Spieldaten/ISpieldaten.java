package Spieldaten;

public interface ISpieldaten {

    /**
     * Diese Methode soll die Anzahl der besetzten Gebäude eines Spielers zurückgeben.
     * @param nameSpieler Name des Spielers als String
     * @return Anzahl der besetzten Gebäude als Integer
     */
    Integer anzahlGebaeudeSpieler(String nameSpieler);


    /**
     * Diese Methode gibt ein Array zurück mit den IDs der Gebäude, welche dem übergebenene Spieler gehören
     * @param nameSpieler Name des Spielers als String
     * @return Int-Array
     */
    Integer[] eigeneGebaeude(String nameSpieler);
//Doppelt

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
     * Diese Methode soll die ID´s eigenen Nachbargebäude eines Spieler zurückgeben
     * @param gebaeude ID des Gebäudes
     * @param nameSpieler Name des Spielers als String
     * @return gibt ein Array mit den GebäudeIDs der Nachbargebäude zurück welche dem nameSpieler gehören
     */
    Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler);


    /**
     * Diese Methode soll die ID´s der angreifbaren Gebäude eines Spieler zurückgeben
     * @param gebaeude ID des Gebäudes
     * @param nameSpieler Name des Spielers als String
     * @return gibt ein Array mit den GebäudeIDs der angreifbaren Nachbargebäude zurück
     */
    Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler);


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
     * Diese Methode soll die Anzahl der Ersties auf einem Gebäude zurückgeben
     * @return Int-Array mit Anzahl der Ersties pro Gebäude ( Index entspricht Gebäude ID)
     */
    Integer[] anzahlErstiesAufGebaeude();
//Macht die überhaupt Sinn


    /**
     * Diese Methode soll die Anzahl der noch zu verteilenden Ersties eines Spielers zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @return Anzahl der zu verteilenden Ersties als Int
     */
    Integer anzahlZuVerteilendeErsties(String nameSpieler);


    /**
     * Diese Methode soll die Anzahl der noch zu verteilenden Ersties eines Spielers anpassen
     * @param nameSpieler Name des Spielers als String
     * @param anzahlErsties Anzahl der Ersties die noch zu verteilen sind
     * @return ob die Methode erfolgreich war
     */
    boolean anzahlZuVerteilendeErstiesAnpassen(String nameSpieler, Integer anzahlErsties);


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
     * Diese Methode soll die Anzahl der Bonuskarten eines Spieler zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @return Int-Array mit Anzahl der Bonuskarten
     */
    Integer[] anzahlBonuskarten(String nameSpieler);
//Doppelt

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
     * Diese Methode soll die aktuelle Phase zurückgeben
     * @return Aktuelle Phase als String
     */
    String aktuellePhase();


    /**
     * Diese Methode soll die aktuelle Phase setzen.
     * @param phase jeweiligen Phasenbeschreibung als String
     * @return ob Setzen der Phase erfolgreich war
     */
    boolean aktuellePhaseSetzen(String phase);


    /**
     * Die Methode soll ein Spiel anlegen
     * @param spielerAnzahl Anzahl der Spieler als Integer die Mitspielen sollen
     * @return ob Spielanlegen erfolgreich war
     */
    boolean spielAnlegen(int spielerAnzahl);

    /**
     * Diese Methode wird der Komponente "GUIServer" angeboten.
     * Über den Aufruf dieser Methode wird über die Komponente "Spiellogik" die Komponente "Spieldaten"
     * zum Laden eines Spieles aus einer Datei aufgefordert.
     * Es wird der Methode der Pfad der zuladenen Datei übergeben.
     * @param dateipfad
     * @return Gibt True zurück wenn Spiel von "Spieldaten" erfolgreich geladen. Sonnst False.
     */
    boolean spielLaden(String dateipfad);

    /**
     * Gebäude den Spielern zuweisen, Initial Ersties berechnen.
     * Diese Methode wird der Komponente "GUIServer" angeboten.
     * Über den Aufruf dieser Methode wird das angelegte oder geladene Spiel gestartet.
     */
    boolean spielStarten();

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
     * Gibt an die Spiellogik weiter, dass ein Spieler auf den Button Aussteigen am GUIClient gedrückt hat
     * und somit aus dem Spiel ausgestiegen ist.
     * @param nameSpieler ist der name des Spielers.
     * @return ob Aktion erfolgreich
     */
    boolean spielerAusgestiegen(String nameSpieler);

    /**
     * Diese Methode soll die Namen aller Spieler zurückgeben
     * @return Array mit dem Namen aller Spieler als String
     */
    String[] spielerNamen();


    /**
     * Die Methode soll den aktuellen Spieler zurückgeben
     * @return gibt aktuellen Spieler als String zurück
     */
    String aktuellerSpieler();


    /**
     * Die Methode soll den nächsten Spieler als durchführenden Spieler setzen
     * @return ob nächster Spieler erfolgreich war
     */
    boolean naechsterSpieler();


    /**
     * Diese Methode soll die Farben aller Spieler als Int-Wert zurückgeben
     * @return Array mit Farben der Spieler als Int-Wert. Array Index entspricht der Gebäude ID
     */
    Integer[] farbeSpieler();


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

    /**
     * Diese Methode meldet der Spiellogik, dass sich ein Spieler bereit gemeldet hat.
     * @param nameSpieler ist der name des Spielers
     * @return gibt True zurück.
     */
    boolean spielerBereitMelden(String nameSpieler);

}
