package Spiellogik;

public interface ISpielkontrolle {
    /**
     * Diese Methode wird der Komponente "GUIServer" angeboten.
     * Über den Aufruf dieser Methode wird über die Komponente "Spiellogik" die Komponente "Spieldaten"
     * zum Anlegen eines neuen Spieles aufgefordert.
     * Es wird der Methode die gewünschte Spieleranzahl für das anzulegende Spiel übergeben.
     * @param spielerAnzahl
     * @return Gibt True zurück wenn Spiel von "Spieldaten" erfolgreich angelegt. Sonnst False.
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
     * Diese Methode wird der Komponente "GUIServer" angeboten.
     * Über den Aufruf dieser Methode wird das angelegte oder geladene Spiel gestartet.
     */
    void spielStarten();

    /**
     * Diese Methode wird der Komponente "GUIServer" angeboten.
     * Über den Aufruf dieser Methode wird nach einer Abfrage, ob das Spiel gespeichert werden soll, das aktuelle Spiel
     * beendet.
     */
    void spielBeenden();

    /**
     * Diese Methode wird der Komponente "GUIServer" angeboten.
     * Nach dem Aufruf der Methode "spielBeenden" wird abgefragt ob gespeichert werden soll. Beim bestätigen des Dialoges
     * wird diese Methode aufgerufen und das aktuelle Spiel gespeichert.
     * Der Methode wird der Dateipfad unter dem die Datei gespeichert werden soll übergeben.
     * @param dateipfad
     * @return
     */
    boolean spielSpeichern(String dateipfad);
}
