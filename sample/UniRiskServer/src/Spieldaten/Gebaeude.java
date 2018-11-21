package Spieldaten;



public class Gebaeude {
    public final String Name;
    public final Integer ID;//ID raus und als index vom array. (Erstes Element im array bleibt null)
    public Integer anzahlErsties;
    public String Besitzer;
    Enum Fachbereiche;
    Integer[] hatNachbargebaeude;


    public Gebaeude(String Name, Integer ID, Integer anzahlErsties, String Besitzer, Enum Fachbereich, Integer[] hatNachbargebaeude){
        this.Name = Name;
        this.ID = ID;
        this.anzahlErsties = anzahlErsties;
        this.Besitzer = Besitzer;
        this.Fachbereiche = Fachbereich;
        this.hatNachbargebaeude = hatNachbargebaeude;
    }

    public void setAnzahlErsties(Integer anzahlErsties) {
        this.anzahlErsties = anzahlErsties;
    }

    public void setBesitzer(String besitzer) {
        Besitzer = besitzer;
    }
}
