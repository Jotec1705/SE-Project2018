/*Ich habe bewusst nur die Tests implementiert, die hier zu sehen sind. Die restlichen Methoden der Schnittstelle
* entsprechen nur irgendwelchen Meldungen*/
package Spiellogik;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der Spiellogik Schnittstelle")
class KommunikationServerISpiellogikTest  {
    public SpiellogikSpieldatenDummy dummy = null;


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
    public void testSpielerAnmelden(){
        assertEquals(true, dummy.spielerAnmelden("Horst", "blutwurst1"),
                "Der Spieler (Name-Pw Paar) wurde nicht angelegt");
    }

    @Test
    public void testSpielerAusgestiegen(){
        assertEquals(true, dummy.spielerAusgestiegen("Piet"),
                "Die Benachritigung, dass der Spieler ausgestiegen ist, wurde nicht" +
                        "korrekt verarbeitet");
    }

    @Test
    public void testSpielerBereitMelden(){
        assertEquals(true, dummy.spielerBereitMelden("Horst"),
                "Die Benachrichtigung, dass der Spieler Bereit ist, wurde nicht" +
                        "korrekt verarbeitet");
    }


    @Test
    public void testErstiesHochzaehlen(){
        /*Integer anzahl = 0;
        Integer compare = 0;

        for(int j = 0; j < 5; j++) {
            anzahl = daten.anzahlErstiesGebaeude(3);
            assertEquals(true, logik.erstiesAnzahlErhoehen(3, "Horst"), "Erhöhen" +
                                                            "nicht erlaubt, da Horst nicht der Besitzer von Gebäude 3");
            compare = anzahl + 1;
            assertEquals(compare, daten.anzahlErstiesGebaeude(3), "Anzahl der Ersties wurde nicht erhöht!");
        }*/

        assertEquals(true, dummy.erstiesAnzahlErhoehen(9, "Horst"),
                "Die Anzahl der Ersties wurde nicht korrekt erhöht, oder der Spieler ist " +
                        "nicht der Eigentümer des Gebäudes");
    }


    @Test
    public void testAngreifen(){
        /*assertEquals(true, logik.angriffVonNach(3, 5, 1,
                "Horst"), "Es wurde nicht erkannt, dass der Angriff zulässig ist");
        assertEquals(true, logik.angriffVonNach(16, 2, 22,
                "Horst"), "Es wurde nicht erkannt, dass der Angriff zulässig ist");
        assertEquals(true, logik.angriffVonNach(33, 3, 31,
                "Horst"), "Es wurde nicht erkannt, dass der Angriff zulässig ist");

        assertEquals(false, logik.angriffVonNach(7, 5, 4,
                "Horst"), "Es wurde nicht erkannt, dass der Angriff nicht zulässig ist" +
                "(Zielgebäude ist kein Nachbargebäude vom Ursprungsgebäude)");
        assertEquals(false, logik.angriffVonNach(15, 2, 12,
                "Horst"), "Es wurde nicht erkannt, dass der Angriff nicht zulässig ist" +
                "(Das Ursprungsgebäude gehört nicht dem Spieler");
        assertEquals(false, logik.angriffVonNach(17, 3, 18,
                "Horst"), "Es wurde nicht erkannt, dass der Angriff nicht zulässig ist" +
                "(Das Zielgebäude gehört bereits dem Spieler");*/

        assertEquals(true, dummy.angriffVonNach(14, 5,
                15, "P3t3r"), "Urspungsgebäude gehört nicht" +
                "dem Spieler || Zielgebäude gehört dem Spieler bereits || Nicht genung Einheiten" +
                "auf dem Ursprungsgebäude");
    }


    @Test
    public void testVersetzen(){

        /*assertEquals(true, logik.versetzenVonNach(3, 5, 1,
                "Horst"), "Es wurde nicht erkannt, dass das Versetzen zulässig ist");
        assertEquals(true, logik.versetzenVonNach(16, 2, 22,
                "Horst"), "Es wurde nicht erkannt, dass das Versetzen zulässig ist");
        assertEquals(true, logik.versetzenVonNach(33, 3, 31,
                "Horst"), "Es wurde nicht erkannt, dass das Versetzen zulässig ist");

        assertEquals(false, logik.versetzenVonNach(7, 5, 4,
                "Horst"), "Es wurde nicht erkannt, dass das Versetzen nicht zulässig ist" +
                "(Zielgebäude ist kein Nachbargebäude vom Ursprungsgebäude)");
        assertEquals(false, logik.versetzenVonNach(15, 2, 12,
                "Horst"), "Es wurde nicht erkannt, dass das Versetzen nicht zulässig ist" +
                "(Das Ursprungsgebäude gehört nicht dem Spieler");
        assertEquals(false, logik.versetzenVonNach(17, 3, 18,
                "Horst"), "Es wurde nicht erkannt, dass das Versetzen nicht zulässig ist" +
                "(Das Zielgebäude gehört nicht dem Spieler");*/

        assertEquals(true, dummy.versetzenVonNach(15, 1,
                14, "P3t3r"), "Ursprungsgebäude gehört nicht dem " +
                "Spieler || Zielgebäude gehört nicht dem Spieler || Nicht genug Einheiten auf dem " +
                "Ursprungsgebäude");

    }


    @Test
    public void testZugWeiterschaltung(){
        /*logik.zugBeendet("Horst");
        assertEquals("P3t3r", daten.aktuellerSpieler(), "Der Zug ist entweder immer noch bei Horst," +
                "oder der Zug wurde einem Spieler zugeteil, der nicht an der Reihe ist.");*/

        assertEquals(true, dummy.zugBeendet("Horst"), "Die Meldung," +
                "dass der Spieler seinen Zug beendet hat, wurde nicht korrekt verarbeitet");
    }

    @Test
    public void testGewürfelt(){
        assertEquals(true, dummy.gewuerfelt("M@rianne"), "Die Meldung" +
                "dass der Spieler gewürfelt hat, wurde nicht korrekt verarbeitet");
    }



}