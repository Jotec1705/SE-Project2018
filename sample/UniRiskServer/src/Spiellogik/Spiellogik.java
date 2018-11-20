package Spiellogik;

import GUIServer.IGUIServerCallback;
import KommunikationServer.IKommunikationServerCallback;
import Spieldaten.*;

public class Spiellogik implements ISpiellogik, ISpielkontrolle{


    ISpieldaten daten = null;

    public void setSpieldaten(ISpieldaten daten){
        this.daten = daten;
    }


    boolean istSpielGeladen(){
        return true;
    }

    boolean alleSpielerBereit(){ boolean [] spielerBereit;
       spielerBereit = daten.spielerBereit();
       for(boolean b : spielerBereit) if(!b) return false;
            return true;
    }

//    boolean erstiesSetzen(String [] nameSpieler){
//        for(int i = 0; i < nameSpieler.length; i ++){
//            erstiesAnzahlErhoehen(2, nameSpieler[i]);
//        }
//        return daten.spielZustandSetzen(Zustand.ErstiesVerteilen);
//    }

    boolean phase1Verstaerken(String nameSpieler){
        Integer neueErsties = 0;

        neueErsties /= 3;
        if(neueErsties < 3) {
            neueErsties = 3;
        }

        if(daten.anzahlFachbereicheSpieler(nameSpieler) > 0){
            // switch case welche SFB und dann auf neueErsties addieren
        }

        // if Karteneintauschen

        // setzenErsties

        //Missionskarte erfüllt
            // Sieg
            // Phase 2

        return false;
    }

    boolean phase2Angriff(){

        return false;
    }

    boolean phase3Verschieben(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler){

        //if Verschieben

        if(versetzenVonNach(gebaeudeUrsprung, anzahlUrsprung, gebaeudeZiel, nameSpieler)){

            //Missionskarte erfüllt
            // Sieg
        }

        //Phase 3 beendet
        //Nächster Spieler

        return false;
    }

    boolean vergleicheNameSpieler(Integer gebaeudeUrsprung, Integer gebaeudeZiel, String nameSpieler){
        return (daten.besitzerGebaeude(gebaeudeUrsprung).equals(nameSpieler) && daten.besitzerGebaeude(gebaeudeZiel).equals(nameSpieler));
    }

    boolean istNachbargebaeude(Integer gebaeudeUrsprung, Integer gebaeudeZiel){
        Integer [] nachbarUrsprung = daten.nachbarGebaeude(gebaeudeUrsprung);
        for(int i = 0; i < nachbarUrsprung.length; i++){
            if(nachbarUrsprung[i].equals(gebaeudeZiel))
                return true;
        }
        return false;
    }

    boolean mindEinErstieGebaeude(Integer gebaeude, Integer anzahlErsties){
        return (daten.anzahlErstiesGebaeude(gebaeude) - anzahlErsties) >= 1;
    }

    boolean vergleicheMissionskarte(Missionskarte missionskarte, String nameSpieler){

        switch (missionskarte){
            case BefreienVonStudiengang:


            case ZweiFachbereicheEinnehmen:
                return (daten.anzahlFachbereicheSpieler(nameSpieler) >= 2);

            case FuenfzehnGebaeudeEinnehmen:
                return (daten.anzahlGebaeudeSpieler(nameSpieler) >= 15);

            case ZehnGebaeudeEinnehmenUndZweiEinheitenJeweils:

             default:
                 return false;
        }
    }


    @Override
    public boolean spielAnlegen(int spielerAnzahl) {
        return daten.spielAnlegen(spielerAnzahl);
    }

    @Override
    public boolean spielLaden(String dateipfad) {
        return false;
    }

    @Override
    public boolean spielStarten() {
        if(alleSpielerBereit()) {
            //erstiesSetzen();
            return true;
        }
        return false;
    }

    @Override
    public boolean spielBeenden() {
        return false;
    }

    @Override
    public boolean spielSpeichern(String dateipfad) {
        return false;
    }

    @Override
    public boolean beobachterHinzufuegen(IGUIServerCallback beobachter) {
        return false;
    }

    @Override
    public boolean spielerAnmelden(String nameSpieler, String passwort) {
        return daten.spielerAnmelden(nameSpieler, passwort);
    }

    @Override
    public boolean spielerAusgestiegen(String nameSpieler) {
        return false;
    }

    @Override
    public boolean spielerBereitMelden(String nameSpieler) {
        return false;
    }

    @Override
    public boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler) {
        Integer anzahlErsties;
        if(daten.besitzerGebaeude(gebaeude).equals(nameSpieler)) {
            anzahlErsties = daten.anzahlErstiesGebaeude(gebaeude);
            return daten.anzahlErstiesAnpassen(gebaeude, anzahlErsties + 1);
        }
        return false;
    }

    @Override
    public boolean angriffVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) {
        if(!vergleicheNameSpieler(gebaeudeUrsprung, gebaeudeZiel, nameSpieler) && istNachbargebaeude(gebaeudeUrsprung, gebaeudeZiel)){
            //Angreifen
            return true;
        }
        return false;
    }

    @Override
    public boolean versetzenVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) {
        if(vergleicheNameSpieler(gebaeudeUrsprung, gebaeudeZiel, nameSpieler) && istNachbargebaeude(gebaeudeUrsprung, gebaeudeZiel)){
            if(mindEinErstieGebaeude(gebaeudeUrsprung, anzahlUrsprung)){
                daten.anzahlErstiesAnpassen(gebaeudeUrsprung, daten.anzahlErstiesGebaeude(gebaeudeUrsprung) - anzahlUrsprung);
                daten.anzahlErstiesAnpassen(gebaeudeZiel, daten.anzahlErstiesGebaeude(gebaeudeZiel) + anzahlUrsprung);
            }
        }
        return false;
    }

    @Override
    public boolean zugBeendet(String nameSpieler) {
        return false;
    }

    @Override
    public boolean gewuerfelt(String nameSpieler) {
        return false;
    }

    @Override
    public boolean beobachterHinzufuegen(IKommunikationServerCallback beobachter) {
        return false;
    }
}
