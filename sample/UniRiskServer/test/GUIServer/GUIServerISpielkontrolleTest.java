package GUIServer;

import Spieldaten.IAnzeigedaten;
import Spieldaten.Zustand;
import Spiellogik.ISpielkontrolle;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


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
     * Dieser Test überprüft ob ein Spiel mit 3 Spielern erfolgreich angelegt wird
     */
    @Test
    public void spielAnlegenTestSpielerAnzahlDrei(){
        System.out.println("[SpielAnlegen] läuft");


        assertEquals(true, kontrolle.spielAnlegen(3), "Spiel wurde nicht angelegt");
        assertEquals(Zustand.Initial, anzeige.aktuellePhase(), "Spiel hat nicht den Zustand Initial");
        assertEquals(3, anzeige.spielerNamen().length, "Spieleranzahl nicht 3");
    }

    /**
     * Dieser Test überprüft ob ein Spiel mit 4 Spielern erfolgreich angelegt wird
     */
    @Test
    public void spielAnlegenTestSpielerAnzahlVier(){
        System.out.println("[SpielAnlegen] läuft");


        assertEquals(true, kontrolle.spielAnlegen(4), "Spiel wurde nicht angelegt");
        assertEquals(Zustand.Initial, anzeige.aktuellePhase(), "Spiel hat nicht den Zustand Initial");
        assertEquals(4, anzeige.spielerNamen().length, "Spieleranzahl nicht 4");
    }

    /**
     * Dieser Test überprüft ob ein Spiel mit 5 Spielern erfolgreich angelegt wird
     */
    @Test
    public void spielAnlegenTestSpielerAnzahlFünf(){
        System.out.println("[SpielAnlegen] läuft");


        assertEquals(true, kontrolle.spielAnlegen(5), "Spiel wurde nicht angelegt");
        assertEquals(Zustand.Initial, anzeige.aktuellePhase(), "Spiel hat nicht den Zustand Initial");
        assertEquals(5, anzeige.spielerNamen().length, "Spieleranzahl nicht 5");
    }

    /**
     *Dieser Test überprüft ob ein neu angelegtes Spiel ordnugsgemäß startet
     */
    @Test
    public void spielStartenTestNeuesSpiel(){
        System.out.println("[SpielStarten] läuft");

        kontrolle.spielAnlegen(5);
        //Hier muss sich mindestens ein Spieler anmelden bzw. ein DummySpieler in den Spieldaten eingetragen sein
        //danach wird das Spiel mit dem DummySpieler und vier Bots gestartet

        assertEquals(true, kontrolle.spielStarten(), "Spiel wurde nicht gestartet");
        assertEquals(Zustand.ErstiesVerteilen, anzeige.aktuellePhase(), "Spiel hat nicht den Zustand ErstiesVerteilen");

        String spielerNamen[] = anzeige.spielerNamen();

        for(int i = 0; i < spielerNamen.length;i++){
            assertEquals(false, spielerNamen[i].isEmpty(),"Spielwurde nicht ordnungsgemäß gestartet, Spieleranzahl nicht erfüllt");
        }

    }

    /**
     * Dieser Test soll überprüfen ob das Spiel beendet wird.
     */
    @Test
    public void spielBeendenTest(){
        System.out.println("[SpielBeenden] läuft");

        kontrolle.spielAnlegen(5);
        //Hier muss sich mindestens ein Spieler anmelden bzw. ein DummySpieler in den Spieldaten eingetragen sein
        //danach wird das Spiel mit dem DummySpieler und vier Bots gestartet
        kontrolle.spielStarten();

        assertEquals(true, kontrolle.spielBeenden(), "Spiel wurde nicht beendet");
        assertEquals(null, anzeige.aktuellePhase(), "Es wurde nicht null zurückgegeben. Spiel wurde nicht erfolgeich beendet");
    }

    /**
     * Dieser Test überprüft ob ein Spiel gespeichert wird und eine Speicherdatei angelegt wird
     */
    @Test
    public void spielSpeichernTest(){
        System.out.println("[SpielSpeichern] läuft");

        kontrolle.spielAnlegen(5);
        //Hier muss sich mindestens ein Spieler anmelden bzw. ein DummySpieler in den Spieldaten eingetragen sein
        //danach wird das Spiel mit dem DummySpieler und vier Bots gestartet
        kontrolle.spielStarten();

        assertEquals(true, kontrolle.spielSpeichern("../GUIServer/gespeichertesSpiel.save"), "Spiel wurde nicht gespeichert");
        assertEquals(true, new File("gespeichertesSpiel.save").exists(), "Datei wurde nicht im Verzeichnis erstellt");
    }


    /**
     * Dieser Test überprüft ob ein Spiel geladen wird
     */
    @Test
    public void spielLadenTest(){
        System.out.println("[SpielLaden] läuft");

        kontrolle.spielAnlegen(5);
        //Hier muss sich mindestens ein Spieler anmelden bzw. ein DummySpieler in den Spieldaten eingetragen sein
        //danach wird das Spiel mit dem DummySpieler und vier Bots gestartet
        kontrolle.spielStarten();
        kontrolle.spielSpeichern("../GUIServer/gespeichertesSpiel.save");

        kontrolle.spielBeenden();

        assertEquals(true, kontrolle.spielLaden("../GUIServer/gespeichertesSpiel.save"), "Spiel wurde nicht geladen");
        assertNotEquals(Zustand.Initial, anzeige.aktuellePhase(), "Spiel hat den fehlerhaften Zustand Initial");
        assertNotEquals(Zustand.Beendet, anzeige.aktuellePhase(), "Spiel hat den fehlerhaften Zustand Beendet");

        String spielerNamen[] = anzeige.spielerNamen();

        for(int i = 0; i < spielerNamen.length;i++){
            assertEquals(false, spielerNamen[i].isEmpty(),"Spiel wurde nicht ordnungsgemäß geladen Spielernamen dürfen nicht leer sein");
        }

    }

    /**
     *Dieser Test überprüft ob ein geladenes Spiel gestartet wirdwd
     */
    @Test
    public void spielStartenTestGeladenesSpiel(){
        System.out.println("[SpielStarten] läuft");

        kontrolle.spielAnlegen(5);
        //Hier muss sich mindestens ein Spieler anmelden bzw. ein DummySpieler in den Spieldaten eingetragen sein
        //danach wird das Spiel mit dem DummySpieler und vier Bots gestartet
        kontrolle.spielStarten();
        kontrolle.spielSpeichern("../GUIServer/gespeichertesSpiel.save");
        kontrolle.spielBeenden();
        kontrolle.spielLaden("../GUIServer/gespeichertesSpiel.save");

        assertEquals(true, kontrolle.spielStarten(), "Spiel wurde nicht gestartet");
        assertEquals(Zustand.ErstiesVerteilen, anzeige.aktuellePhase(), "Spiel hat nicht den Zustand ErstiesVerteilen");

        String spielerNamen[] = anzeige.spielerNamen();

        for(int i = 0; i < spielerNamen.length;i++){
            assertEquals(false, spielerNamen[i].isEmpty(),"Spielwurde nicht ordnungsgemäß gestartet, Spieleranzahl nicht erfüllt");
        }

        boolean spielerBereit[] = anzeige.spielerBereit();

        for(int i = 0; i < spielerBereit.length;i++){
            assertEquals(true, spielerBereit[i],"Spielwurde nicht ordnungsgemäß gestartet, nicht alle benötigten Spieler Online bei Start");
        }
    }


}