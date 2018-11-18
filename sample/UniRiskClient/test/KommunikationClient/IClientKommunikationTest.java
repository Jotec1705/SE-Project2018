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
        assertFalse(kommunikation.spielerAusgestiegen("M@rianne"));
    }

    @Test
    public void testSpielerBereitMelden(){
        kommunikation.spielerAnmelden("Horst", "blutwurst");
        assertTrue(kommunikation.spielerBereitMelden("Horst"));
        assertFalse(kommunikation.spielerBereitMelden("M@rianne"));
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
        kommunikation.spielerAnmelden("Horst", "blutwurst");
        kommunikation.spielerBereitMelden("Horst");
        kontrolle.spielStarten();
        assertTrue(kommunikation.erstiesAnzahlErhoehen(9, "Horst"));
    }

    @Test
    public void testAnzahlBonuskarten(){
        Integer[] bonuskarten = {0, 2, 0};
        kommunikation.spielerAnmelden("Bob", "p@ssw0rt");
        kommunikation.spielerBereitMelden("Bob");
        kontrolle.spielStarten();
        assertArrayEquals(bonuskarten, kommunikation.anzahlBonuskarten("Horst"));
    }

    @Test
    public void testAnzahlZuVerteilendeErsties(){
        Integer anzahl = 3;
        kommunikation.spielerAnmelden("Piet", "abcd12");
        kommunikation.spielerBereitMelden("Piet");
        kontrolle.spielStarten();
        assertEquals(anzahl, kommunikation.anzahlZuVerteilendeErsties("M@rianne"), "Nicht die richtige Anzahl");
    }

    @Test
    public void testAnzahlErstiesAufGebaeude(){
        Integer[] ersties = {5, 1, 1, 2, 3};
        kommunikation.spielerAnmelden("Bob", "p@ssw0rt");
        kommunikation.spielerBereitMelden("Bob");
        kontrolle.spielStarten();
        assertArrayEquals(ersties, kommunikation.anzahlErstiesAufGebaeude(), "Nicht die richtigen Anzahlen");
    }

    @Test
    public void testAngriffVonNach(){
        kommunikation.spielerAnmelden("P3t3r", "affe1");
        kommunikation.spielerBereitMelden("P3t3r");
        kontrolle.spielStarten();
        daten.aktuellePhaseSetzen("PhaseI");
        assertTrue(kommunikation.angriffVonNach(14, 5, 15, "P3t3r"));
    }

    @Test
    public void testEigeneGebaeude(){
        Integer[] gebaeude = {3, 8, 17, 21};
        kommunikation.spielerAnmelden("Horst", "blutwurst");
        kommunikation.spielerBereitMelden("Horst");
        kontrolle.spielStarten();
        assertArrayEquals(gebaeude, kommunikation.eigeneGebaeude("Horst"));
    }

    @Test
    public void testAngreifbareNachbarGebaeude(){
        Integer[] gebaeude = {10, 18};
        kommunikation.spielerAnmelden("Horst", "blutwurst");
        kommunikation.spielerBereitMelden("Horst");
        kontrolle.spielStarten();
        assertArrayEquals(gebaeude, kommunikation.angreifbareNachbarGebaeude(17, "Horst"));
    }

    @Test
    public void testGewuerfelt(){
        assertFalse(kommunikation.gewuerfelt("P3t3r"));

        kommunikation.spielerAnmelden("P3t3r", "affe1");
        kommunikation.spielerBereitMelden("P3t3r");
        kontrolle.spielStarten();
        daten.aktuellePhaseSetzen("PhaseI");
        kommunikation.angriffVonNach(14, 5, 15, "P3t3r");
        assertTrue(kommunikation.gewuerfelt("P3t3r"));
    }

    @Test
    public void testVersetzenVonNach(){
        kommunikation.spielerAnmelden("p3t3r", "abcd12");
        kommunikation.spielerBereitMelden("P3t3r");
        kontrolle.spielStarten();
        daten.aktuellePhaseSetzen("PhaseI");
        assertTrue(kommunikation.versetzenVonNach(15, 1, 14, "P3t3r"));
    }

    @Test
    public void testEigeneNachbarGebaeude(){
        Integer[] gebaeude = {11, 13, 15};
        kommunikation.spielerAnmelden("Bob", "p@ssw0rt");
        kommunikation.spielerBereitMelden("Bob");
        kontrolle.spielStarten();
        assertArrayEquals(gebaeude, kommunikation.eigeneNachbarGebaeude(12, "Bob"));
    }

    @Test
    public void testZugBeendet(){
        kommunikation.spielerAnmelden("Horst", "blutwurst");
        kommunikation.spielerBereitMelden("Horst");
        kontrolle.spielStarten();
        daten.aktuellePhaseSetzen("PhaseI");
        assertTrue(kommunikation.zugBeendet("Horst"), "Zug lies sich nicht beenden");
    }

    @Test
    public void testFarbeSpieler(){
        Integer[] farben = {3, 8, 10};
        kommunikation.spielerAnmelden("Bob", "p@ssw0rt");
        kommunikation.spielerBereitMelden("Bob");
        kontrolle.spielStarten();
        assertArrayEquals(farben, kommunikation.farbeSpieler());
    }
}
