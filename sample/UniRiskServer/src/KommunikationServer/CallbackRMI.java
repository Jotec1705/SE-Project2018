package KommunikationServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackRMI extends UnicastRemoteObject implements ICallbackRMI {

    public CallbackRMI() throws RemoteException {
    }

    @Override
    public boolean spielBeendet() throws RemoteException {
        return false;
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
    public boolean aktualisierenKarte() throws RemoteException {
        return false;
    }

    @Override
    public boolean aktualisierenLobby() throws RemoteException {
        return false;
    }

    @Override
    public boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen) throws RemoteException {
        return false;
    }
}
