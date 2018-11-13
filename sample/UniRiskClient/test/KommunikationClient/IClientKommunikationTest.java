package KommunikationClient;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test IClientKommunikation")
public class IClientKommunikationTest {
    public IClientKommunikation test;
    public SpiellogikSpieldatenDummy anzeigedatenDummy;
    public SpiellogikSpieldatenDummy spiellogikDummy;
    //Kombidummy Spiellogik Spieldaten

    @Test
    public void testSpielerAnmelden(){
        assertTrue(spiellogikDummy.spielerAnmelden("Horst", "blutwurst"), "Spieler anmelden war nicht erfolgreich");
    }

    @Test
    public void testSpielerAusgestiegen(){
        assertTrue(spiellogikDummy.spielerAusgestiegen("Piet"));
    }

    @Test
    public void testSpielerBereitMelden(){
        assertTrue(spiellogikDummy.spielerBereitMelden("Horst"));
    }

    @Test
    public void testAktuellePhase(){
        assertEquals("PhaseII", anzeigedatenDummy.aktuellePhase(), "Es wird nicht die richtige Phase angezeigt.");
    }

    @Test
    public void testErstiesAnzahlErhoehen(){
        assertTrue(spiellogikDummy.erstiesAnzahlErhoehen(9, "Horst"), "Bob ist nicht der Besitzer oder er hat keine Ersties mehr");
    }

    @Test
    public void testAnzahlBonuskarten(){
        Integer[] bonuskarten = {0, 2, 0};
        assertArrayEquals(bonuskarten, anzeigedatenDummy.anzahlBonuskarten("Horst"), "Nicht die richtigen Anzahlen");
    }

    @Test
    public void testAnzahlZuVerteilendeErsties(){
        Integer anzahl = 3;
        assertEquals(anzahl, anzeigedatenDummy.anzahlZuVerteilendeErsties("M@rianne"), "Nicht die richtige Anzahl");
    }

    @Test
    public void testAnzahlErstiesAufGebaeude(){
        Integer[] ersties = {5, 1, 1, 2, 3};
        assertArrayEquals(ersties, anzeigedatenDummy.anzahlErstiesAufGebaeude(), "Nicht die richtigen Anzahlen");
    }

    @Test
    public void testAngriffVonNach(){
        assertTrue(spiellogikDummy.angriffVonNach(14, 5, 15, "P3t3r"), "Angriff ist nicht durchführbar");
    }

    @Test
    public void testEigeneGebaeude(){
        Integer[] gebaeude = {3, 8, 17, 21};
        assertArrayEquals(gebaeude, test.eigeneGebaeude("Horst"), "Die IDs stimmen nicht");
    }

    @Test
    public void testAngreifbareNachbarGebaeude(){
        Integer[] gebaeude = {10, 18};
        assertArrayEquals(gebaeude, anzeigedatenDummy.angreifbareNachbarGebaeude(17, "Horst"), "Nicht die richtigen Gebäude");
    }

    @Test
    public void testGewuerfelt(){
        assertTrue(spiellogikDummy.gewuerfelt("M@rianne"), "Würfeln funktionierte nicht");
    }

    @Test
    public void testVersetzenVonNach(){
        assertTrue(spiellogikDummy.versetzenVonNach(15, 1, 14, "P3t3r"), "Versetzen ging nicht");
    }

    @Test
    public void testEigeneNachbarGebaeude(){
        Integer[] gebaeude = {11, 13, 15};
        assertArrayEquals(gebaeude, anzeigedatenDummy.eigeneNachbarGebaeude(12, "Bob"));
    }

    @Test
    public void testZugBeendet(){
        assertTrue(spiellogikDummy.zugBeendet("Horst"), "Zug lies sich nicht beenden");
    }

    @Test
    public void testFarbeSpieler(){
        Integer[] farben = {3, 8, 10};
        assertArrayEquals(farben, anzeigedatenDummy.farbeSpieler(), "nicht die richtigen Farben");
    }
}
