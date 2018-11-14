package Spieldaten;

/*sorgt dafür, dass die Methoden von einer anderen Java VM aufgerufen werden können. Also von den Clients*/
import java.rmi.Remote;
import java.rmi.RemoteException;

/*LAUT RMI TUTORIAL MUSS BEI DEN INTERFACES BEI JEDER METHOHDE NOCH EIN THROWS REMOTEEXCEPTION HIN.
 * BIS ICH MIR DA ABER GANZ SICHER BIN, LASS ICH ES ERSTMAL NUR IN JAVA DOC, WEIL SONST NÄMLICH BEI DEN TESTS AUCH
 * ÜBERALL THROWS REMOTEEXCEPTION DAHINTER MUSS, WENN DIE METHODEN VON HIER NUTZEN*/

public interface IAnzeigedaten extends Remote {
    /**
     * Diese Methode soll die ID´s der angreifbaren Gebäude eines Spieler zurückgeben
     * @param gebaeude ID des Gebäudes
     * @param nameSpieler Name des Spielers als String
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return gibt ein Array mit den GebäudeIDs der angreifbaren Nachbargebäude zurück
     */
    Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) throws RemoteException;

    /**
     * Diese Methode soll die ID´s eigenen Nachbargebäude eines Spieler zurückgeben
     * @param gebaeude ID des Gebäudes
     * @param nameSpieler Name des Spielers als String
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return gibt ein Array mit den GebäudeIDs der Nachbargebäude zurück welche dem nameSpieler gehören
     */
    Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler) throws RemoteException;

    /**
     * Diese Methode soll die Namen aller Spieler zurückgeben
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Array mit dem Namen aller Spieler als String
     */
    String[] spielerNamen() throws RemoteException;

    /**
     * Diese Methode soll zurückgeben ob Spieler bereit ist
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return true wenn Spieler bereit zum Spiel
     */
    boolean[] spielerBereit() throws RemoteException;

    /**
     * Diese Methode soll die IP-Adressen der Spieler zurückgeben
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Array mit IP-Adressen der Spieler
     */
    String[] ipAdressen() throws RemoteException;

    /**
     * Diese Methode soll die Anzahl der Ersties auf einem Gebäude zurückgeben
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Int-Array mit Anzahl der Ersties pro Gebäude ( Index entspricht Gebäude ID)
     */
    Integer[] anzahlErstiesAufGebaeude() throws RemoteException;

    /**
     * Diese Methode soll die Anzahl der Bonuskarten eines Spieler zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Int-Array mit Anzahl der Bonuskarten
     */
    Integer[] anzahlBonuskarten(String nameSpieler) throws RemoteException;

    /**
     * Diese Methode soll die Farben aller Spieler als Int-Wert zurückgeben
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Array mit Farben der Spieler als Int-Wert. Array Index entspricht der Gebäude ID
     */
    Integer[] farbeSpieler() throws RemoteException;

    /**
     * Diese Methode soll die Anzahl der noch zu verteilenden Ersties eines Spielers zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Anzahl der zu verteilenden Ersties als Int
     */
    Integer anzahlZuVerteilendeErsties(String nameSpieler) throws RemoteException;

    /**
     * Diese Methode soll den Inhalt einer Missionskarte des Spielers zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Inhalt der Missionskarte als String
     */
    String missionskarteInhalt(String nameSpieler) throws RemoteException;

    /**
     * Diese Methode soll die aktuelle Phase zurückgeben
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Aktuelle Phase als String
     */
    String aktuellePhase() throws RemoteException;

    /**
     * Diese Methode gibt ein Array zurück mit den IDs der Gebäude, welche dem übergebenene Spieler gehören
     * @param nameSpieler Name des Spielers als String
     * @throws RemoteException wird geworfen, wenn es zu einem Fehler bei der Kommunikation kommt.
     * @return Int-Array
     */
    Integer[] eigeneGebaeude(String nameSpieler) throws RemoteException;






}
