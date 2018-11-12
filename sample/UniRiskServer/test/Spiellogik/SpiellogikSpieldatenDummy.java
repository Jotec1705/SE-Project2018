package Spiellogik;

import Spieldaten.Bonuskarte;
import Spieldaten.Missionskarte;
import Spieldaten.Zustand;

public class SpiellogikSpieldatenDummy {

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

    //##############################Ab hier die Methoden der Spiellogik#################################################

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


}
