package Spiellogik;

/*sorgt dafür, dass die Methoden von einer anderen Java VM aufgerufen werden können. Also von den Clients*/
import KommunikationServer.IKommunikationServerCallback;
import java.rmi.Remote;
import java.rmi.RemoteException;

/*LAUT RMI TUTORIAL MUSS BEI DEN INTERFACES BEI JEDER METHOHDE NOCH EIN THROWS REMOTEEXCEPTION HIN.
* BIS ICH MIR DA ABER GANZ SICHER BIN, LASS ICH ES ERSTMAL NUR IN JAVA DOC, WEIL SONST NÄMLICH BEI DEN TESTS AUCH
* ÜBERALL THROWS REMOTEEXCEPTION DAHINTER MUSS, WENN DIE METHODEN VON HIER NUTZEN*/

public interface ISpiellogik extends Remote {


    /**
     * Diese Methode meldet einen Spieler an.
     * @param nameSpieler entspricht dem Spielernamen.
     * @param passwort ist das Passwort des Spielers.
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return gibt zurück ob das Anmelden erfolgreich war.
     */
    boolean spielerAnmelden(String nameSpieler, String passwort);

    /**
     * Gibt an die Spiellogik weiter, dass ein Spieler auf den Button Aussteigen am GUIClient gedrückt hat
     * und somit aus dem Spiel ausgestiegen ist.
     * @param nameSpieler ist der name des Spielers.
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return ob Aktion erfolgreich
     */
    boolean spielerAusgestiegen(String nameSpieler);

    /**
     * Diese Methode meldet der Spiellogik, dass sich ein Spieler bereit gemeldet hat.
     * @param nameSpieler ist der name des Spielers, welcher Bereit geklickt hat.
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return gibt True zurück.
     */
    boolean spielerBereitMelden(String nameSpieler);

    /**
     * Diese Methode erhöht die Anzahl der ersties.
     * Mit dieser Methode kann also der Anwendungsfall Ersties verteilen, und Phase I abgedeckt werden.
     * @param gebaeude ID des Gebäudes, auf welchem die Anzahl erhöht wurde.
     * @param nameSpieler name des ausführenden Spielers
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return ob Aktion erfolgreich war.
     */
    boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler);

    /**
     * Aus dieser Methode, kann ausgelesen werden von wo und mit wie vielen Einheiten, auf welches Gebäude angegriffen
     * wird. Deckt also Phase II ab.
     * @param gebaeudeUrsprung Von wo.
     * @param anzahlUrsprung Mit wievielen.
     * @param gebaeudeZiel Auf welches Gebäude.
     * @param nameSpieler name des ausführenden Spielers
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return ob Aktion erfolgreich war
     */
    boolean angriffVonNach (Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler);


    /**
     * Aus dieser Methode, kann ausgelesen werden von wo und mit wie vielen Einheiten, auf welches Gebäude versetzt
     * wird. Deckt also Phase III ab.
     * @param gebaeudeUrsprung Von wo.
     * @param anzahlUrsprung Mit wievielen.
     * @param gebaeudeZiel Auf welches Gebäude.
     * @param nameSpieler name des ausführenden Spielers
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return ob Aktion erfolgreich war
            */
    boolean versetzenVonNach (Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler);


    /**
     * Diese Methode meldet an die Spiellogik, dass der aktuelle Spieler (der momentan am Zug ist)
     * seinen Zug beendet hat.
     * @param nameSpieler name des ausführenden Spielers
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Gibt True zurück.
     */
    boolean zugBeendet(String nameSpieler);

    /**
     * Diese Methode meldet an die Spiellogik, dass der aktuelle Spieler (Angreifer oder Verteidiger)
     * gewürfelt hat.
     * @param nameSpieler name des ausführenden Spielers
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Gibt True zurück.
     */
    boolean gewuerfelt(String nameSpieler);


    /**
     * Diese Methode fügt den Beobachter KommunikationSever hinzu, um das Observerpattern zu realisieren.
     * Die Rückmeldungen die dann über diesen "Beobachter Kanal" kommen werden in der Schnittstelle
     * IKommunikationServerCallback spezifiziert.
     * @param beobachter Ist der Observer, der hinzugefügt  wird.
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return gibt zurück ob erfolgreich.
     */
    boolean beobachterHinzufuegen(IKommunikationServerCallback beobachter);






}
