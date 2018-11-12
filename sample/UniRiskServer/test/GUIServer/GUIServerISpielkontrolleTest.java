package GUIServer;

import Spieldaten.IAnzeigedaten;
import Spieldaten.Zustand;
import Spiellogik.ISpielkontrolle;
import Spiellogik.ISpiellogik;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der ISpielkontrolle Schnittstelle")
class GUIServerISpielkontrolleTest {
    public ISpielkontrolle kontrolle = null;
    public IAnzeigedaten anzeige = null;
    public ISpiellogik logik = null;

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
     * Dieser Test überprüft ob ein Spiel mit 3 Spielern erfolgreich angelegt wird
     */
    @Test
    public void spielAnlegenTestSpielerAnzahlDrei(){



        assertEquals(true, kontrolle.spielAnlegen(3), "Spiel wurde nicht angelegt");
        assertEquals(Zustand.Initial, anzeige.aktuellePhase(), "Spiel hat nicht den Zustand Initial");
        assertEquals(3, anzeige.spielerNamen().length, "Spieleranzahl nicht 3");
    }

    /**
     * Dieser Test überprüft ob ein Spiel mit 4 Spielern erfolgreich angelegt wird
     */
    @Test
    public void spielAnlegenTestSpielerAnzahlVier(){



        assertEquals(true, kontrolle.spielAnlegen(4), "Spiel wurde nicht angelegt");
        assertEquals(Zustand.Initial, anzeige.aktuellePhase(), "Spiel hat nicht den Zustand Initial");
        assertEquals(4, anzeige.spielerNamen().length, "Spieleranzahl nicht 4");
    }

    /**
     * Dieser Test überprüft ob ein Spiel mit 5 Spielern erfolgreich angelegt wird
     */
    @Test
    public void spielAnlegenTestSpielerAnzahlFünf(){



        assertEquals(true, kontrolle.spielAnlegen(5), "Spiel wurde nicht angelegt");
        assertEquals(Zustand.Initial, anzeige.aktuellePhase(), "Spiel hat nicht den Zustand Initial");
        assertEquals(5, anzeige.spielerNamen().length, "Spieleranzahl nicht 5");
    }

    /**
     *Dieser Test überprüft ob ein neu angelegtes Spiel ordnugsgemäß startet
     */
    @Test
    public void spielStartenTestNeuesSpiel(){
        //Erst zu testen wenn die Komponenten Spiellogik und Spieldaten mit den angebotenen Schnittstellen Vollständig implementiert und erfolgreich getestet wurden


        assertTrue(kontrolle.spielAnlegen(5), "Spiel wurde nicht angelegt");

        //Hier wird ein Spieler über die Schnittstelle ISpiellogik angemeldet.
        assertTrue(logik.spielerAnmelden("Hans", "ABCD1234"),"Spieler konnte nicht angemeldet werden");
        //Hier muss der Spieler Bereit gemeldet werden, um den eigentlichen Test "spielStarten" durchführen zu können
        assertTrue(logik.spielerBereitMelden("Hans"), "Spieler konnte nicht bereit gemeldet werden");

        assertEquals(true, kontrolle.spielStarten(), "Spiel wurde nicht gestartet");
        assertEquals(Zustand.ErstiesVerteilen, anzeige.aktuellePhase(), "Spiel hat nicht den Zustand ErstiesVerteilen");

        String spielerNamen[] = anzeige.spielerNamen();

        for(int i = 0; i < spielerNamen.length;i++){
            assertEquals(false, spielerNamen[i].isEmpty(),"Spielwurde nicht ordnungsgemäß gestartet, Spieleranzahl nicht aufgefüllt");
        }

    }

    /**
     * Dieser Test soll überprüfen ob das Spiel beendet wird.
     */
    @Test
    public void spielBeendenTest(){
        //Erst zu testen wenn die Komponenten Spiellogik und Spieldaten mit den angebotenen Schnittstellen Vollständig implementiert und erfolgreich getestet wurden

        assertTrue(kontrolle.spielAnlegen(5), "Spiel wurde nicht angelegt");
        //Hier wird ein Spieler über die Schnittstelle ISpiellogik angemeldet.
        assertTrue(logik.spielerAnmelden("Hans", "ABCD1234"),"Spieler konnte nicht angemeldet werden");
        //Hier muss der Spieler Bereit gemeldet werden, um den eigentlichen Test "spielStarten" durchführen zu können
        assertTrue(logik.spielerBereitMelden("Hans"), "Spieler konnte nicht bereit gemeldet werden");
        assertTrue(kontrolle.spielStarten(), "Spiel wurde nicht gestartet");

        assertEquals(true, kontrolle.spielBeenden(), "Spiel wurde nicht beendet");
        assertEquals(null, anzeige.aktuellePhase(), "Es wurde nicht null zurückgegeben. Spiel wurde nicht erfolgeich beendet");
    }

