package KommunikationClient;

import GUIClient.GUIClient;
import GUIClient.IGUIClientCallback;

public interface IClientKommunikation {

    /**
     * Mit dieser Methode kann man sich anmelden. Man gibt einen Namen und ein Passwort ein.
     * @param nameSpieler ist der Name des Spielers.
     * @param passwort ist das Passwort dieses Spielers.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean spielerAnmelden(String nameSpieler, String passwort);

    /**
     * Mit dieser Methode kann ein Spieler aus dem Spiel aussteigen.
     * Sie liefert "true" zurück, nachdem der Button "Aussteigen" in der Lobby betätigt wurde.
     * @param nameSpieler ist der Name des Spielers.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean spielerAusgestiegen(String nameSpieler);

    /**
     * Mit dieser Methode kann sich ein Spieler bereit melden für ein Spiel.
     * Sie liefert "true" zurück, nachdem der Button "bereit" in der Lobby betätogt wurde.
     * @param nameSpieler ist der Name des Spielers.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean spielerBereitMelden(String nameSpieler);

    /**
     * Diese Methode soll die aktuelle Phase zurückgeben.
     * @return gibt Informationen über die aktuelle Phase zurück.
     */
    String aktuellePhase();

    /**
     * Mit dieser Methode kann man die Anzahl der Ersties auf einem Gebäude erhöhen.
     * Nach klicken auf ein Gebäude(label) wird die Anzahl um eins erhöht.
     * @param gebaeude die ID des Gebäudes.
     * @param nameSpieler ist der Name des Spielers.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler);

    /**
     * Diese Methode soll die Anzahl der Bonuskarten eines Spieler zurückgeben.
     * @param nameSpieler Name des Spielers als String.
     * @return gibt die Anzahlen der drei Bonuskarten zurück.Index 0 entspricht Wert Ersties, 1 Studenten, 2 Prof
     */
    Integer[] anzahlBonuskarten(String nameSpieler);

    /**
     * Diese Methoden gibt die ausgewählten Bonuskarten zum Tauschen weiter.
     * @param nameSpieler aktueller Spieler
     * @param bonuskarten ausgewählte Bonuskarten zum Tauschen
     * @return ob die Methode erfolgreich war
     */
    boolean tauschBonuskarten(String nameSpieler, Integer[] bonuskarten);

    /**
     * Diese Methode soll die Anzahl der noch zu verteilenden Ersties eines Spielers zurückgeben.
     * @param nameSpieler Name des Spielers als String.
     * @return Anzahl der zu verteilenden Ersties als Int.
     */
    Integer anzahlZuVerteilendeErsties(String nameSpieler);

    /**
     * Diese Methode soll die Anzahl der Ersties auf einem Gebäude zurückgeben.
     * @return gibt die Anzahl aller Ersties auf jedem Gebäude zurück.
     */
    Integer[] anzahlErstiesAufGebaeude();

    /**
     * Mit dieser Methode kann man einen Angriff starten.
     * Sie wird durch klicken des Buttons "Angreifen" aufgerufen und dann kann man Angeben von welchem eigenen Gebäude
     * man mit wie vielen Ersties welches gegnerische Gebäude angreifen will.
     * @param gebaeudeUrsprung die ID des eigenen Gebäudes, mit dem man angreifen möchte.
     * @param anzahlUrsprung Anzahl der Ersties, mit denen man angreifen will.
     * @param gebaeudeZiel die ID des gegnerischen Gebäudes, was man angreifen will.
     * @param nameSpieler ist der Name des Spielers.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean angriffVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler);

    /**
     * Durch diese Methode erhält man alle GebäudeIDs des aktuellen Spielers.
     * @param nameSpieler Name des aktuellen Spielers.
     * @return ein Array vom Typ Integer mit allen IDs der Gebäude die dem Spieler gehören.
     */
    Integer[] eigeneGebaeude(String nameSpieler);

    /**
     * Diese Methode soll die ID´s der angreifbaren Gebäude eines Spieler zurückgeben
     * @param gebaeude ID des Gebäudes
     * @param nameSpieler Name des Spielers als String
     * @return gibt ein Array mit den GebäudeIDs der angreifbaren Nachbargebäude zurück
     */
    Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler);

    /**
     * Diese Methode wird durch den Button "würfeln" aufgerufen und gibt somit an, das von diesem einen Spieler
     * gewürfelt wurde.
     * @param nameSpieler ist der Name des Spielers (Angreifer oder Verteidiger kann das sein).
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean gewuerfelt(String nameSpieler);

    /**
     * Mit dieser Methode kann man Ersties verschieben.
     * Sie wird durch klicken des Buttons "Verschieben" aufgerufen und dann kann man Angeben von wo nach wo man wie
     * viele Ersties verschieben will.
     * @param gebaeudeUrsprung die ID des Gebäudes, von dem man Ersties wegverschieben will.
     * @param anzahlUrsprung die Anzahl der Ersties, die man verschieben will.
     * @param gebaeudeZiel die ID des Gebäudes, welches verstärkt werden soll.
     * @param nameSpieler ist der Name des Spielers.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean versetzenVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler);

    /**
     * Diese Methode soll die ID´s eigenen Nachbargebäude eines Spieler zurückgeben
     * @param gebaeude ID des Gebäudes
     * @param nameSpieler Name des Spielers als String
     * @return gibt ein Array mit den GebäudeIDs der Nachbargebäude zurück welche dem nameSpieler gehören
     */
    Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler);

    /**
     * Diese Methode beendet den Zug und wird durch den Button "Zug beenden" aufgerufen.
     * @param nameSpieler ist der Name des Spielers.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean zugBeendet(String nameSpieler);

    boolean beobachterHinzufuegen(IGUIClientCallback beobachter);

    /**
     * Diese Methode soll die Farben aller Spieler als Int-Wert zurückgeben
     * @return Array mit Farben der Spieler als Int-Wert. Array Index entspricht der Gebäude ID
     */
    Integer[] farbeSpieler();
}
