package Spieldaten;



public class Gebaeude {
    public final String Name;
    public final Integer ID;
    public Integer anzahlErsties;
    public String Besitzer;

    public Gebaeude(String Name, Integer ID, Integer anzahlErsties, String Besitzer){
        this.Name = Name;
        this.ID = ID;
        this.anzahlErsties = anzahlErsties;
        this.Besitzer = Besitzer;
    }



}
