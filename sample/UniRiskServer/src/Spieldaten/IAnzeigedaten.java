package Spieldaten;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAnzeigedaten extends Remote{
    /**
     * Diese Methode soll die ID´s der angreifbaren Gebäude eines Spieler zurückgeben
     * @param gebaeude ID des Gebäudes
     * @param nameSpieler Name des Spielers als String
     * @return gibt ein Array mit den GebäudeIDs der angreifbaren Nachbargebäude zurück
     */
    Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler);

    /**
     * Diese Methode soll die ID´s eigenen Nachbargebäude eines Spieler zurückgeben
     * @param gebaeude ID des Gebäudes
     * @param nameSpieler Name des Spielers als String
     * @return gibt ein Array mit den GebäudeIDs der Nachbargebäude zurück welche dem nameSpieler gehören
     */
    Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler);

    /**
     * Diese Methode soll die Namen aller Spieler zurückgeben
     * @return Array mit dem Namen aller Spieler als String
     */
    String[] spielerNamen();

    /**
     * Diese Methode soll zurückgeben ob Spieler bereit ist
     * @return true wenn Spieler bereit zum Spiel
     */
    boolean[] spielerBereit();

    /**
     * Diese Methode soll die IP-Adressen der Spieler zurückgeben
     * @return Array mit IP-Adressen der Spieler
     */
    String[] ipAdressen();

    /**
     * Diese Methode soll die Anzahl der Ersties auf einem Gebäude zurückgeben
     * @return Int-Array mit Anzahl der Ersties pro Gebäude ( Index entspricht Gebäude ID)
     */
    Integer[] anzahlErstiesAufGebaeude();

    /**
     * Diese Methode soll die Anzahl der Bonuskarten eines Spieler zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @return Int-Array mit Anzahl der Bonuskarten
     */
    Integer[] anzahlBonuskarten(String nameSpieler);

    /**
     * Diese Methode soll die Farben aller Spieler als Int-Wert zurückgeben
     * @return Array mit Farben der Spieler als Int-Wert. Array Index entspricht der Gebäude ID
     */
    Integer[] farbeSpieler();

    /**
     * Diese Methode soll die Anzahl der noch zu verteilenden Ersties eines Spielers zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @return Anzahl der zu verteilenden Ersties als Int
     */
    Integer anzahlZuVerteilendeErsties(String nameSpieler);

    /**
     * Diese Methode soll den Inhalt einer Missionskarte des Spielers zurückgeben
     * @param nameSpieler Name des Spielers als String
     * @return Inhalt der Missionskarte als String
     */
    String missionskarteInhalt(String nameSpieler);

    /**
     * Diese Methode soll die aktuelle Phase zurückgeben
     * @return Aktuelle Phase als String
     */
    String aktuellePhase();

    /**
     * Diese Methode gibt ein Array zurück mit den IDs der Gebäude, welche dem übergebenene Spieler gehören
     * @param nameSpieler Name des Spielers als String
     * @return Int-Array
     */
    Integer[] eigeneGebaeude(String nameSpieler);
}
