package GUIClient;

import KommunikationClient.IClientKommunikation;

public class GUIClientDummy{

    boolean aktualisierenLobby() {
        return true;
    }

    boolean aktualisierenKarte() {
        return true;
    }

    boolean zugZuteilung(String nameSpieler) {
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

    boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb) {
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

    boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen) {
        return nameSpieler == "Horst" && ;
    }

    boolean spielBeendet() {
        return true;
    }
}
