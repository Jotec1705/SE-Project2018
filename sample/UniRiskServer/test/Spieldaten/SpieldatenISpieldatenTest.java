package Spieldaten;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der ISpieldaten Schnittstelle")
class SpieldatenISpieldatenTest {

    ISpieldaten spieldaten = null;

    @BeforeAll
    public void initVorAllenTests(){

    }


    @BeforeEach
    public  void initVorEinemTest(){

    }

    @AfterEach
    public void testEnde(){

    }

    @AfterAll
    public void Aufraeumen(){

    }

    /**
     *
     */
    @Test
    void testAnzahlGebaeudeSpieler(String nameSpieler){
        Integer gebaeudeSpieler = 5;
        assertEquals(gebaeudeSpieler, spieldaten.anzahlGebaeudeSpieler("David"),"Ungleich");
    }

    /**
     *
     */
    @Test
    void testBesitzerGebaeude(Integer gebaeude){
        assertEquals("David", spieldaten.besitzerGebaeude(1));
    }

    /**
     *
     */
    @Test
    void testBesitzerGebaeudeAnpassen(Integer gebaeude, String nameSpieler){
        assertEquals(true, spieldaten.besitzerGebaeudeAnpassen(1, "David"));
    }

    /**
     *
     */
    @Test
    void testNachbarGebaeude(Integer gebaeude){
        Integer [] nachabarGebaeude = {2,3,12,13};
        assertArrayEquals(nachabarGebaeude, spieldaten.nachbarGebaeude(1));

    }

    /**
     *
     */
    @Test
    void testanzahlErstiesGebaeude(Integer gebaeude){
        Integer anzahlErsties = 10;
        assertEquals(anzahlErsties, spieldaten.anzahlErstiesGebaeude(1));

    }

    /**
     *
     */
    @Test
    void testAnzahlErstiesAnpassen(Integer gebaeude, Integer anzahlErsties){
        assertEquals(true, spieldaten.anzahlErstiesAnpassen(1,10));
    }

    /**
     *
     */
    @Test
    void testAnzahlFachbereicheSpieler(String nameSpieler){
        Integer anzahlFachbereich = 1;
        assertEquals(anzahlFachbereich, spieldaten.anzahlFachbereicheSpieler("Meyer"));
    }

    /**
     *
     */
    @Test
    void testBesitzerFachbereichAnpassen(Integer fachbereich, String nameSpieler){
        assertEquals(true, spieldaten.besitzerFachbereichAnpassen(1,"Müller"));
    }

    /**
     *
     */
    @Test
    void testAnzahlDerBonuskarten(String nameSpieler, Bonuskarte typBonuskarte){
        Integer anzahlBonuskarten = 7;
        assertEquals(anzahlBonuskarten, spieldaten.anzahlDerBonuskarten("Huber",Bonuskarte.Ersties));
    }

    /**
     *
     */
    @Test
    void testAnzahlDerBonuskartenAnpassen(String nameSpieler, Bonuskarte typBonuskarte, Integer anzahlBonuskarten){
        assertEquals(true, spieldaten.anzahlDerBonuskartenAnpassen("Hans", Bonuskarte.Studenten, 2));
    }

    /**
     *
     */
    @Test
    void testMissionskarteSpieler(String nameSpieler){
        Missionskarte missionskarte = Missionskarte.BefreienVonStudiengang;
        assertEquals(missionskarte, spieldaten.missionskarteSpieler("Willi"));
    }

    /**
     *
     */
    @Test
    void testAktuellePhaseSetzen(String phase){
        assertEquals(true, spieldaten.aktuellePhaseSetzen("Phase 1"));
    }

    /**
     *
     */
    @Test
    void testNaechsterSpieler(){
        assertEquals(true, spieldaten.naechsterSpieler());
    }

    /**
     *
     */
    @Test
    void testSpielAnlegen(int spielerAnzahl){
        assertEquals(true, spieldaten.spielAnlegen(5));
    }

    /**
     *
     */
    @Test
    void testSpielerAnmelden(String nameSpieler, String passwort){
        assertEquals(true, spieldaten.spielerAnmelden("Test1","12345"));
    }

    /**
     *
     */
    @Test
    void testSpielerBereit(){
        boolean[] spielerBereit= {true};
        assertEquals(spielerBereit, spieldaten.spielerBereit());
    }

    /**
     *
     */
    @Test
    void testAktuellerSpieler(){
        assertEquals("Heinrich", spieldaten.aktuellerSpieler());
    }

    /**
     *
     */
    @Test
    void testSpielZustandHolen(){
        Zustand spielZustand = Zustand.Aktiv;
        assertEquals(spielZustand, spieldaten.spielZustandHolen());
    }

    /**
     *
     */
    @Test
    void testSpielZustandSetzen(Zustand aktuellerZustand){
        assertEquals(true, spieldaten.spielZustandSetzen(Zustand.Beendet));
    }

}
