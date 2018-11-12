package GUIServer;

import Spieldaten.IAnzeigedaten;
import Spiellogik.ISpielkontrolle;
import org.junit.jupiter.api.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

class GUIServerTest implements IGUIServerCallback{
    public boolean aktualisiert = false;

    @Override
    public boolean aktualisierung() {
        aktualisiert = true;
        return true;
    }
}