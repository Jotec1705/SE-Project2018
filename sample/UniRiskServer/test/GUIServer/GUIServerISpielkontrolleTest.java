package GUIServer;

import Spieldaten.IAnzeigedaten;
import Spiellogik.ISpielkontrolle;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der ISpielkontrolle Schnittstelle")
class GUIServerISpielkontrolleTest {
    public ISpielkontrolle kontrolle = null;
    public IAnzeigedaten anzeige = null;

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
     * Dieser Test soll überprüfen ob das Spiel beendet wird.
     */
    @Test
    public void spielBeendenTest(){
        System.out.println("[SpielBeenden] läuft");

        assertEquals(true, kontrolle.spielBeenden(), "Spiel wurde nicht beendet");
        assertEquals(null, anzeige.aktuellePhase(), "Es wurde nicht null zurückgegeben. Spiel wurde nicht erfolgeich beendet");
    }

    @Test
    public void spielSpeichernTest(){
        System.out.println("[SpielSpeichern] läuft");

        assertEquals(true, kontrolle.spielSpeichern("../GUIServer/gespeichertesSpiel.save"), "Spiel wurde nicht gespeichert");
        assertEquals(true, new File("gespeichertesSpiel.save").exists(), "Datei wurde nicht im erstellt");
    }

    @Test
    public void spielAnlegenTest(){
        System.out.println("[SpielAnlegen] läuft");

    }

    @Test
    public void spielLadenTest(){
        System.out.println("[SpielLaden] läuft");

    }

    @Test
    public void spielStartenTest(){
        System.out.println("[SpielStarten] läuft");

    }


}