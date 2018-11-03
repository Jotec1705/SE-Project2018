package KommunikationClient;

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
     * Mit dieser Methode kann man die Anzahl der Ersties auf einem Gebäude erhöhen.
     * Nach klicken auf ein Gebäude(label) wird die Anzahl um eins erhöht.
     * @param gebaeude die ID des Gebäudes.
     * @param nameSpieler ist der Name des Spielers.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler);

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
    boolean angriffVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, String gebaeudeZiel, String nameSpieler);

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
    boolean versetzenVonNach(String gebaeudeUrsprung, Integer anzahlUrsprung, String gebaeudeZiel, String nameSpieler);

    /**
     * Diese Methode beendet den Zug und wird durch den Button "Zug beenden" aufgerufen.
     * @param nameSpieler ist der Name des Spielers.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean zugBeendet(String nameSpieler);

    /**
     * Diese Methode wird durch den Button "würfeln" aufgerufen und gibt somit an, das von diesem einen Spieler
     * gewürfelt wurde.
     * @param nameSpieler ist der Name des Spielers.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean gewuerfelt(String nameSpieler);

    /**
     * Diese Methode fügt den Beobachter GUIClient hinzu, um das Observerpattern zu realisieren.
     * Die Rückmeldungen, die dann über diesen "Beobachter Kanal" kommen werden in IGUIClientCallback spezifiziert.
     * @param beobachter ist der Observer, der hinzugefügt wird.
     * @return gibt zurück, ob die Methode erfolgreich war.
     */
    boolean beobachterHinzufuegen(IGUIClientCallback beobachter);
}