    /**
     * Dieser Test überprüft ob ein Spiel gespeichert wird und eine Speicherdatei angelegt wird
     */
    @Test
    public void spielSpeichernTest(){
        //Erst zu testen wenn die Komponenten Spiellogik und Spieldaten mit den angebotenen Schnittstellen Vollständig implementiert und erfolgreich getestet wurden

        assertTrue(kontrolle.spielAnlegen(5), "Spiel wurde nicht angelegt");
        //Hier wird ein Spieler über die Schnittstelle ISpiellogik angemeldet.
        assertTrue(logik.spielerAnmelden("Hans", "ABCD1234"),"Spieler konnte nicht angemeldet werden");
        //Hier muss der Spieler Bereit gemeldet werden, um den eigentlichen Test "spielStarten" durchführen zu können
        assertTrue(logik.spielerBereitMelden("Hans"), "Spieler konnte nicht bereit gemeldet werden");
        assertTrue(kontrolle.spielStarten(), "Spiel wurde nicht gestartet");

        assertEquals(true, kontrolle.spielSpeichern("../GUIServer/gespeichertesSpiel.save"), "Spiel wurde nicht gespeichert");
        assertEquals(true, new File("gespeichertesSpiel.save").exists(), "Datei wurde nicht im Verzeichnis erstellt");
    }


    /**
     * Dieser Test überprüft ob ein Spiel geladen wird
     */
    @Test
    public void spielLadenTest(){
        //Erst zu testen wenn die Komponenten Spiellogik und Spieldaten mit den angebotenen Schnittstellen Vollständig implementiert und erfolgreich getestet wurden

        assertTrue(kontrolle.spielAnlegen(5), "Spiel wurde nicht angelegt");
        //Hier wird ein Spieler über die Schnittstelle ISpiellogik angemeldet.
        assertTrue(logik.spielerAnmelden("Hans", "ABCD1234"),"Spieler konnte nicht angemeldet werden");
        //Hier muss der Spieler Bereit gemeldet werden, um den eigentlichen Test "spielStarten" durchführen zu können
        assertTrue(logik.spielerBereitMelden("Hans"), "Spieler konnte nicht bereit gemeldet werden");
        assertTrue(kontrolle.spielStarten(), "Spiel wurde nicht gestartet");
        assertTrue(kontrolle.spielSpeichern("../GUIServer/gespeichertesSpiel.save"), "Spiel wurde nicht gespeichert");

        assertTrue(kontrolle.spielBeenden(), "Spiel wurde nicht beendet");

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
        //Erst zu testen wenn die Komponenten Spiellogik und Spieldaten mit den angebotenen Schnittstellen Vollständig implementiert und erfolgreich getestet wurden

        assertTrue(kontrolle.spielAnlegen(5), "Spiel wurde nicht angelegt");
        //Hier wird ein Spieler über die Schnittstelle ISpiellogik angemeldet.
        assertTrue(logik.spielerAnmelden("Hans", "ABCD1234"),"Spieler konnte nicht angemeldet werden");
        //Hier muss der Spieler Bereit gemeldet werden, um den eigentlichen Test "spielStarten" durchführen zu können
        assertTrue(logik.spielerBereitMelden("Hans"), "Spieler konnte nicht bereit gemeldet werden");
        assertTrue(kontrolle.spielStarten(), "Spiel wurde nicht gestartet");
        assertTrue(kontrolle.spielSpeichern("../GUIServer/gespeichertesSpiel.save"), "Spiel wurde nicht gespeichert");

        assertTrue(kontrolle.spielBeenden(), "Spiel wurde nicht beendet");
        assertTrue(kontrolle.spielLaden("../GUIServer/gespeichertesSpiel.save"), "Spiel wurde nicht geladen");

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