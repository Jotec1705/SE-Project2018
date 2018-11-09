package GUIClient;

import KommunikationClient.IClientKommunikation;

public class ClientKommunikationDummy implements IClientKommunikation {
    @Override
    public boolean spielerAnmelden(String nameSpieler, String passwort){
        return true;
    }

    @Override
    public boolean spielerAusgestiegen(String nameSpieler){
        return true;
    }

    @Override
    public boolean spielerBereitMelden(String nameSpieler){
        return true;
    }

    @Override
    public String aktuellePhase() {
        return "Phase 1";
    }

    @Override
    public boolean erstiesAnzahlErhoehen(Integer gebaeude, String nameSpieler){
        return true;
    }

    @Override
    public Integer[] anzahlBonuskarten(String nameSpieler) {
        Integer[] anzahl = {0, 1, 0};
        return anzahl;
    }

    @Override
    public Integer anzahlZuVerteilendeErsties(String nameSpieler){
        return 5;
    }

    @Override
    public Integer[] anzahlErstiesAufGebaeude(){
        Integer[] anzahl = {};
        return anzahl;
    }

    @Override
    public boolean angriffVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler){
        return true;
    }

    @Override
    public Integer[] eigeneGebaeude(String nameSpieler){
        Integer[] gebaeude = {1, 16, 21, 30};
        return gebaeude;
    }

    @Override
    public Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler){
        Integer[] nachbargebaeude = {2, 10, 13, 25};
        return nachbargebaeude;
    }

    @Override
    public boolean gewuerfelt(String nameSpieler){
        return true;
    }

    @Override
    public boolean versetzenVonNach(Integer gebaeudeUrsprung, Integer anzahlUrsprung, Integer gebaeudeZiel, String nameSpieler){
        return true;
    }

    @Override
    public Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler){
        Integer[] nachbargebaeude = {2, 8};
        return nachbargebaeude;
    }

    @Override
    public boolean zugBeendet(String nameSpieler){
        return true;
    }

    @Override
    public boolean beobachterHinzufuegen(IGUIClientCallback beobachter) {
        return false;
    }

    @Override
    public Integer[] farbeSpieler(){
        Integer[] farben = {};
        return farben;
    }

}
