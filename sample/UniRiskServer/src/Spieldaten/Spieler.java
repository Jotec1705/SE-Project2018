package Spieldaten;

public class Spieler {
    public String Name;
    public String Passwort;
    public boolean bereit;
    public boolean isBot;
    public boolean hatErstiesVerteilt;
    public Integer zuVerteilendeErsties;


    public Spieler(String Name, String passwort,boolean bereit, boolean isBot, boolean hatErstiesVerteilt,Integer zuVerteilendeErsties){
        this.Name = Name;
        this.Passwort = passwort;
        this.bereit = bereit;
        this.isBot = isBot;
        this.hatErstiesVerteilt = hatErstiesVerteilt;
        this.zuVerteilendeErsties = zuVerteilendeErsties;
    }

    public void setSpielerBereit() {
        bereit = true;
    }
}
