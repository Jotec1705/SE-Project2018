package GUIServer;

import Spiellogik.ISpielkontrolle;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der Callbackschnittstelle Schnittstelle")
class GUIServerICallbackTest {

    GUIServerTest gui = new GUIServerTest();
    ISpielkontrolle spielkontrolle = null;

    @BeforeAll
    public void initVorAllenTests(){

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

    /**
     * Dieser Test überprüft ob die GUIServer richtig aktualisiert wird
     */
    @Test
    public void aktualisierungTest(){

        gui.aktualisiert = false;
        assertEquals(true, spielkontrolle.spielLaden("../GUIServer/gespeichertesSpiel.save"), "Datei konnte nicht geladen werden");
        assertEquals(true, gui.aktualisiert, "Aktualisierung nicht erfolgreich");

    }

}