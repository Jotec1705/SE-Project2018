package GUIServer;

import Spieldaten.IAnzeigedaten;
import Spiellogik.ISpielkontrolle;
import org.junit.jupiter.api.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

class GUIServerTest {
    String spielerNamen[];
    String ipAdressen[];
    boolean spielerBereit[];
    IAnzeigedaten anzeige = null;

}