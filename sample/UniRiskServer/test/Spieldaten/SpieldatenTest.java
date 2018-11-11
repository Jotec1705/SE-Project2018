package Spieldaten;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der ISpieldaten Schnittstelle")
class SpieldatenTest {

    ISpieldaten spieldaten = null;

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
    void anzahlGebaeudeSpielerTest(String nameSpieler){
        System.out.println("[AnzahlGebäudeSieler] läuft");
        //assertEquals(5, spieldaten.anzahlGebaeudeSpieler("David"),"Ungleich");
    }

    /**
     *
     */
    @Test
    void besitzerGebaeudeTest(Integer gebaeude){
        System.out.println("[BesitzerGebäude] läuft");
        assertEquals("David", spieldaten.besitzerGebaeude(1));
    }

    /**
     *
     */
    @Test
    void besitzerGebaeudeAnpassenTest(Integer gebaeude, String nameSpieler){
        System.out.println("[BesitzerGebäudeAnpassen] läuft");
        assertEquals(true, spieldaten.besitzerGebaeudeAnpassen(1, "David"));
    }

    /**
     *
     */
    @Test
    void nachbarGebaeudeTest(Integer gebaeude){
        System.out.println("[NachbarGebäude] läuft");
        int [] nachabarGebaeude = {2,3,12,13};
        //assertArrayEquals(nachabarGebaeude, spieldaten.nachbarGebaeude(1));

    }

    /**
     *
     */
    @Test
    void anzahlErstiesGebaeude(Integer gebaeude){
        System.out.println("[AnzahlErstiesGebäude] läuft");
        //assertEquals(10, spieldaten.anzahlErstiesGebaeude(1));

    }

    /**
     *
     */
    @Test
    void anzahlErstiesAnpassenTest(Integer gebaeude, Integer anzahlErsties){
        System.out.println("[AnzahlErstiesAnpassen] läuft");

    }

    /**
     *
     */
    @Test
    void anzahlFachbereicheSpielerTest(String nameSpieler){
        System.out.println("[AnzahlFachbereicheSpieler] läuft");

    }

    /**
     *
     */
    @Test
    void besitzerFachbereichAnpassenTest(Integer fachbereich, String nameSpieler){
        System.out.println("[BesitzerFachbereichAnpassen] läuft");

    }

    /**
     *
     */
    @Test
    void anzahlDerBonuskartenTest(String nameSpieler, Bonuskarte typBonuskarte){
        System.out.println("[AnzahlDerBonusKarten] läuft");

    }

    /**
     *
     */
    @Test
    void anzahlDerBonuskartenAnpassenTest(String nameSpieler, Bonuskarte typBonuskarte, Integer anzahlBonuskarten){
        System.out.println("[AnzahlDerBonusKartenAnpassen] läuft");

    }

    /**
     *
     */
    @Test
    void missionskarteSpielerTest(String nameSpieler){
        System.out.println("[MissionskarteSpieler] läuft");

    }

    /**
     *
     */
    @Test
    void aktuellePhaseSetzenTest(String phase){
        System.out.println("[AktuellePhaseSetzen] läuft");

    }

    /**
     *
     */
    @Test
    void naechsterSpielerTest(){
        System.out.println("[NächsterSpieler] läuft");

    }

    /**
     *
     */
    @Test
    void spielAnlegenTest(int spielerAnzahl){
        System.out.println("[SpielAnlegen] läuft");

    }

    /**
     *
     */
    @Test
    void spielerAnmeldenTest(String nameSpieler, String passwort){
        System.out.println("[SpielerAnmelden] läuft");

    }

    /**
     *
     */
    @Test
    void spielerBereitTest(){
        System.out.println("[SpielerBereit] läuft");

    }

    /**
     *
     */
    @Test
    void aktuellerSpielerTest(){
        System.out.println("[aktuellerSpieler] läuft");

    }

    /**
     *
     */
    @Test
    void spielZustandHolenTest(){
        System.out.println("[SpielZustandholen] läuft");

    }

    /**
     *
     */
    @Test
    void spielZustandSetzenTest(Zustand aktuellerZustand){
        System.out.println("[SpielZustandSetzen] läuft");

    }

}
