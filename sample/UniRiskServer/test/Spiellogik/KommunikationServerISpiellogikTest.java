/*Ich habe bewusst nur die Tests implementiert, die hier zu sehen sind. Die restlichen Methoden der Schnittstelle
* entsprechen nur irgendwelchen Meldungen*/
package Spiellogik;

import Spiellogik.ISpiellogik;
import Spieldaten.ISpieldaten;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der Spiellogik Schnittstelle")
class KommunikationServerISpiellogikTest  {
    public ISpiellogik logik = null;
    public ISpieldaten daten = null;


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
     * Dieser Test soll überprüfen, ob die Anzahl der Ersties korrekt erhöht wird, sobald von Oben die Anweisung
     * durch klicken auf ein Gebäude dazu kommt. Das korrekte Hochzählen wird fünfmal geprüft. Zudem soll geprüft
     * werden, dass es nicht möglich ist, die Anzahl auf Gebäuden zu erhöhen, die einem nicht gehören.
     */
    @Test
    public void testErstiesHochzaehlen(){
        System.out.println("[ErstiesHochzaehlen] Läuft..");

        Integer anzahl = 0;
        Integer compare = 0;

        for(int j = 0; j < 5; j++) {
            anzahl = daten.anzahlErstiesGebaeude(3);
            assertEquals(true, logik.erstiesAnzahlErhoehen(3, "Horst"), "Erhöhen" +
                                                            "nicht erlaubt, da Horst nicht der Besitzer von Gebäude 3");
            compare = anzahl + 1;
            assertEquals(compare, daten.anzahlErstiesGebaeude(3), "Anzahl der Ersties wurde nicht erhöht!");
        }


    }

    /**
     * Dieser Test überprüft zunächst, ob die Spiellogik korrekte Angriffsanfragen zulässt und prüft danach, ob
     * inkorrekte Angriffsanfragen (auf unterschiedliche Weise inkorrekt) abgewiesen werden.
     */
    @Test
    public void testAngreifen(){
        System.out.println("[Angreifen] Läuft..");

        assertEquals(true, logik.angriffVonNach(3, 5, 1,
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
                "(Das Zielgebäude gehört bereits dem Spieler");
    }

    /**
     * Dieser Test überprüft zunächst, ob die Spiellogik korrekte Versetzungsanfragen zulässt und prüft danach, ob
     * inkorrekte Versetzungsanfragen (auf unterschiedliche Weise inkorrekt) abgewiesen werden.
     */
    @Test
    public void testVersetzen(){
        System.out.println("[Versetzen] Läuft..");

        assertEquals(true, logik.versetzenVonNach(3, 5, 1,
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
                "(Das Zielgebäude gehört nicht dem Spieler");
    }

    /**
     * Dieser Test überprüft, ob nachdem Beenden seines Zuges, die Zugzuteilung auf den nächsten Spieler übergeht.
     */
    @Test
    public void testZugWeiterschaltung(){
        System.out.println("[ZugWeiterschaltung] Läuft..");

        logik.zugBeendet("Horst");
        assertEquals("P3t3r", daten.aktuellerSpieler(), "Der Zug ist entweder immer noch bei Horst," +
                "oder der Zug wurde einem Spieler zugeteil, der nicht an der Reihe ist.");
    }



}