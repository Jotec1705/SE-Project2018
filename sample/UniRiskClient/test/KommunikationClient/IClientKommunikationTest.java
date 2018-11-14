package KommunikationClient;

import Spieldaten.ISpieldaten;
import Spiellogik.ISpielkontrolle;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test IClientKommunikation")
public class IClientKommunikationTest {
    public IClientKommunikation kommunikation = null;
    public ISpielkontrolle kontrolle = null;
    public ISpieldaten daten = null;

    @BeforeAll
    public void initVorAllenTests(){
        //spiel anlegen mit einem spieler, sonst Bots
        kontrolle.spielAnlegen(3);
    }

    @Test
    public void testSpielerAnmelden(){
        assertTrue(kommunikation.spielerAnmelden("Horst", "blutwurst"));
    }

    @Test
    public void testSpielerAusgestiegen(){
        kommunikation.spielerAnmelden("Piet", "abcd12");
        assertTrue(kommunikation.spielerAusgestiegen("Piet"));
    }

    @Test
    public void testSpielerBereitMelden(){
        kommunikation.spielerAnmelden("Horst", "blutwurst");
        assertTrue(kommunikation.spielerBereitMelden("Horst"));
    }

    @Test
    public void testAktuellePhase(){
        kommunikation.spielerAnmelden("Bob", "p@ssw0rt");
        kommunikation.spielerBereitMelden("Bob");
        kontrolle.spielStarten();
        daten.aktuellePhaseSetzen("PhaseI");
        assertEquals("PhaseI", kommunikation.aktuellePhase());
    }

    @Test
    public void testErstiesAnzahlErhoehen(){
        kommunikation.spielerAnmelden("Horst", "affe1");
        kommunikation.spielerBereitMelden("Horst");
        assertTrue(kommunikation.erstiesAnzahlErhoehen(9, "Horst"));
    }

    @Test
    public void testAnzahlBonuskarten(){
        Integer[] bonuskarten = {0, 2, 0};
        kommunikation.spielerAnmelden("Bob", "p@ssw0rt");
        kommunikation.spielerBereitMelden("Bob");
        kontrolle.spielStarten();
        daten.aktuellePhaseSetzen("PhaseII");
        assertArrayEquals(bonuskarten, kommunikation.anzahlBonuskarten("Horst"));
    }

    @Test
    public void testAnzahlZuVerteilendeErsties(){
        Integer anzahl = 3;
        assertEquals(anzahl, kommunikation.anzahlZuVerteilendeErsties("M@rianne"), "Nicht die richtige Anzahl");
    }

    @Test
    public void testAnzahlErstiesAufGebaeude(){
        Integer[] ersties = {5, 1, 1, 2, 3};
        assertArrayEquals(ersties, kommunikation.anzahlErstiesAufGebaeude(), "Nicht die richtigen Anzahlen");
    }

    @Test
    public void testAngriffVonNach(){
        assertTrue(kommunikation.angriffVonNach(14, 5, 15, "P3t3r"), "Angriff ist nicht durchführbar");
    }

    @Test
    public void testEigeneGebaeude(){
        Integer[] gebaeude = {3, 8, 17, 21};
        assertArrayEquals(gebaeude, kommunikation.eigeneGebaeude("Horst"), "Die IDs stimmen nicht");
    }

    @Test
    public void testAngreifbareNachbarGebaeude(){
        Integer[] gebaeude = {10, 18};
        assertArrayEquals(gebaeude, kommunikation.angreifbareNachbarGebaeude(17, "Horst"), "Nicht die richtigen Gebäude");
    }

    @Test
    public void testGewuerfelt(){
        assertTrue(kommunikation.gewuerfelt("M@rianne"), "Würfeln funktionierte nicht");
    }

    @Test
    public void testVersetzenVonNach(){
        assertTrue(kommunikation.versetzenVonNach(15, 1, 14, "P3t3r"), "Versetzen ging nicht");
    }

    @Test
    public void testEigeneNachbarGebaeude(){
        Integer[] gebaeude = {11, 13, 15};
        assertArrayEquals(gebaeude, kommunikation.eigeneNachbarGebaeude(12, "Bob"));
    }

    @Test
    public void testZugBeendet(){
        assertTrue(kommunikation.zugBeendet("Horst"), "Zug lies sich nicht beenden");
    }

    @Test
    public void testFarbeSpieler(){
        Integer[] farben = {3, 8, 10};
        assertArrayEquals(farben, kommunikation.farbeSpieler(), "nicht die richtigen Farben");
    }
}
