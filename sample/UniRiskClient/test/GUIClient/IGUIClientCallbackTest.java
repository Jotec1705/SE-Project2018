package GUIClient;

import KommunikationClient.IClientKommunikation;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

class IGUIClientCallbackTest {
    public IGUIClientCallback callback;
    public GUIClientDummy dummy;
    public IClientKommunikation kommunikation;

    @Test
    public void testErstiesAnzahlErhoehen(){
        assertTrue(kommunikation.erstiesAnzahlErhoehen(9, "Horst"), "Ersties wurden nicht erhöht");
        assertTrue(dummy.aktualisierenLobby(), "Lobby aktualisieren funktioniert nicht"); //?
    }

    @Test
    public void testAktualisierenKarte(){
        assertTrue(dummy.aktualisierenKarte(), "Karte aktualisieren funktioniert nicht");
    }

    @Test
    public void testZugZuteilung(){
        assertNotEquals("Bob", callback.zugZuteilung("Bob"), "Zuteilung funktioniert nicht richtig");
    }

    @Test
    public void testAngriffAbwehren(){
        assertTrue(callback.angriffAbwehren("Horst", 2), "abwehren funktioniert nicht");
    }

    @Test
    public void testWuerfelErgebnis(){
        int[] wuerfelv = {3, 4};
        int[] wuerfela = {1, 6};
        assertTrue(callback.wuerfelErgebnis("Bob", wuerfelv, wuerfela, 1, 1), "die Ergebnisse werden nicht angezeigt");
    }

    @Test
    public void testSpielBeendet(){
        assertTrue(callback.spielBeendet(), "Spiel geht nicht beenden");
    }
}