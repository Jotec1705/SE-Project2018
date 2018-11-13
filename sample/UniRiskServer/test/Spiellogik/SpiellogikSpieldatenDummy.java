package Spiellogik;

import Spieldaten.Bonuskarte;
import Spieldaten.Missionskarte;
import Spieldaten.Zustand;

public class SpiellogikSpieldatenDummy {

    //##############################Ab hier die Methoden der ISpieldaten#################################################

    /*Valide Parameterwerte "Horst", "M@rianne"*/
    Integer anzahlGebaeudeSpieler(String nameSpieler){

        Integer anzahl = 0;
        switch (nameSpieler){
            case "Horst":
                anzahl = 8;
                break;

            case "M@rianne":
                anzahl = 5;
                break;

            default:
                break;
        }

        return anzahl;
    }

    /*Valide Parameterwerte 17, 2*/
    String besitzerGebaeude(Integer gebaeude){
        String besitzer = "";

        switch(gebaeude){
            case 17:
                besitzer = "Horst";
                break;

            case 2:
                besitzer = "P3t3r";
                break;

            default:
                break;
        }

        return besitzer;

    }

    /*Valide Parameterwerte 8, "Horst"*/
    boolean besitzerGebaeudeAnpassen(Integer gebaeude, String nameSpieler){

        return (gebaeude == 8) && (nameSpieler == "Horst"); //Wenn als Gebäude 8 und als Name Horst getestet wird, true.
    }

    /*Valide Parameterwerte 8, 17*/
    Integer[] nachbarGebaeude(Integer gebaeude){
        Integer[] nachbarn = {};

        switch(gebaeude){
            case 8:
                nachbarn[0] = 7;
                nachbarn[1] = 9;
                break;

            case 17:
                nachbarn[0] = 10;
                nachbarn[1] = 18;
                break;

            default:
                break;
        }

        return nachbarn;
    }

    /*Valide Parameterwerte 5, 33*/
    Integer anzahlErstiesGebaeude(Integer gebaeude){

        Integer anzahl = 0;
        switch (gebaeude){
            case 5:
                anzahl = 12;
                break;

            case 33:
                anzahl = 4;
                break;

            default:
                break;
        }

        return anzahl;
    }


    /*Valide Parameterwerte 9, 3*/
    boolean anzahlErstiesAnpassen(Integer gebaeude, Integer anzahlErsties){

        return (gebaeude == 9) && (anzahlErsties == 3); //Wenn als Gebäude 8 und als Anzahl 3 getestet wird, true.
    }



    /*Valide Parameterwerte "Horst", "M@rianne"*/
    Integer anzahlFachbereicheSpieler(String nameSpieler){

        Integer anzahl = 0;
        switch (nameSpieler){
            case "Horst":
                anzahl = 1;
                break;

            case "M@rianne":
                anzahl = 2;
                break;

            default:
                break;
        }

        return anzahl;

    }


    /*Valide Parameterwerte 8, "Horst"*/
    boolean besitzerFachbereichAnpassen(Integer fachbereich, String nameSpieler){

        return (fachbereich == 1) && (nameSpieler == "Horst"); //Wenn als Fachbereich 1 und als Name Horst getestet wird, true.
    }


    /*Valide Parameterwerte "Horst", Bonuskarte.Ersties*/
    Integer anzahlDerBonuskarten(String nameSpieler, Bonuskarte typBonuskarte){

        Integer anzahl = 0;

        if(nameSpieler == "Horst" && typBonuskarte == Bonuskarte.Ersties){
            anzahl = 2;
        }

        return anzahl;

    }


    /*Valide Parameterwerte "P3t3r", Bonuskarte.Studenten, 3*/
    boolean anzahlDerBonuskartenAnpassen(String nameSpieler, Bonuskarte typBonuskarte, Integer anzahlBonuskarten){
        return (nameSpieler == "P3t3r") && (typBonuskarte == Bonuskarte.Studenten) &&
                (anzahlBonuskarten == 3);
    }


    /*Valide Parameterwerte*/
    Missionskarte missionskarteSpieler(String nameSpieler){
        Missionskarte karte = null;

        switch (nameSpieler){
            case "Horst":
                karte = Missionskarte.FuenfzehnGebaeudeEinnehmen;
                break;

            case "M@rianne":
                karte = Missionskarte.ZweiFachbereicheEinnehmen;
                break;

            default:
                break;
        }

        return karte;
    }


    /*Valide Parameterwerte "PhaseII"*/
    boolean aktuellePhaseSetzen(String phase){
        return phase == "PhaseII";
    }


    boolean naechsterSpieler(){
        return true;
    }


    /*Valide Parameterwerte 4*/
    boolean spielAnlegen(int spielerAnzahl){
        return spielerAnzahl == 4;
    }


    /*Valide Parameterwerte "Horst", "blutwurst1"*/
    boolean spielerAnmelden(String nameSpieler, String passwort){
        return (nameSpieler == "Horst") && (passwort == "blutwurst1");
    }


