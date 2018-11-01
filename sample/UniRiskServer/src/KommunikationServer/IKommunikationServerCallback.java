package KommunikationServer;


public interface IKommunikationServerCallback {

    /**
     * Diese Methode soll ein Spielende durch den Host an die Clients weiterleiten. Wird sie von der Spiellogik
     * aufgerufen, hat der Host das Spiel beendet.
     * @return True
     */
    boolean spielBeendet();

    /**
     * Diese Methode wird von der Spiellogik aufgerufen, um an alle Clients zu melden wer jetzt am Zug ist.
     * @param nameSpieler Name des Spielers, welcher jetzt dran sein soll
     * @return ob Aktion erfolgreich.
     */
    boolean zugZuteilung(String nameSpieler);

    /**
     * Diese Methode wird aufgerufen, sobald ein Spieler ein bestimmtes Gebäude angreifen möchte.
     * Sie dient der Aufforderung des angegriffenen Clients zur Verteidigung.
     * @param nameSpieler Name des verteidigenden Spielers
     * @param verteidigerGeb Gebäude welches verteidigt werden muss
     * @return ob Aktion erfolgreich
     */
    boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb);


    /**
     * Diese Methode wird genutzt, um bei allen Clients die Karte zu aktualisieren.
     * @return ob Aktion erfolgreich.
     */
    boolean aktualisierenKarte();


    /**
     * Diese Methode wird genutzt, um bei allen Clients die Lobby zu aktualisieren.
     * @return ob Aktion erfolgreich.
     */
    boolean aktualisierenLobby();

    /**
     * Über diese Methode wird dem würfelnden Spieler (also Angreifer und Verteidiger) das Ergebnis seines Würfel-
     * vorgangs mitgeteilt.
     * @param nameSpieler Name des Spielers den das Ergebnis betrifft.
     * @param wuerfelVerteidiger Augenzahl(-en) der Würfel des Verteidigers.
     * @param wuerfelAngreifer Augenzahl(-en) der Würfel des Angreifers.
     * @param verloreneErsties Anzahl der Ersties, welche der Verliere einbüßt.
     * @param gewonnen Zeigt an, ob man den Würfelvorgang gewonnen hat, oder nicht
     * @return ob Aktion erfolgreich war.
     */
    boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer,
                            Integer verloreneErsties, Integer gewonnen);

}
