package KommunikationServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

//DAS MUSS HIER SPÄTER SO GESCHRIEBEN WERDEN WIE BEIM DUMMY. DAS BEDEUTET DASS AUCH ICALLBACKRMI ALS SCHNITTSTELLE FÜR
//KOMM NACH OBEN!

/*public class CallbackRMI extends UnicastRemoteObject implements ICallbackRMI {

    SpiellogikAnzeigedatenRMI zumClient;

    public CallbackRMI() throws RemoteException{

        try{
            this.zumClient = new SpiellogikAnzeigedatenRMI();
        }
        catch(Exception e){
            System.err.println("Dummy exception beim Anglegen:");
            e.printStackTrace();
        }
    }

    @Override
    public boolean spielBeendet() throws RemoteException {
        return zumClient.aufrufBeimClient.spielBeendet();
    }

    @Override
    public boolean zugZuteilung(String nameSpieler) throws RemoteException {
        return zumClient.aufrufBeimClient.zugZuteilung(nameSpieler);
    }

    @Override
    public boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb) throws RemoteException {
        return zumClient.aufrufBeimClient.angriffAbwehren(nameSpieler, verteidigerGeb);
    }

    @Override
    public boolean aktualisierenKarte() throws RemoteException {
        return zumClient.aufrufBeimClient.aktualisierenKarte();
    }

    @Override
    public boolean aktualisierenLobby() throws RemoteException {
        return zumClient.aufrufBeimClient.aktualisierenLobby();
    }

    @Override
    public boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen) throws RemoteException {
        return zumClient.aufrufBeimClient.wuerfelErgebnis(nameSpieler, wuerfelVerteidiger, wuerfelAngreifer, verloreneErsties, gewonnen);
    }
}*/
