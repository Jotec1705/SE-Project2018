package GUIServer;

public interface IGUIServerCallback {

    /**
     * Diese Methode wird von der Komponente "Spiellogik" aufgerufen, wenn relevante Spieldaten verändert wurden.
     * Bei Aufruf holt sich die Komponente "GUIServer" die aktuellen Spieldaten und aktualisiert die Anzeige.
     */
    void update();
}
