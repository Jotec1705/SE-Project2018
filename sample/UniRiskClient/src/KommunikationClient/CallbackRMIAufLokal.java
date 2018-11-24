package KommunikationClient;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackRMIAufLokal extends UnicastRemoteObject implements ICallbackRMI {

    public CallbackRMIAufLokal() throws RemoteException {
    }

    GUIClientDummy dummy = new GUIClientDummy();

    @Override
    public boolean aktualisierenLobby() throws RemoteException {
        return dummy.aktualisierenLobby();
    }

    @Override
    public boolean aktualisierenKarte() throws RemoteException {
        return dummy.aktualisierenKarte();
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
