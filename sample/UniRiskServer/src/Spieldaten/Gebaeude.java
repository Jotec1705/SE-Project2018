package Spieldaten;



public class Gebaeude {
    public final String Name;
    public final Integer ID;//ID raus und als index vom array. (Erstes Element im array bleibt null)
    public Integer anzahlErsties;
    public String Besitzer;
    //Array mit nachbargebäuden

    public Gebaeude(String Name, Integer ID, Integer anzahlErsties, String Besitzer){
        this.Name = Name;
        this.ID = ID;
        this.anzahlErsties = anzahlErsties;
        this.Besitzer = Besitzer;
    }



}
