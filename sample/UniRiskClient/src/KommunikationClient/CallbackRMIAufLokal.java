package KommunikationClient;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import GUIClient.GUIClient;
import GUIClient.IGUIClientCallback;
import KommunikationServer.ICallbackRMI;

public class CallbackRMIAufLokal extends UnicastRemoteObject implements ICallbackRMI, Serializable {

    public GUIClient guiClient;

    public CallbackRMIAufLokal() throws RemoteException {
        guiClient.setClient(this);
    }

    GUIClientDummy dummy = new GUIClientDummy();






    @Override
    public boolean aktualisierenLobby() throws RemoteException {
        //return dummy.aktualisierenLobby();
        return guiClient.aktualisierenLobby();
    }

    @Override
    public boolean aktualisierenKarte() throws RemoteException {
        return dummy.aktualisierenKarte();
        //return guiClient.aktualisierenKarte();
    }

    @Override
    public boolean zugZuteilung(String nameSpieler) throws RemoteException {
        return false;
    }

    @Override
    public boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb) throws RemoteException {
        return false;
    }

    @Override
    public boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen) throws RemoteException {
        return false;
    }

    @Override
    public boolean spielBeendet() throws RemoteException {
        return false;
    }

}
