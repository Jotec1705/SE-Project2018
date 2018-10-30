package KommunikationServer;

import java.util.Map;

public interface IKommunikationServerCallback {

    /**
     * Diese Methode soll von der Spiellogik aufgerufen und der return Wert an den Client weiter gegeben werden,
     * sobald eine Prüfung der Clienteingabe als nicht erlaubt klassifiziert wurde.
     * @return True
     */
    boolean UnerlaubteAktion();

    /**
     * Diese Methode soll ein Spielende durch den Host an die Clients weiterleiten. Wird sie von der Spiellogik
     * aufgerufen, hat der Host das Spiel beendet.
     * @return True
     */
    boolean SpielBeendet();

    /**
     * Diese Methode wird von der Spiellogik aufgerufen, um an alle Clients zu melden wer jetzt am Zug ist.
     * @param name Name des Spielers, welcher jetzt dran sein soll
     * @return Den Namen.
     */
    String ZugZuteilung(String name);

    /**
     * Diese Methode bekommt die Hashmap mit allen Gebäuden und der derzeitigen Anzahl von Einheiten auf dem
     * jeweiligen Gebäude übergeben, und gibt diese an alle Clients weiter. Somit bekommen die Clients die aktuelle
     * Karteninformation. Wird zum Beispiel nach jedem Zug aufgerufen.
     * @param alleEinhAufAllenGeb Hashmap mit allen Gebäuden
     * @return Hashmap mit allen Gebäuden. key = Gebäude, value = Anzahl
     */
    Map<String, Integer> SpielStatus(Map<String, Integer> alleEinhAufAllenGeb);

    /**
     * Diese Funktion wird aufgerufen, sobald ein Spieler ein bestimmtes Gebäude angreifen möchte.
     * Sie dient der Aufforderung des angegriffenen Clients zur Verteidigung.
     * @param name Name des verteidigenden Spielers
     * @param verteidigerGeb Gebäude welches verteidigt werden muss
     * @return Hashmap: key = Name des Spielers, value = Name des Gebäudes welches verteidigt werden muss
     */
    Map<String, String> AngriffAbwehren(String name, String verteidigerGeb);

}
