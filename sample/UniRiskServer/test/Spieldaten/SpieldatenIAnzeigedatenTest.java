package Spieldaten;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)


@DisplayName("Test der Anzeigedaten Schnittstelle")
class SpieldatenIAnzeigedatenTest {

    SpieldatenDummy dummy = new SpieldatenDummy();

    /**
      *  Hier habe ich die  möglichen / nicht möglichen Parameter deklariert um Sie in den
      *  Assertions mit den Return-Parametern des Dummies zu vergleichen
      */
    boolean[] wertBool = {true};
    String wertStrOK = "Test";
    String wertStrBAD = "Fail";
    String[] wertStrArr = {"testA","TestB"};
    Integer[] wertIntArr = {1,2};
    Integer wertIntOK = 1;
    Integer wertIntBAD = 2;



    @BeforeAll
    public void initVorAllenTests(){
        System.out.println("[Start] Bereite einige Tests vor");

    }


    @BeforeEach
    public  void initVorEinemTest(){
        System.out.println("[Init] Bereite einen konkreten Test vor");

    }

    @AfterEach
    public void testEnde(){
        System.out.println("..Test erfolgreich beendet!!");
    }

    @AfterAll
    public void Aufraeumen(){
        System.out.println("[End] Alle Tests beendet. Räume auf.");

    }


    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (int-Array) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testAngreifbareNachbarGebaeude() {
        System.out.println("[testAngreifbareNachbarGebaeude] Läuft..");
        assertArrayEquals(wertIntArr, dummy.angreifbareNachbarGebaeude(1,"Horst"),"Fehler return angreifbareNachbarGebaeude");

    }

    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (int-Array) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testEigeneNachbarGebaeude() {
        System.out.println("[testEigeneNachbarGebaeude] Läuft..");
        assertArrayEquals(wertIntArr, dummy.eigeneNachbarGebaeude(1,"Horst"),"Fehler return eigeneNachbarGebaeude");
    }

    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (String-Array) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testSpielerNamen() {
        System.out.println("[testSpielerNamen] Läuft..");
        assertArrayEquals(wertStrArr, dummy.spielerNamen(),"Fehler return spielerNamen#");
    }


    /**
     *
     */
    @Test
    public void testSpielerBereit() {
        System.out.println("Hallo liebe Testumgebung");
        assertArrayEquals(wertBool, dummy.spielerBereit(),"Fehlgeschlagen");

    }

    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (String-Array) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testIpAdressen() {
        System.out.println("[testIpAdressen] Läuft..");
        assertArrayEquals(wertStrArr, dummy.ipAdressen(),"Fehler return IpAdressen");
    }


    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (Int-Array) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testAnzahlErstiesAufGebaeude() {
        System.out.println("[testAnzahlErstiesAufGebaeude] Läuft..");
        assertArrayEquals(wertIntArr, dummy.anzahlErstiesAufGebaeude(),"Fehler return anzahlErstiesAufGebaeude");
    }


    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (Int-Array) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testFarbeSpieler() {
        System.out.println("[testFarbeSpieler] Läuft..");
        assertArrayEquals(wertIntArr, dummy.farbeSpieler(),"Fehler return farbeSpieler");
    }

    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (Int) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testAnzahlZuVerteilendeErsties() {
        System.out.println("[testAnzahlZuVerteilendeErsties] Läuft..");
        assertEquals(wertIntOK, dummy.anzahlZuVerteilendeErsties("Horst"),"Fehler return anzahZuVerteilendeErsties");
        assertNotEquals(wertIntBAD, dummy.anzahlZuVerteilendeErsties("Horst"),"Fehler return anzahZuVerteilendeErsties");
    }

    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (String) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testMissionskarteInhalt() {
        System.out.println("[testAnzahlZuVerteilendeErsties] Läuft..");
        assertEquals(wertStrOK, dummy.missionskarteInhalt("Horst"),"Fehler return anzahZuVerteilendeErsties");
        assertNotEquals(wertStrBAD, dummy.missionskarteInhalt("Horst"),"Fehler return anzahZuVerteilendeErsties");
    }


    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (String) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testAktuellePhase() {
        System.out.println("[testAktuellePhase] Läuft..");
        assertEquals(wertStrOK, dummy.aktuellePhase(),"Fehler return aktuellePhase");
        assertNotEquals(wertStrBAD, dummy.aktuellePhase(),"Fehler return aktuellePhase");
    }


    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (Int-Array) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testEigeneGebaeude() {
        System.out.println("[testEigeneGebaeude] Läuft..");
        assertArrayEquals(wertIntArr, dummy.eigeneGebaeude("Horst"),"Fehler return eigeneGebaeude");
    }

}

