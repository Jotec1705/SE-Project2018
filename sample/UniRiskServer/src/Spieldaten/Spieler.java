package Spieldaten;

public class Spieler {
    public String Name;
    public String Passwort;
    public boolean bereit;
    public boolean isBot;
    public boolean hatErstiesVerteilt;

    public Spieler(String Name, String passwort,boolean bereit, boolean isBot, boolean hatErstiesVerteilt){
        this.Name = Name;
        this.Passwort = passwort;
        this.bereit = bereit;
        this.isBot = isBot;
        this.hatErstiesVerteilt = hatErstiesVerteilt;
    }

}
