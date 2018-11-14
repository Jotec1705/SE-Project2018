
package Spiellogik;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der Spiellogik Schnittstelle")
class KommunikationServerISpiellogikTest  {
    public ISpiellogik logik = null;


    @BeforeAll
    public void initVorAllenTests(){
        //Ein Spiel muss angelegt werden über Spielkontrolle mit einem Menschen und dem Rest bots.


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
                "Die Benachritigung, dass der Spieler ausgestiegen ist, wurde nicht" +
                        "korrekt verarbeitet");

        assertEquals(false, logik.spielerAusgestiegen("Horst"),
                "Die Benachritigung, dass der Spieler ausgestiegen ist, wurde nicht" +
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

        //Hier muss das Spiel gestartet werden, dann das ->

        assertEquals(true, logik.erstiesAnzahlErhoehen(9, "Horst"),
                "Die Anzahl der Ersties wurde nicht korrekt erhöht, oder der Spieler ist " +
                        "nicht der Eigentümer des Gebäudes");
    }


    @Test
    public void testAngreifen(){
        //Hier muss das Spiel gestartet werden, dann das ->
        //Phase I und ersties verteilen abgeschlossen

        assertEquals(true, logik.angriffVonNach(14, 5,
                15, "P3t3r"), "Urspungsgebäude gehört nicht" +
                "dem Spieler || Zielgebäude gehört dem Spieler bereits || Nicht genung Einheiten" +
                "auf dem Ursprungsgebäude");
    }


    @Test
    public void testVersetzen(){

        //Hier muss das Spiel gestartet werden, dann das ->
        //Phase I und ersties verteilen abgeschlossen

        assertEquals(true, logik.versetzenVonNach(15, 1,
                14, "P3t3r"), "Ursprungsgebäude gehört nicht dem " +
                "Spieler || Zielgebäude gehört nicht dem Spieler || Nicht genug Einheiten auf dem " +
                "Ursprungsgebäude");

    }


    @Test
    public void testZugWeiterschaltung(){
        //Hier muss das Spiel gestartet werden, dann das ->
        //Phase I und ersties verteilen abgeschlossen

        assertEquals(true, logik.zugBeendet("Horst"), "Die Meldung," +
                "dass der Spieler seinen Zug beendet hat, wurde nicht korrekt verarbeitet");
    }

    @Test
    public void testGewürfelt(){
        //keine Vorbedingungen

        assertEquals(false, logik.gewuerfelt("M@rianne"), "Die Meldung" +
                "dass der Spieler gewürfelt hat, wurde nicht korrekt verarbeitet");
    }



}