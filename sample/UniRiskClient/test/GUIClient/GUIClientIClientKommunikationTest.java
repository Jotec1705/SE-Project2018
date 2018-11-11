package GUIClient;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("IClientKommunikationTest")
public class GUIClientIClientKommunikationTest {
    public ClientKommunikationDummy dummy;

    @Test
    public void testSpielerAnmelden(){
        assertTrue(dummy.spielerAnmelden("Bob", "p@ssw0rt"), "Spieler anmelden war nicht erfolgreich");
    }

    @Test
    public void testSpielerAusgestiegen(){
        assertTrue(dummy.spielerAusgestiegen("Bob"));
    }

    @Test
    public void testSpielerBereitMelden(){
        assertTrue(dummy.spielerBereitMelden("Bob"));
    }

    @Test
    public void testAktuellePhase(){
        assertEquals("Phase 1", dummy.aktuellePhase(), "Es wird nicht die richtige Phase angezeigt.");
    }

    @Test
    public void testErstiesAnzahlErhoehen(){
        assertTrue(dummy.erstiesAnzahlErhoehen(1, "Bob"), "Bob ist nicht der Besitzer oder er hat keine Ersties mehr");
    }

    @Test
    public void testAnzahlBonuskarten(){
        Integer[] bonuskarten = {0, 1, 0};
        assertArrayEquals(bonuskarten, dummy.anzahlBonuskarten("Bob"), "Nicht die richtigen Anzahlen");
    }

    @Test
    public void testAnzahlZuVerteilendeErsties(){
        assertEquals(dummy.anzahlZuVerteilendeErsties("Bob"), "Nicht die richtige Anzahl");
    }

    @Test
    public void testAnzahlErstiesAufGebaeude(){
        Integer[] ersties = {5, 6, 1, 15};
        assertArrayEquals(ersties, dummy.anzahlErstiesAufGebaeude(), "Nicht die richtigen Anzahlen");
    }

    @Test
    public void testAngriffVonNach(){
        assertTrue(dummy.angriffVonNach(1, 5, 2, "Bob"), "Angriff ist nicht durchführbar");
    }

    @Test
    public void testEigeneGebaeude(){
        Integer[] gebaeude = {1, 16, 21, 30};
        assertArrayEquals(gebaeude, dummy.eigeneGebaeude("Bob"), "Die IDs stimmen nicht");
    }

    @Test
    public void testAngreifbareNachbarGebaeude(){
        Integer[] gebaeude = {2, 10, 13, 25};
        assertArrayEquals(gebaeude, dummy.angreifbareNachbarGebaeude(1, "Bob"), "Nicht die richtigen Gebäude");
    }

    @Test
    public void testGewuerfelt(){
        assertTrue(dummy.gewuerfelt("Bob"), "Würfeln funktionierte nicht");
    }

    @Test
    public void testVersetzenVonNach(){
        assertTrue(dummy.versetzenVonNach(1, 2, 3, "Bob"), "Versetzen ging nicht");
    }

    @Test
    public void testEigeneNachbarGebaeude(){
        Integer[] gebaeude = {2, 8};
        assertArrayEquals(gebaeude, dummy.eigeneNachbarGebaeude(1, "Bob"));
    }

    @Test
    public void testZugBeendet(){
        assertTrue(dummy.zugBeendet("Bob"), "Zug lies sich nicht beenden");
    }
/*???????
    @Test
    public void testBeobachterHinzufuegen(){
        assertTrue(dummy.beobachterHinzufuegen());
    }
    */

    @Test
    public void testFarbeSpieler(){
        Integer[] farben = {1, 5, 2, 4, 3};
        assertArrayEquals(farben, dummy.farbeSpieler(), "nicht die richtigen Farben");
    }
}
