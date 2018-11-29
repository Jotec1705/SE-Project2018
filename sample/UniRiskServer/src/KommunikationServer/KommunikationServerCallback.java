package KommunikationServer;

public class KommunikationServerCallback implements IKommunikationServerCallback {

    ICallbackRMI callbackObjektOnline;

    public void setOnlineObjekt(ICallbackRMI callbackObjektOnline){
        this.callbackObjektOnline = callbackObjektOnline;
    }

    @Override
    public boolean spielBeendet() {
        try {
            return callbackObjektOnline.spielBeendet();
        }catch(Exception e){
            System.err.println("Methodenaufruf beim Client exception:");
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public boolean zugZuteilung(String nameSpieler) {
        try {
            return callbackObjektOnline.zugZuteilung(nameSpieler);
        }catch(Exception e){
            System.err.println("Methodenaufruf beim Client exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb) {
        try {
            return callbackObjektOnline.angriffAbwehren(nameSpieler, verteidigerGeb);
        }catch(Exception e){
            System.err.println("Methodenaufruf beim Client exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean aktualisierenKarte() {
        try {
            return callbackObjektOnline.aktualisierenKarte();
        }catch(Exception e){
            System.err.println("Methodenaufruf beim Client exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean aktualisierenLobby() {
        try {
            return callbackObjektOnline.aktualisierenLobby();
        }catch(Exception e){
            System.err.println("Methodenaufruf beim Client exception:");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen) {
        try {
            return callbackObjektOnline.wuerfelErgebnis(nameSpieler, wuerfelVerteidiger, wuerfelAngreifer, verloreneErsties, gewonnen);
        }catch(Exception e){
            System.err.println("Methodenaufruf beim Client exception:");
            e.printStackTrace();
        }
        return false;
    }
}
