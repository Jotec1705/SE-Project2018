package KommunikationServer;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISpiellogikAnzeigedatenRMI extends Remote {

    //######################################################ISPIELLOGIK#########################################################

    /**
     * Diese Methode meldet einen Spieler an.
     * @param nameSpieler entspricht dem Spielernamen.
     * @param passwort ist das Passwort des Spielers.
     * @return gibt zurück ob das Anmelden erfolgreich war.
     */
    boolean spielerAnmelden(String nameSpieler, String passwort) throws RemoteException;

    /**
     * Gibt an die Spiellogik weiter, dass ein Spieler auf den Button Aussteigen am GUIClient gedrückt hat
     * und somit aus dem Spiel ausgestiegen ist.
     * @param nameSpieler ist der name des Spielers.
     * @return ob Aktion erfolgreich
     */
    boolean spielerAusgestiegen(String nameSpieler) throws RemoteException;

    /**
     * Diese Methode meldet der Spiellogik, dass sich ein Spieler bereit gemeldet hat.
     * @param nameSpieler ist der name des Spielers, welcher Bereit geklickt hat.
     * @return gibt True zurück.
     */
    boolean spielerBereitMelden(String nameSpieler) throws RemoteException;

    /**
     * Diese Methode erhöht die Anzahl der ersties.
     * Mit dieser Methode kann also der Anwendungsfall Ersties verteilen, und Phase I abgedeckt werden.
     * @param gebaeude ID des Gebäudes, auf welchem die Anzahl erhöht wurde.
     * @param nameSpieler name des ausführenden Spielers
     * @return ob Aktion erfolgreich war.
     */
    boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler) throws RemoteException;

    /**
     * Aus dieser Methode, kann ausgelesen werden von wo und mit wie vielen Einheiten, auf welches Gebäude angegriffen
     * wird. Deckt also Phase II ab.
     * @param gebaeudeUrsprung Von wo.
     * @param anzahlUrsprung Mit wievielen.
     * @param gebaeudeZiel Auf welches Gebäude.
     * @param nameSpieler name des ausführenden Spielers
     * @return ob Aktion erfolgreich war
     */
    boolean angriffVonNach (Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) throws RemoteException;


    /**
     * Aus dieser Methode, kann ausgelesen werden von wo und mit wie vielen Einheiten, auf welches Gebäude versetzt
     * wird. Deckt also Phase III ab.
     * @param gebaeudeUrsprung Von wo.
     * @param anzahlUrsprung Mit wievielen.
     * @param gebaeudeZiel Auf welches Gebäude.
     * @param nameSpieler name des ausführenden Spielers
     * @return ob Aktion erfolgreich war
     */
    boolean versetzenVonNach (Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) throws RemoteException;


    /**
     * Diese Methode meldet an die Spiellogik, dass der aktuelle Spieler (der momentan am Zug ist)
     * seinen Zug beendet hat.
     * @param nameSpieler name des ausführenden Spielers
     * @return Gibt True zurück.
     */
    boolean zugBeendet(String nameSpieler) throws RemoteException;

    /**
     * Diese Methode meldet an die Spiellogik, dass der aktuelle Spieler (Angreifer oder Verteidiger)
     * gewürfelt hat.
     * @param nameSpieler name des ausführenden Spielers
     * @return Gibt True zurück.
     */
    boolean gewuerfelt(String nameSpieler) throws RemoteException;


    /**
     * Diese Methode fügt den Beobachter KommunikationSever hinzu, um das Observerpattern zu realisieren.
     * Die Rückmeldungen die dann über diesen "Beobachter Kanal" kommen werden in der Schnittstelle
     * IKommunikationServerCallback spezifiziert.
     * @param beobachter Ist der Observer, der hinzugefügt  wird.
     * @return gibt zurück ob erfolgreich.
     */
    boolean beobachterHinzufuegen(IKommunikationServerCallback beobachter) throws RemoteException;

    //###############################IANZEIGEDATEN######################################################################

    /**
     * Diese Methode soll die ID´s der angreifbaren Gebäude eines Spieler zurückgeben
     * @param gebaeude ID des Gebäudes
     * @param nameSpieler Name des Spielers als String
     * @return gibt ein Array mit den GebäudeIDs der angreifbaren Nachbargebäude zurück
     */
    Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) throws RemoteException;

    /**
     * Diese Methode soll die ID´s eigenen Nachbargebäude eines Spieler zurückgeben
     * @param gebaeude ID des Gebäudes
     * @param nameSpieler Name des Spielers als String
     * @return gibt ein Array mit den GebäudeIDs der Nachbargebäude zurück welche dem nameSpieler gehören
     */
    Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler) throws RemoteException;

    /**
     * Diese Methode soll die Namen aller Spieler zurückgeben
     * @return Array mit dem Namen aller Spieler als String
     */
    String[] spielerNamen() throws RemoteException;

    /**
     * Diese Methode soll zurückgeben ob Spieler bereit ist
     * @return true wenn Spieler bereit zum Spiel
     */
    boolean[] spielerBereit() throws RemoteException;

    /**
     * Diese Methode soll die IP-Adressen der Spieler zurückgeben
     * @return Array mit IP-Adressen der Spieler
     */
    String[] ipAdressen() throws RemoteException;

    /**
     * Diese Methode soll die Anzahl der Ersties auf einem Gebäude zurückgeben
     * @return Int-Array mit Anzahl der Ersties pro Gebäude ( Index entspricht Gebäude ID)
     */
    Integer[] anzahlErstiesAufGebaeude() throws RemoteException;

    /**
     * Diese Methode soll die Anzahl der Bonuskarten eines Spieler zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @return Int-Array mit Anzahl der Bonuskarten
     */
    Integer[] anzahlBonuskarten(String nameSpieler) throws RemoteException;

    /**
     * Diese Methode soll die Farben aller Spieler als Int-Wert zurückgeben
     * @return Array mit Farben der Spieler als Int-Wert. Array Index entspricht der Gebäude ID
     */
    Integer[] farbeSpieler() throws RemoteException;

    /**
     * Diese Methode soll die Anzahl der noch zu verteilenden Ersties eines Spielers zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @return Anzahl der zu verteilenden Ersties als Int
     */
    Integer anzahlZuVerteilendeErsties(String nameSpieler) throws RemoteException;

    /**
     * Diese Methode soll den Inhalt einer Missionskarte des Spielers zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @return Inhalt der Missionskarte als String
     */
    String missionskarteInhalt(String nameSpieler) throws RemoteException;

    /**
     * Diese Methode soll die aktuelle Phase zurückgeben
     * @return Aktuelle Phase als String
     */
    String aktuellePhase() throws RemoteException;

    /**
     * Diese Methode gibt ein Array zurück mit den IDs der Gebäude, welche dem übergebenene Spieler gehören
     * @param nameSpieler Name des Spielers als String
     * @return Int-Array
     */
    Integer[] eigeneGebaeude(String nameSpieler) throws RemoteException;
}
