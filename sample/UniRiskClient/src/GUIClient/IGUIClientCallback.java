package GUIClient;

public interface IGUIClientCallback {

    boolean aktualisierenKarte();

    boolean aktualisierenLobby();

    boolean spielBeendet();

    boolean zugZuteilung(String nameSpieler);

    boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb);

}
