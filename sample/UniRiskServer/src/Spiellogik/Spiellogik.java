package Spiellogik;

import GUIServer.IGUIServerCallback;
import KommunikationServer.IKommunikationServerCallback;
import Spieldaten.*;

public class Spiellogik implements ISpiellogik, ISpielkontrolle{


    ISpieldaten daten = null;

    public void setSpieldaten(ISpieldaten daten){
        this.daten = daten;
    }

    String spielerNamen[] = daten.spielerNamen();
    //[0]=null - [1]=etti - [2]=spo - [3]=wow - [4]=aero - [5]=bau

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
        daten.anzahlZuVerteilendeErstiesAnpassen(nameSpieler, neueErsties);

        neueErsties = daten.anzahlGebaeudeSpieler(nameSpieler) / 3;
        if(neueErsties < 3){
            neueErsties = 3;
        }
        daten.anzahlZuVerteilendeErstiesAnpassen(nameSpieler, neueErsties);

        if(daten.anzahlFachbereicheSpieler(nameSpieler) > 0){
            //switch case welche SFB und dann auf neueErsties addieren
            //Wie bekomme ich die Fachbereiche die er besitzt?
        }

        //if Karteneintauschen

        neueErsties = daten.anzahlZuVerteilendeErsties(nameSpieler);
        // setzenErsties

        Missionskarte missionskarte = daten.missionskarteSpieler(nameSpieler);
        if(vergleicheMissionskarte(missionskarte, nameSpieler)){
            //Sieg
        }
        return false;
    }

    boolean phase2Angriff(String nameSpieler){

        Missionskarte missionskarte = daten.missionskarteSpieler(nameSpieler);
        if(vergleicheMissionskarte(missionskarte, nameSpieler)){
            //Sieg
        }
        return false;
    }

    boolean phase3Verschieben(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler){

        //if Verschieben
        versetzenVonNach(gebaeudeUrsprung, anzahlUrsprung, gebaeudeZiel, nameSpieler);



        Missionskarte missionskarte = daten.missionskarteSpieler(nameSpieler);
        if(vergleicheMissionskarte(missionskarte, nameSpieler)){
            //Sieg
        }

        //Phase 3 beendet
        return false; //daten.naechsterSpieler();
    }


    Integer erstiesFuerBonuskarten(Integer vorErsties, Integer zusatzErsties, String nameSpieler){

        return 0;
    }

    //Prüft ob Zielgebäude im möglichen Ziel-Array enthalten ist
    boolean verschiebenAngreifenVonNach(Integer [] gebaeudeNach, Integer gebaeudeZiel){
        for(int i = 0; i < gebaeudeNach.length; i++){
            if(gebaeudeNach[i].equals(gebaeudeZiel))
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
                return (daten.anzahlGebaeudeSpieler(spielerNamen[1]) == 0);

            case BefreienVonStudiengangSPO:
                return (daten.anzahlGebaeudeSpieler(spielerNamen[2]) == 0);

            case BefreienVonStudiengangWOW:
                return (daten.anzahlGebaeudeSpieler(spielerNamen[3]) == 0);

            case BefreienVonStudiengangBAU:
                return (daten.anzahlGebaeudeSpieler(spielerNamen[4]) == 0);

            case BefreienVonStudiengangAero:
                return (daten.anzahlGebaeudeSpieler(spielerNamen[5]) == 0);

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
        //return false;
        return daten.spielerAusgestiegen(nameSpieler);
    }

    @Override
    public boolean spielerBereitMelden(String nameSpieler) {
        return daten.spielerBereitMelden(nameSpieler);
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
        //return daten.spielBeenden();
    }

    @Override
    public boolean spielSpeichern(String dateipfad) {
        return false;
        //return daten.spielStarten(dateipfad);
    }


    @Override
    public boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler) {
        if(daten.besitzerGebaeude(gebaeude).equals(nameSpieler)) {
            return daten.anzahlErstiesAnpassen(gebaeude, 1);
        }
        return false;
    }

    @Override
    public boolean tauschBonuskarten(String nameSpieler, Integer[] bonuskarten) {
        Integer zusetzendeErsties = daten.anzahlZuVerteilendeErsties(nameSpieler);
        if(bonuskarten.length > 3)
            return false;
        if(bonuskarten[0] == 3){
            daten.anzahlZuVerteilendeErstiesAnpassen(nameSpieler, zusetzendeErsties + 4);
        }
        if(bonuskarten[1] == 3){
            daten.anzahlZuVerteilendeErstiesAnpassen(nameSpieler, zusetzendeErsties + 6);
        }
        if(bonuskarten[2] == 3){
            daten.anzahlZuVerteilendeErstiesAnpassen(nameSpieler, zusetzendeErsties + 8);
        }
        if(bonuskarten[0] == 1 && bonuskarten[1] == 1 && bonuskarten[2] == 1){
            daten.anzahlZuVerteilendeErstiesAnpassen(nameSpieler, zusetzendeErsties + 10);
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
        return daten.naechsterSpieler();
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
