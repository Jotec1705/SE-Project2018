package GUIClient;

import KommunikationClient.IClientKommunikation;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("IClientKommunikationTest")
public class GUIClientIClientKommunikationTest {
    public IClientKommunikation kommunikation = null;
    public ClientKommunikationDummy dummy = null;

    @Test
    public void testSpielerAnmelden(){
        assertTrue(kommunikation.spielerAnmelden("Bob", "p@ssw0rt"), "Spieler anmelden war nicht erfolgreich");
    }

    @Test
    public void testSpielerAusgestiegen(){
        assertTrue(kommunikation.spielerAusgestiegen("Bob"));
    }

    @Test
    public void testSpielerBereitMelden(){
        assertTrue(kommunikation.spielerBereitMelden("Bob"));
    }

    @Test
    public void testAktuellePhase(){
        assertEquals("Phase 1", kommunikation.aktuellePhase(), "Es wird nicht die richtige Phase angezeigt.");
    }
/*
    @Test
    public void testErstiesAnzahlErhoehen(){

    }

    @Test
    public void testAnzahlBonuskarten(){

    }

    @Test
    public void testAnzahlZuVerteilendeErsties(){

    }

    @Test
    public void testAnzahlErstiesAufGebaeude(){

    }

    @Test
    public void testAngriffVonNach(){

    }

    @Test
    public void testEigeneGebaeude(){

    }

    @Test
    public void testAngreifbareNachbarGebaeude(){

    }

    @Test
    public void testGewuerfelt(){

    }

    @Test
    public void testVersetzenVonNach(){

    }

    @Test
    public void testEigeneNachbarGebaeude(){

    }

    @Test
    public void testZugBeendet(){

    }

    @Test
    public void testBeobachterHinzufuegen(){

    }

    @Test
    public void testFarbeSpieler(){

    }*/
}
