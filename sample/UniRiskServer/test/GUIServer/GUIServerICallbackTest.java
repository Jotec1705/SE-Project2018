package GUIServer;

import Spieldaten.IAnzeigedaten;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der Callbackschnittstelle Schnittstelle")
class GUIServerICallbackTest {

    IGUIServerCallback callback = null;
    GUIServerTest gui = null;
    IAnzeigedaten anzeige = null;

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
     * Dieser Test überprüft ob die GUIServer richtig aktualisiert wird
     */
    @Test
    public void aktualisierungTest(){
        System.out.println("[Aktualisierung] läuft");

        assertEquals(true, callback.aktualisierung(), "Aktualisierung nicht erfolgreich");
        assertEquals(true, gui.spielerNamen == anzeige.spielerNamen(), "Spielernamen nicht korrekt aktualisiert");
        assertEquals(true, gui.spielerBereit == anzeige.spielerBereit(), "Spieler bereit nicht korrekt aktualisiert");
        assertEquals(true, gui.ipAdressen == anzeige.ipAdressen(), "Spieler IP-Adressen nicht korrekt aktualisiert");

    }

}