    boolean[] spielerBereit(){

        boolean[] bereit = {};
        bereit[0] = true;
        bereit[1] = true;
        bereit[2] = true;
        bereit[3] = true;
        bereit[4] = true;

        return bereit;
    }



    String aktuellerSpieler(){
        return "P3t3r";
    }


    Zustand spielZustandHolen(){
        return Zustand.Initial;
    }


    /*Valide Parameterwerte "Zustand.Aktiv"*/
    boolean spielZustandSetzen(Zustand aktuellerZustand){
        return aktuellerZustand == Zustand.Aktiv;
    }

    //##############################Ab hier die Methoden der ISpiellogik#################################################

    /*Die Methode ist bereits durch den Spieldatenteil implementiert
    boolean spielerAnmelden(String nameSpieler, String passwort);
    */

    /*Valide Parameterwerte "Piet"*/
    boolean spielerAusgestiegen(String nameSpieler){
        return nameSpieler == "Piet";
    }

    /*Valide Parameterwerte "Horst"*/
    boolean spielerBereitMelden(String nameSpieler){
        return nameSpieler == "Horst";
    }

    /*Valide Parameterwerte 9, "Horst"*/
    boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler){
        return (gebaeude == 9) && (nameSpieler == "Horst");
    }

    /*Valide Parameterwerte 14, 5, 15, "P3t3r"*/
    boolean angriffVonNach (Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler){
        return (gebaeudeUrsprung == 14) && (anzahlUrsprung == 5) && (gebaeudeZiel == 15) && (nameSpieler == "P3t3r");

    }


    /*Valide Parameterwerte 15, 1, 14, "P3t3r"*/
    boolean versetzenVonNach (Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler){
        return (gebaeudeUrsprung == 15) && (anzahlUrsprung == 1) && (gebaeudeZiel == 14) && (nameSpieler == "P3t3r");
    }


    /*Valide Parameterwerte "Horst"*/
    boolean zugBeendet(String nameSpieler){
        return nameSpieler == "Horst";
    }

    /*Valide Parameterwerte "M@rianne"*/
    boolean gewuerfelt(String nameSpieler){
        return nameSpieler == "M@rianne";
    }

    //##################################Ab  hier die Methoden IAnzeigedaten###########################


    String aktuellePhase(){
        return "PhaseII";
    }

    /*Valide Parameterwerte "Horst" | "M@rianne" | "P3t3r" */
    Integer[] anzahlBonuskarten(String nameSpieler) {
        Integer[] anzahl = {0, 0, 0};
        switch (nameSpieler){
            case "Horst":
                anzahl[1] = 2;
                break;
            case "M@rianne":
                anzahl[0] = 1;
                anzahl[2] = 1;
                break;
            case "P3t3r":
                anzahl[0] = 3;
                break;
            default:
                break;
        }
        return anzahl;
    }

    /*Valide Parameterwerte "M@rianne"*/
    Integer anzahlZuVerteilendeErsties(String nameSpieler) {
        Integer anzahl = 0;
        if (nameSpieler == "M@rianne")
            anzahl = 3;
        return anzahl;
    }

    Integer[] anzahlErstiesAufGebaeude() {
        Integer[] ersties = {5, 1, 1, 2, 3};
        return ersties;
    }

    /*Valide Parameter "Horst" | "P3t3r" | "M@rianne"*/
    Integer[] eigeneGebaeude(String nameSpieler) {
        switch (nameSpieler){
            case "Horst":
                Integer[] gebaeude = {3, 8, 17, 21};
                return gebaeude;
            case "P3t3r":
                Integer[] gebaeude2 = {2, 10, 19, 27};
                return gebaeude2;
            case "M@rianne":
                Integer[] gebaeude3 = {1, 6, 22, 30};
                return gebaeude3;
            default:
                break;
        }
        return new Integer[0];
    }

    /*Valide Parameter 17, "Horst"*/
    Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        if(gebaeude == 17 && nameSpieler == "Horst"){
            Integer[] nachbar = {10, 18};
            return nachbar;
        }
        return new Integer[0];
    }

    /*Valide Parameter 4 | 5 | 11 | 12 | 13 | 15, "Bob"*/
    Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        Integer[] eigene = {null};
        if(nameSpieler == "Bob")
            switch (gebaeude) {
                case 4:
                    eigene[0] = 5;
                    break;
                case 5:
                    eigene[0] = 4;
                    break;
                case 11:
                    eigene[0] = 12;
                    break;
                case 12:
                    eigene[0] = 11;
                    eigene[1] = 13;
                    eigene[2] = 15;
                    break;
                case 13:
                    eigene[0] = 12;
                    eigene[1] = 15;
                    break;
                case 15:
                    eigene[0] = 12;
                    eigene[1] = 13;
                    break;
                default:
                    break;
            }
        return eigene;
    }


    Integer[] farbeSpieler() {
        Integer[] farbe = {3, 8, 10};
        return farbe;
    }



}
