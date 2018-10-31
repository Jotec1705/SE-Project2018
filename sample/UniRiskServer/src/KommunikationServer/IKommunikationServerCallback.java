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
     * Diese Funktion wird aufgerufen, sobald ein Spieler ein bestimmtes Gebäude angreifen möchte.
     * Sie dient der Aufforderung des angegriffenen Clients zur Verteidigung.
     * @param nameSpieler Name des verteidigenden Spielers
     * @param verteidigerGeb Gebäude welches verteidigt werden muss
     * @return ob Aktion erfolgreich
     */
    boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb);

    boolean aktualisierenKarte();

    boolean aktualisierenLobby();


    boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen);

}
