package KommunikationClient;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test IClientKommunikation")
public class IClientKommunikationTest {
    public IClientKommunikation test;

    //Kombidummy Spiellogik Spieldaten

    @Test
    public void testSpielerAnmelden(){
        assertTrue(test.spielerAnmelden("Bob", "p@ssw0rt"), "Spieler anmelden war nicht erfolgreich");
    }

    @Test
    public void testSpielerAusgestiegen(){
        assertTrue(test.spielerAusgestiegen("Bob"));
    }

    @Test
    public void testSpielerBereitMelden(){
        assertTrue(test.spielerBereitMelden("Bob"));
    }

    @Test
    public void testAktuellePhase(){
        assertEquals("Phase 1", test.aktuellePhase(), "Es wird nicht die richtige Phase angezeigt.");
    }

    @Test
    public void testErstiesAnzahlErhoehen(){
        assertTrue(test.erstiesAnzahlErhoehen(1, "Bob"), "Bob ist nicht der Besitzer oder er hat keine Ersties mehr");
    }

    @Test
    public void testAnzahlBonuskarten(){
        Integer[] bonuskarten = {0, 1, 0};
        assertArrayEquals(bonuskarten, test.anzahlBonuskarten("Bob"), "Nicht die richtigen Anzahlen");
    }

    @Test
    public void testAnzahlZuVerteilendeErsties(){
        assertEquals(test.anzahlZuVerteilendeErsties("Bob"), "Nicht die richtige Anzahl");
    }

    @Test
    public void testAnzahlErstiesAufGebaeude(){
        Integer[] ersties = {5, 6, 1, 15};
        assertArrayEquals(ersties, test.anzahlErstiesAufGebaeude(), "Nicht die richtigen Anzahlen");
    }

    @Test
    public void testAngriffVonNach(){
        assertTrue(test.angriffVonNach(1, 5, 2, "Bob"), "Angriff ist nicht durchführbar");
    }

    @Test
    public void testEigeneGebaeude(){
        Integer[] gebaeude = {1, 16, 21, 30};
        assertArrayEquals(gebaeude, test.eigeneGebaeude("Bob"), "Die IDs stimmen nicht");
    }

    @Test
    public void testAngreifbareNachbarGebaeude(){
        Integer[] gebaeude = {2, 10, 13, 25};
        assertArrayEquals(gebaeude, test.angreifbareNachbarGebaeude(1, "Bob"), "Nicht die richtigen Gebäude");
    }

    @Test
    public void testGewuerfelt(){
        assertTrue(test.gewuerfelt("Bob"), "Würfeln funktionierte nicht");
    }

    @Test
    public void testVersetzenVonNach(){
        assertTrue(test.versetzenVonNach(1, 2, 3, "Bob"), "Versetzen ging nicht");
    }

    @Test
    public void testEigeneNachbarGebaeude(){
        Integer[] gebaeude = {2, 8};
        assertArrayEquals(gebaeude, test.eigeneNachbarGebaeude(1, "Bob"));
    }

    @Test
    public void testZugBeendet(){
        assertTrue(test.zugBeendet("Bob"), "Zug lies sich nicht beenden");
    }

    @Test
    public void testFarbeSpieler(){
        Integer[] farben = {1, 5, 2, 4, 3};
        assertArrayEquals(farben, test.farbeSpieler(), "nicht die richtigen Farben");
    }
}
