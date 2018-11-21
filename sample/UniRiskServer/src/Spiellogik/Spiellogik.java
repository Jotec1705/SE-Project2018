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

    boolean alleSpielerBereit(){
       boolean [] spielerBereit;
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

    boolean Spiel(){

        if(daten.spielZustandHolen() == Zustand.Initial){
            //Spiel anlegen
            //Spieler anmelden
            //Spieler bereit
            //Spieler ausgestiegen
            //Spiel starten
        }

        if(daten.spielZustandHolen() == Zustand.ErstiesVerteilen){
            //Initiales Ersties verteilen
        }

        if(daten.spielZustandHolen() == Zustand.Aktiv){

            //Phase1

            //Phase2

            //Phase3

        }

        if(daten.spielZustandHolen() == Zustand.Beendet){
            //Speichern
            //Schließen
        }

        return false;
    }

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

    boolean phase3Verschieben(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler, Missionskarte missionskarte){

        //if Verschieben
        versetzenVonNach(gebaeudeUrsprung, anzahlUrsprung, gebaeudeZiel, nameSpieler);


        if(vergleicheMissionskarte(missionskarte, nameSpieler)){ //Missionskarte erfüllt
            //Sieg
        }

        //Phase 3 beendet

        return daten.naechsterSpieler();
    }

    boolean vergleicheNameSpieler(Integer gebaeudeUrsprung, Integer gebaeudeZiel, String nameSpieler){
        return (daten.besitzerGebaeude(gebaeudeUrsprung).equals(nameSpieler) && daten.besitzerGebaeude(gebaeudeZiel).equals(nameSpieler));
    }


    //Prüft ob Zielgebäude im möglichen Ziel-Array enthalten ist
    boolean verschiebenAngreifenVonNach(Integer [] gebaeudeNach, Integer gebaeudeZiel){
        for(int i = 0; i < gebaeudeNach.length; i++){
            if(gebaeudeNach[i].equals(gebaeudeZiel))
                return true;
        }
        return false;
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
            case BefreienVonStudiengangETTI:

            case BefreienVonStudiengangSPO:

            case BefreienVonStudiengangWOW:

            case BefreienVonStudiengangBAU:

            case BefreienVonStudiengangAero:

            case ZweiFachbereicheEinnehmen:
                return (daten.anzahlFachbereicheSpieler(nameSpieler) >= 2);

            case FuenfzehnGebaeudeEinnehmen:
                return (daten.anzahlGebaeudeSpieler(nameSpieler) >= 15);

            case ZehnGebaeudeEinnehmenUndZweiEinheitenJeweils:
                Integer [] eigGebaeude;
                Integer einheitenGebaeude = 0;
                Integer zaehler = 0;
                if(daten.anzahlGebaeudeSpieler(nameSpieler) >= 10){
                    eigGebaeude = daten.eigeneGebaeude(nameSpieler);
                    for(int i = 0; i < eigGebaeude.length; i++){
                        einheitenGebaeude = daten.anzahlErstiesGebaeude(eigGebaeude[i]);
                        if(einheitenGebaeude >= 2)
                            zaehler++;
                    }
                    return (zaehler == eigGebaeude.length);
                }
                return false;

             default:
                 return false;
        }
    }


    @Override
    public boolean spielerAnmelden(String nameSpieler, String passwort) {
        return daten.spielerAnmelden(nameSpieler, passwort);
    }

    @Override
    public boolean spielAnlegen(int spielerAnzahl) {
        if(spielerAnzahl>=3 && spielerAnzahl<=5)
            return daten.spielAnlegen(spielerAnzahl);
        return false;
    }

    @Override
    public boolean spielLaden(String dateipfad) {
        return daten.spielLaden(dateipfad);
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
    public boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler) {
        if(daten.besitzerGebaeude(gebaeude).equals(nameSpieler)) {
            return daten.anzahlErstiesAnpassen(gebaeude, 1);
        }
        return false;
    }

    @Override
    public boolean angriffVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) {
        Integer [] angreibareNachbarGebaeude = daten.angreifbareNachbarGebaeude(gebaeudeUrsprung, nameSpieler);
        if(verschiebenAngreifenVonNach(angreibareNachbarGebaeude, gebaeudeZiel)){
            //Angreifen
            return true;
        }
        return false;
    }

    @Override
    public boolean versetzenVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) {
        Integer [] eigeneNachbarGebaeude = daten.eigeneNachbarGebaeude(gebaeudeUrsprung, nameSpieler);
        if(verschiebenAngreifenVonNach(eigeneNachbarGebaeude, gebaeudeZiel)){
            if(mindEinErstieGebaeude(gebaeudeUrsprung, anzahlUrsprung)){
                daten.anzahlErstiesAnpassen(gebaeudeUrsprung, daten.anzahlErstiesGebaeude(gebaeudeUrsprung) - anzahlUrsprung);
                daten.anzahlErstiesAnpassen(gebaeudeZiel, daten.anzahlErstiesGebaeude(gebaeudeZiel) + anzahlUrsprung);
            }
        }
        return false;
    }

    @Override
    public boolean gewuerfelt(String nameSpieler) {
        return false;
    }

    @Override
    public boolean zugBeendet(String nameSpieler) {
        return false;
    }

    @Override
    public boolean beobachterHinzufuegen(IKommunikationServerCallback beobachter) {
        return false;
    }

    @Override
    public boolean beobachterHinzufuegen(IGUIServerCallback beobachter) {
        return false;
    }


}
