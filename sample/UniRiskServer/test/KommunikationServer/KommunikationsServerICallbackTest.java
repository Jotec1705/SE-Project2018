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
    public GUIClientDummy dummy = null;

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

    @Test
    public void testLobbyAktualisieren(){
        assertEquals(true, dummy.aktualisierenLobby(), "Die Anfrage zum" +
                "Aktualisieren der Lobby wurde nicht korrekt verarbeitet");
    }

    @Test
    public void testKarteAktualisieren(){
        assertEquals(true, dummy.aktualisierenKarte(), "Die Anfrage zum" +
                "Aktualisieren der Karte wurde nicht korrekt verarbeitet");
    }


    @Test
    public void testZugZuteilung(){
        assertEquals(true, dummy.zugZuteilung("Horst"), "Die Zuteilung" +
                "des Zuges an den Spieler wurde nicht korrekt durchgeführt");

        assertEquals(true, dummy.zugZuteilung("M@rianne"), "Die " +
                "Zuteilung des Zuges an den Spieler wurde nicht korrekt durchgeführt");

    }


    @Test
    public void testAbwehr(){
        assertEquals(true, dummy.angriffAbwehren("Horst", 17),
                "Der Spieler ist nicht der Besitzer");

        assertEquals(true, dummy.angriffAbwehren("P3t3r", 17),
                "Der Spieler ist nicht der Besitzer");

    }

    @Test
    public void testWuerfelErgebnis(){
        int[] wuerfelv = {4, 5};
        int[] wuerfela = {3, 6};
        assertEquals(true, dummy.wuerfelErgebnis("Horst", wuerfelv,
                wuerfela, 1, 1), "Das Würfelergebnis" +
                "wurde nicht korrekt beim Client verarbeitet");
    }






}
