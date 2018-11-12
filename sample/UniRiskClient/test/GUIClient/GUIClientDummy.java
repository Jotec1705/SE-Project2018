package GUIClient;

import KommunikationClient.IClientKommunikation;

public class GUIClientDummy implements IGUIClientCallback{

    @Override
    public boolean aktualisierenLobby() {
        return true;
    }

    @Override
    public boolean aktualisierenKarte() {
        return true;
    }

    @Override
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

    @Override
    public boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb) {
        switch (nameSpieler) {
            case "Horst":
                if (verteidigerGeb == 17)
                    return true;
            case "P3t3r":
                if (verteidigerGeb == 2)
                    return true;
            default:
                return false;
        }
    }

    @Override
    public boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen) {
        return true;
    }

    @Override
    public boolean spielBeendet() {
        return true;
    }
}
