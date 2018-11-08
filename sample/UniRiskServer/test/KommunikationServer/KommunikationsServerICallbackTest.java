/*Ehrlich gesagt wüsste ich nicht was bei den Methoden dieser Schnittstelle testen könnte. Alle Methoden
* geben nur Information weiter. Ich kann natürlich einen Test für erfolgreich, nicht erfoglreich schreiben, aber ich
* glaube dass sollten wir ja nicht machen. Könnte mir höchstens vorstellen, dass ich den GUIClient als Dummy baue
* um Daten zu überprüfen. Also habe ich das exemplarisch mal für zwei der Methoden gemacht. Weiß aber nicht ob
* das so sinnvoll ist.*/

package KommunikationServer;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der Callback Schnittstelle")
public class KommunikationsServerICallbackTest {

    public IKommunikationServerCallback callback = null;
    public GUIClient client = null;

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
     * Dieser Test hat die funktion zu testen, ob bei GUIClient (Hier durch eine Dummy-Klasse repräsentiert)
     * tatsächlich einem neuen Spieler der Zug zugeteilt wurde.
     */
    @Test
    public void testZugZuteilung(){
        System.out.println("[ZugZuteilung] Läuft..");

        callback.zugZuteilung("Horst");

        assertEquals("Horst", client.aktuellerSpieler, "Der nächste Spieler wurde nicht korrekt" +
                "ausgewählt.");

    }

    /**
     * Dieser Test hat die funktion zu testen, ob bei GUIClient (Hier durch eine Dummy-Klasse repräsentiert)
     * tatsächlich der Richtige Spieler für das richtige Gebäude zur Verteidigung ausgewählt wurde.
     */
    @Test
    public void testAbwehrAuswahl(){
        System.out.println("[AbwehrAuswahl] Läuft..");

        callback.angriffAbwehren("M@rianne", 8);

        assertEquals("M@rianne", client.nameVerteidiger, "Es wurde nicht der korrekte Spieler zur " +
                "Verteidigung ausgewählt");
        assertEquals(java.util.Optional.of(8), client.gebaeudeIdVerteidiger, "Es wurde nicht das korrekte Gebäude " +
                "zur Verteidigung ausgewählt");
    }




}
