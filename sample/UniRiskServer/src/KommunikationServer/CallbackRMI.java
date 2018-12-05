package KommunikationServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

//DAS MUSS HIER SPÄTER SO GESCHRIEBEN WERDEN WIE BEIM DUMMY. DAS BEDEUTET DASS AUCH ICALLBACKRMI ALS SCHNITTSTELLE FÜR
//KOMM NACH OBEN!

public class CallbackRMI extends UnicastRemoteObject implements ICallbackRMI {


    protected CallbackRMI() throws RemoteException {
    }

    ICallbackRMI zumClient;

    public void setClientObjekt(ICallbackRMI clientObjekt){
        this.zumClient = clientObjekt;
    }

    Map<String, ICallbackRMI> clients;

    public void setMap(Map clients){
        this.clients = clients;
    }

    @Override
    public boolean spielBeendet() throws RemoteException {

            clients.forEach((name, client) -> {
                try {
                    client.spielBeendet();
                } catch (RemoteException e) {
                    System.err.println("Exception bei spielBeendet call auf:" + name);
                    e.printStackTrace();
                }
            });

        return true;
    }

    @Override
    public boolean zugZuteilung(String nameSpieler) throws RemoteException {
        return clients.get(nameSpieler).zugZuteilung(nameSpieler);
    }

    @Override
    public boolean angriffAbwehren(String nameSpieler, Integer verteidigerGeb) throws RemoteException {
        return clients.get(nameSpieler).angriffAbwehren(nameSpieler, verteidigerGeb);
    }

    @Override
    public boolean aktualisierenKarte() throws RemoteException {

        clients.forEach((name, client) -> {
            try {
                client.aktualisierenKarte();
            } catch (RemoteException e) {
                System.err.println("Exception bei aktualisierenKarte call auf:" + name);
                e.printStackTrace();
            }
        });

        return true;
    }

    @Override
    public boolean aktualisierenLobby() throws RemoteException {

        clients.forEach((name, client) -> {
            try {
                client.aktualisierenLobby();
            } catch (RemoteException e) {
                System.err.println("Exception bei aktualisierenLobby call auf:" + name);
                e.printStackTrace();
            }
        });

        return true;
    }

    @Override
    public boolean wuerfelErgebnis(String nameSpieler, int[] wuerfelVerteidiger, int[] wuerfelAngreifer, Integer verloreneErsties, Integer gewonnen) throws RemoteException {
        return clients.get(nameSpieler).wuerfelErgebnis(nameSpieler, wuerfelVerteidiger, wuerfelAngreifer, verloreneErsties, gewonnen);
    }
}
