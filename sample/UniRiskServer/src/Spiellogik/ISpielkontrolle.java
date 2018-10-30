package Spiellogik;

public interface ISpielkontrolle {
    boolean Spielanlegen(int Spieler);
    boolean Spielladen(String Dateiname);
    void Spielstarten();
    boolean Spielbeenden();
    boolean Spielspeichern(String Dateiname);
}
