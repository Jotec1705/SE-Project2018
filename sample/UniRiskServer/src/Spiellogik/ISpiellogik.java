package Spiellogik;

import java.util.Map;
import java.util.Observer;

public interface ISpiellogik {


    /**
     * Aus dieser Methode können die Anmeldedaten der Spieler ausgelesen werden.
     * @param name entspricht dem Spielernamen.
     * @param passwort ist das Passwort des Spielers.
     */
    void AnmeldeDaten(String name, String passwort);

    /**
     * Diese Methode meldet der Spiellogik, dass sich ein Spieler bereit gemeldet hat.
     * @param name ist der name des Spielers, welcher Bereit geklickt hat.
     * @return gibt True zurück.
     */
    boolean Bereit(String name);

    /**
     * Diese Methode erstellt eine Hashmap mit dem Gebäude als key und der Anzahl der Ersties als value.
     * Mit dieser Methode kann also der Anwendungsfall Ersties verteilen, und Phase I abgedeckt werden.
     * @param gebaeude Name des Gebäudes, auf welchem die Anzahl erhöht wurde.
     * @param anzahl Anzahl der Ersties nach Erhöhung.
     * @return mapGebaeudeMitAnzahl ist eine Hashmap mit beschriebenen Eigenschaften
     */
    Map<String, Integer> AnzahlAnpassen(String gebaeude, Integer anzahl);

    /**
     * Aus dieser Methode, kann ausgelesen werden von wo und mit wie vielen Einheiten, auf welches Gebäude angegriffen
     * wird. Genauso kann diese Methode auch verwendet werden, um anzuzeigen von wo wie viele Einheiten wohin versetzt
     * werden sollen. Deckt also Phase II und Phase III ab.
     * @param gebaeudeUrsprung Von wo.
     * @param anzahlUrsprung Mit wievielen.
     * @param gebaeudeZiel Auf welches Gebäude.
     */
    void AngriffVersetzenVonNach (String gebaeudeUrsprung, Integer anzahlUrsprung, String gebaeudeZiel);

    /**
     * Diese Methode meldet an die Spiellogik, dass der aktuelle Spieler (der momentan am Zug ist)
     * seinen Zug beendet hat.
     * @return Gibt True zurück.
     */
    boolean ZugBeendet();


    /**
     * Diese Methode fügt den Beobachter KommunikationSever hinzu, um das Observerpattern zu realisieren.
     * Die Rückmeldungen die dann über diesen "Beobachter Kanal" kommen werden in der Schnittstelle
     * IKommunikationServerCallback spezifiziert.
     * @param KommunikationServer Ist der Observer, der hinzugefügt  wird.
     */
    void addObserver(Observer KommunikationServer);





}
