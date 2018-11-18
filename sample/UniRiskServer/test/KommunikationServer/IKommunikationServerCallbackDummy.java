package KommunikationServer;

public class IKommunikationServerCallbackDummy {

    public boolean aktualisiereLobbyAufgerufen = false;
    public boolean aktualisiereKarteAufgerufen = false;

    boolean aktualisierenLobby() {
        aktualisiereLobbyAufgerufen = true;
        return aktualisiereLobbyAufgerufen;
    }

    boolean aktualisierenKarte() {
        aktualisiereKarteAufgerufen = true;
        return aktualisiereKarteAufgerufen;
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
        int[] wuerfelv = {4, 5};
        int[] wuerfela = {3, 6};
        return nameSpieler == "Horst" && wuerfelVerteidiger == wuerfelv && wuerfelAngreifer == wuerfela && verloreneErsties == 1 && gewonnen == 1;
    }

    boolean spielBeendet() {
        return true;
    }
}
