package GUIClient;

import KommunikationClient.IClientKommunikation;

public class GUIClientDummy{

    boolean aktualisierenLobby() {
        return true;
    }

    boolean aktualisierenKarte() {
        return true;
    }

    boolean spielerAnmelden(String nameSpieler, String passwort) {
        return (nameSpieler == "Horst" && passwort == "blutwurst1");
    }

    boolean spielerAusgestiegen(String nameSpieler) {
        return nameSpieler == "Horst";
    }

    boolean spielerBereitMelden(String nameSpieler) {
        return nameSpieler == "Horst";
    }

    String aktuellePhase() {
        return "PhaseII";
    }

    boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler) {
        return (gebaeude == 17 && nameSpieler == "Horst") || (gebaeude == 2 && nameSpieler == "P3t3r");
    }

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

    boolean angriffVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) {
        return gebaeudeUrsprung == 17 && anzahlUrsprung == 2 && gebaeudeZiel == 10 && nameSpieler == "Horst";
    }

    Integer[] eigeneGebaeude(String nameSpieler) {
        switch (nameSpieler){
            case "Horst":
                Integer[] gebaeude = {3, 8, 17, 21};
                return gebaeude;
            case "P3t3r":
                Integer[] gebaeude2 = {2, 10, 19, 27};
                return gebaeude2;
            case "Mqrianne":
                Integer[] gebaeude3 = {1, 6, 22, 30};
                return gebaeude3;
            default:
                break;
        }
        return new Integer[0];
    }

    Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        if(gebaeude == 17 && nameSpieler == "Horsz"){
            Integer[] nachbar = {10, 18};
            return nachbar;
        }
        return new Integer[0];
    }

    boolean gewuerfelt(String nameSpieler) {
        return nameSpieler == "Horst" || nameSpieler == "P3t3r";
    }

    boolean versetzenVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler) {
        return gebaeudeUrsprung == 9 && anzahlUrsprung == 2 && gebaeudeZiel == 6 && nameSpieler == "Bob";
    }

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

    boolean zugBeendet(String nameSpieler) {
        return nameSpieler == "Horst";
    }

    Integer[] farbeSpieler() {
        Integer[] farbe = {3, 8, 10};
        return farbe;
    }

    /*
    //Valide Parameterwerte: "Horst", "M@rianne"
    public boolean zugZuteilung(String nameSpieler) {
        switch (nameSpieler){
            case "Horst":
                return true;
            case "M@rianne":
                return true;
            default:
                    break;
        }
        return false;
    }

    public boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb) {
        switch (nameSpieler) {
            case "Horst":
                if (verteidigerGeb == 17)
                    return true;
                break;
            case "P3t3r":
                if (verteidigerGeb == 2)
                    return true;
                break;
            default:
                break;
        }
        return false;
    }

    public boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen) {
        return true;
    }

    public boolean spielBeendet() {
        return true;
    }
    */


}
