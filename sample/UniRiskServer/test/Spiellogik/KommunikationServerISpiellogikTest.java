
package Spiellogik;


import Spieldaten.ISpieldaten;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der Spiellogik Schnittstelle")
class KommunikationServerISpiellogikTest  {
    public ISpiellogik logik = null;
    public ISpielkontrolle kontrolle = null;
    public ISpieldaten daten = null;


    @BeforeAll
    public void initVorAllenTests(){
        //Ein Spiel muss angelegt werden über Spielkontrolle mit einem Menschen und dem Rest bots.
        //Folgende Spielerreihenfolge muss gegeben sein nach Anlegen ["Horst", "Piet", "P3t3r", "M@rianne"]
        kontrolle.spielAnlegen(4);
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
    public void testSpielerAnmelden(){
        assertEquals(true, logik.spielerAnmelden("Horst", "blutwurst1"),
                "Der Spieler (Name-Pw Paar) wurde nicht angelegt");
    }

    @Test
    public void testSpielerAusgestiegen(){
        logik.spielerAnmelden("Piet", "blutwurst1");
        assertEquals(true, logik.spielerAusgestiegen("Piet"),
                "Die Benachrichtigung, dass der Spieler ausgestiegen ist, wurde nicht" +
                        "korrekt verarbeitet");

        assertEquals(false, logik.spielerAusgestiegen("Horst"),
                "Die Benachrichtigung, dass der Spieler ausgestiegen ist, wurde nicht" +
                        "korrekt verarbeitet");
    }

    @Test
    public void testSpielerBereitMelden(){
        logik.spielerAnmelden("Horst", "blutwurst1");
        assertEquals(true, logik.spielerBereitMelden("Horst"),
                "Die Benachrichtigung, dass der Spieler Bereit ist, wurde nicht" +
                        "korrekt verarbeitet");
        assertEquals(false, logik.spielerBereitMelden("Piet"),
                "Die Benachrichtigung, dass der Spieler Bereit ist, wurde nicht" +
                        "korrekt verarbeitet");
    }


    @Test
    public void testErstiesHochzaehlen(){
        kontrolle.spielStarten();
        //Hier muss das Spiel gestartet werden, dann das ->
        assertEquals(true, logik.erstiesAnzahlErhoehen(9, "Horst"),
                "Die Anzahl der Ersties wurde nicht korrekt erhöht, oder der Spieler ist " +
                        "nicht der Eigentümer des Gebäudes");
    }


    @Test
    public void testAngreifen(){
        kontrolle.spielStarten();
        assertTrue(logik.erstiesAnzahlErhoehen(3, "Horst"));
        assertTrue(logik.erstiesAnzahlErhoehen(4, "Horst"));
        assertTrue(daten.aktuellePhaseSetzen("PhaseII"));
        //Hier muss das Spiel gestartet werden, dann das ->
        //Phase I und ersties verteilen abgeschlossen

        assertEquals(true, logik.angriffVonNach(14, 5,
                15, "P3t3r"), "Urspungsgebäude gehört nicht" +
                "dem Spieler || Zielgebäude gehört dem Spieler bereits || Nicht genung Einheiten" +
                "auf dem Ursprungsgebäude");
    }


    @Test
    public void testVersetzen(){
        kontrolle.spielStarten();
        assertTrue(logik.erstiesAnzahlErhoehen(3, "Horst"));
        assertTrue(logik.erstiesAnzahlErhoehen(4, "Horst"));
        assertTrue(daten.aktuellePhaseSetzen("PhaseIII"));
        //Hier muss das Spiel gestartet werden, dann das ->
        //Phase I und ersties verteilen abgeschlossen

        assertEquals(true, logik.versetzenVonNach(15, 1,
                14, "P3t3r"), "Ursprungsgebäude gehört nicht dem " +
                "Spieler || Zielgebäude gehört nicht dem Spieler || Nicht genug Einheiten auf dem " +
                "Ursprungsgebäude");

    }


    @Test
    public void testZugWeiterschaltung(){
        kontrolle.spielStarten();
        assertTrue(logik.erstiesAnzahlErhoehen(3, "Horst"));
        assertTrue(logik.erstiesAnzahlErhoehen(4, "Horst"));
        //Hier muss das Spiel gestartet werden, dann das ->
        //Phase I und ersties verteilen abgeschlossen
        assertEquals(true, logik.zugBeendet("Horst"), "Die Meldung," +
                "dass der Spieler seinen Zug beendet hat, wurde nicht korrekt verarbeitet");
        assertEquals("Piet", daten.aktuellerSpieler());
    }

    @Test
    public void testGewürfelt(){
        //keine Vorbedingungen
        //Für den True fall muss sich nochmal was überlegt werden. Der ist nicht ganz ohne.
        assertEquals(false, logik.gewuerfelt("M@rianne"), "Die Meldung" +
                "dass der Spieler gewürfelt hat, wurde nicht korrekt verarbeitet");
    }



}