package GUIClient;

public interface IGUIClientCallback {

    /**
     * Diese Methode wird aufgerufen, wenn die Lobby verändert wurde.
     * Beim Aufruf der Methode holt sich die Komponente "GUIClient" die aktuellen Daten der Lobby
     * und aktualisiert die Anzeige.
     * @return zeigt, ob die Aktualisierung erfolgreich war.
     */
    boolean aktualisierenLobby();

    /**
     * Diese Methode wird aufgerufen, wenn die Karte verändert wurde
     * und der Client dies angezeigt bekommen sollte.
     * Beim Aufruf holt sich die Komponente "GUIClient" die aktuellen Daten der Karte und
     * aktualisiert diese Anzeige.
     * @return zeigt, ob die Aktualisierung erfolgreich war.
     */
    boolean aktualisierenKarte();

    /**
     * Diese Methode wird aufgerufen, wenn ein Spieler seinen Zug beendet hat. Dann wird der nächste Spieler ausgewählt.
     * @param nameSpieler entspricht dem Namen des Spielers.
     * @return zeigt, ob die Methode erfolgreich ausgeführt wurde.
     */
    boolean zugZuteilung(String nameSpieler);

    /**
     * Diese Methode wird aufgerufen, wenn ein Spieler angegriffen wird und sich verteidigen muss.
     * Danach wird die Methode wuefeln aufgerufen.
     * @param nameSpieler entspricht dem Namen des Spielers.
     * @param verteidigerGeb entspricht der ID des angegriffenen Gebäudes des Verteidigers.
     * @return zeigt, ob die Methode erfolgreich ausgeführt wurde.
     */
    boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb);

    /**
     * Über diese Methode wird dem würfelnden Spieler (also Angreifer und Verteidiger) das Ergebnis seines Würfel-
     * vorgangs mitgeteilt.
     * @param nameSpieler Name des Spielers den das Ergebnis betrifft.
     * @param wuerfelVerteidiger Augenzahl(-en) der Würfel des Verteidigers.
     * @param wuerfelAngreifer Augenzahl(-en) der Würfel des Angreifers.
     * @param verloreneErsties Anzahl der Ersties, welche die der Betroffene Spieler einbüßt.
     * @param gewonnen Zeigt an, ob man den Würfelvorgang gewonnen hat, oder nicht
     * @return ob Aktion erfolgreich war.
     */
    boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer,
                            Integer verloreneErsties, Integer gewonnen);

    /**
     * Diese Methode beendet das Spiel und schließt die Karte sowie die Lobby beim Client.
     * @return zeigt, ob das Spiel erfolgreich beendet wurde.
     */
    boolean spielBeendet();
}
