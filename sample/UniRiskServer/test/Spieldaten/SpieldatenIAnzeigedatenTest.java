package Spieldaten;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)


@DisplayName("Test der Anzeigedaten Schnittstelle")
class SpieldatenIAnzeigedatenTest {

    IAnzeigedaten anzeige = null;
    ISpieldaten daten = null;
    //Triggern über ISpieldaten: Sag darüber ersties erhöhen und schau über IAnzeigedaten, ob das richtig eingetragen wurde

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
    //testkommi


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
     *
     */
    @Test
    public void testAngreifbareNachbarGebaeude() {
        System.out.println("[testAngreifbareNachbarGebaeude] Läuft..");
        daten.besitzerGebaeudeAnpassen(1,"tom");
        daten.besitzerGebaeudeAnpassen(2,"tom");
        daten.besitzerGebaeudeAnpassen(3,"tom");
        daten.besitzerGebaeudeAnpassen(12,"tom");
        daten.besitzerGebaeudeAnpassen(13,"Horst");
        Integer[] wertTestAngreifbareNachbargebaeude ={13};
        assertArrayEquals(wertTestAngreifbareNachbargebaeude, anzeige.angreifbareNachbarGebaeude(1,"tom"),"Fehler return angreifbareNachbarGebaeude");

    }

    /**
     *
     */
    @Test
    public void testEigeneNachbarGebaeude() {
        System.out.println("[testEigeneNachbarGebaeude] Läuft..");
        daten.besitzerGebaeudeAnpassen(1,"Horst");
        daten.besitzerGebaeudeAnpassen(2,"tom");
        daten.besitzerGebaeudeAnpassen(3,"tom");
        daten.besitzerGebaeudeAnpassen(12,"Horst");
        daten.besitzerGebaeudeAnpassen(13,"Horst");
        Integer[] wertTestAngreifbareNachbargebaeude ={12,13};
        assertArrayEquals(wertIntArr, anzeige.eigeneNachbarGebaeude(1,"Horst"),"Fehler return eigeneNachbarGebaeude");
    }

    /**
     *
     */
    @Test
    public void testSpielerNamen() {
        System.out.println("[testSpielerNamen] Läuft..");
        daten.spielerAnmelden("tom","passwort");
        daten.spielerAnmelden("tim","passwort");
        daten.spielerAnmelden("tum","passwort");
        daten.spielerAnmelden("tam","passwort");
        daten.spielerAnmelden("tem","passwort");
        String[] namenDerSpielerArr = {"tam","tem","tim","tom","tum"};
        assertArrayEquals(namenDerSpielerArr, anzeige.spielerNamen(),"Fehler return spielerNamen");
    }


    /**
     *
     */
    @Test
    public void testSpielerBereit() {
        System.out.println("[testSpielerBereit] Läuft..");
        daten.spielerAnmelden("tom","passwort");
        daten.spielerBereit();
        assertArrayEquals(wertBool, anzeige.spielerBereit(),"Fehlgeschlagen");

    }

    /**
     * ZU KLÄREN wann werden IP-Adressen eingepflegt
     */
    @Test
    public void testIpAdressen() {
        System.out.println("[testIpAdressen] Läuft..");
        daten.spielerAnmelden("tom","passwort");
        daten.spielerAnmelden("tim","passwort");
        daten.spielerAnmelden("tum","passwort");
        daten.spielerAnmelden("tam","passwort");
        daten.spielerAnmelden("tem","passwort");
        assertArrayEquals(wertStrArr, anzeige.ipAdressen(),"Fehler return IpAdressen");
    }


    /**
     *
     */
    @Test
    public void testAnzahlErstiesAufGebaeude() {
        System.out.println("[testAnzahlErstiesAufGebaeude] Läuft..");
        Integer[] anzahlErsties1Arr = new Integer[0];
        for(int i =1 ; i<=32;i++){
            anzahlErsties1Arr[i] = 1;
            daten.anzahlErstiesAnpassen(i,1);
        }

        assertArrayEquals(anzahlErsties1Arr, anzeige.anzahlErstiesAufGebaeude(),"Fehler return anzahlErstiesAufGebaeude");
    }


    /**
     * ZU KLÄREN wie wird Frabe vergeben
     */
    @Test
    public void testFarbeSpieler() {
        System.out.println("[testFarbeSpieler] Läuft..");
        assertArrayEquals(wertIntArr, anzeige.farbeSpieler(),"Fehler return farbeSpieler");
    }

    /**
     *
     */
    @Test
    public void testAnzahlZuVerteilendeErsties() {
        System.out.println("[testAnzahlZuVerteilendeErsties] Läuft..");

        assertEquals(wertIntOK, anzeige.anzahlZuVerteilendeErsties("Horst"),"Fehler return anzahZuVerteilendeErsties");
        assertNotEquals(wertIntBAD, anzeige.anzahlZuVerteilendeErsties("Horst"),"Fehler return anzahZuVerteilendeErsties");
    }

    /**
     *
     */
    @Test
    public void testMissionskarteInhalt() {
        System.out.println("[testAnzahlZuVerteilendeErsties] Läuft..");
        assertEquals(wertStrOK, anzeige.missionskarteInhalt("Horst"),"Fehler return anzahZuVerteilendeErsties");
        assertNotEquals(wertStrBAD, anzeige.missionskarteInhalt("Horst"),"Fehler return anzahZuVerteilendeErsties");
    }


    /**
     *
     */
    @Test
    public void testAktuellePhase() {
        System.out.println("[testAktuellePhase] Läuft..");
        daten.aktuellePhaseSetzen("Phase I");
        String phase1Str = "Phase I";
        assertEquals(phase1Str, anzeige.aktuellePhase(),"Fehler return aktuellePhase");

    }


    /**
     * Dieser Test prüft ob der Rückgabewert im Dummy (Int-Array) mit dem Wert im Testfall übereinstimmmt
     */
    @Test
    public void testEigeneGebaeude() {
        System.out.println("[testEigeneGebaeude] Läuft..");
        Integer[] maxGebaeude = new Integer[0];
        Integer[] moritzGebaeude = {33};

        for(int i =1 ; i<=32;i++){
            maxGebaeude[i-1] = 1;

           daten.besitzerGebaeudeAnpassen(i,"max");

        }

        daten.besitzerGebaeudeAnpassen(33,"moritz");
    //Kommetar zum puschen1233
        assertArrayEquals(moritzGebaeude, anzeige.eigeneGebaeude("moritz"),"Fehler return eigeneGebaeude");
    }

}

