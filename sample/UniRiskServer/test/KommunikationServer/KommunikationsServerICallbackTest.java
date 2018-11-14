

package KommunikationServer;

import Spiellogik.ISpiellogik;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der Callback Schnittstelle")
public class KommunikationsServerICallbackTest {

    public ISpiellogik logik = null;
    public IKommunikationServerCallbackDummy dummy = null;

    @BeforeAll
    public void initVorAllenTests(){
        //Beobachter in der der Spiellogik hinzufügen

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

    @Test
    public void testLobbyAktualisieren(){
        dummy.aktualisiereLobbyAufgerufen = false;
        logik.spielerAnmelden("Horst", "blutwurst1");
        assertTrue(dummy.aktualisiereLobbyAufgerufen);
    }

    @Test
    public void testKarteAktualisieren(){
        //wie oben
        assertEquals(true, dummy.aktualisierenKarte(), "Die Anfrage zum" +
                "Aktualisieren der Karte wurde nicht korrekt verarbeitet");
    }


    @Test
    public void testZugZuteilung(){
        //Ein Spielvorgang und dann Zugzuteilung. Erst später testen
        assertEquals(true, dummy.zugZuteilung("Horst"), "Die Zuteilung" +
                "des Zuges an den Spieler wurde nicht korrekt durchgeführt");

        assertEquals(true, dummy.zugZuteilung("M@rianne"), "Die " +
                "Zuteilung des Zuges an den Spieler wurde nicht korrekt durchgeführt");

    }


    @Test
    public void testAbwehr(){
        //Hier auch ähnlich zu oben. Erst später testen!!
        assertEquals(true, dummy.angriffAbwehren("Horst", 17),
                "Der Spieler ist nicht der Besitzer");

        assertEquals(true, dummy.angriffAbwehren("P3t3r", 17),
                "Der Spieler ist nicht der Besitzer");

    }

    @Test
    public void testWuerfelErgebnis(){
        //Hier auch ähnlich zu oben. Erst später testen
        int[] wuerfelv = {4, 5};
        int[] wuerfela = {3, 6};
        assertEquals(true, dummy.wuerfelErgebnis("Horst", wuerfelv,
                wuerfela, 1, 1), "Das Würfelergebnis" +
                "wurde nicht korrekt beim Client verarbeitet");
    }






}
