package Spieldaten;

public class Spieldaten implements ISpieldaten, IAnzeigedaten{


    Gebaeude[] gebaeudeArr = new Gebaeude[33];


    @Override
    public Integer anzahlGebaeudeSpieler(String nameSpieler) {

        return null;
    }

    @Override
    public String besitzerGebaeude(Integer gebaeude) {
        if(gebaeude > 0 || gebaeude >33){
            return null;
        }
        return gebaeudeArr[gebaeude].Besitzer;
    }

    @Override
    public boolean besitzerGebaeudeAnpassen(Integer gebaeude, String nameSpieler) {
        //abruchbedingung

        gebaeudeArr[gebaeude].setBesitzer(nameSpieler);
        return true;
    }

    @Override
    public Integer[] nachbarGebaeude(Integer gebaeude) {
        //Abbruchkriterien
        Integer[] nachbarGebaeude = gebaeudeArr[gebaeude].hatNachbargebaeude;

        return nachbarGebaeude;
    }

    @Override
    public Integer anzahlErstiesGebaeude(Integer gebaeude) {
        Integer erstiesAufGebaeude;
        erstiesAufGebaeude = gebaeudeArr[gebaeude].anzahlErsties;
        return erstiesAufGebaeude;

    }

    @Override
    public boolean anzahlErstiesAnpassen(Integer gebaeude, Integer anzahlErsties) {
       //Abbruchbedingung

        Integer neueAnzahlErsties;
        neueAnzahlErsties = (gebaeudeArr[gebaeude].anzahlErsties + anzahlErsties);
        gebaeudeArr[gebaeude].setAnzahlErsties(neueAnzahlErsties);
        return true;
    }

    @Override
    public Integer anzahlFachbereicheSpieler(String nameSpieler) {
        return null;
    }

    @Override
    public boolean besitzerFachbereichAnpassen(Integer fachbereich, String nameSpieler) {
        return false;
    }

    @Override
    public Missionskarte missionskarteSpieler(String nameSpieler) {
        return null;
    }

    @Override
    public boolean aktuellePhaseSetzen(String phase) {
        return false;
    }

    @Override
    public boolean naechsterSpieler() {
        return false;
    }

    @Override
    public boolean spielAnlegen(int spielerAnzahl) {
        //Missionskarten verteilen an die Spieler (per Zufall)(Spieler sind die Studiengänge)
        //Anlegen nur zulässig wenn mindestens 3 und höchstens 5 Spieler angemeldet sind

        if(spielerAnzahl >5 || spielerAnzahl <3){
            return false;  //hier vieleicht noch nacch NaN testen?
        }
        if(spielerAnzahl>=3 && spielerAnzahl<=5) {

        // Array vom Typ Gebaude wird angelegt



        // Gebäude vom Index 0 existiert nicht!
        gebaeudeArr[0] = null;
        // Nun werden alle Gebäude angelegt
        //Hier könnte schon die Zuteilung der Gebäude an die Spieler statt finden
/*
        gebaeudeArr[1] = new Gebaeude("Hotel Alpenblick",1,1,null, Fachbereiche.A ,new Integer[] {2, 3, 12, 13});
        gebaeudeArr[2] = new Gebaeude("Parkplatz Ost",2,1,null,new Integer[] {1,3,16,22,27,33});
        gebaeudeArr[3] = new Gebaeude("Freizeit-Area",3,1,null,new Integer[] {1,2,4,6,7,13});
        gebaeudeArr[4] = new Gebaeude("Sternbau",4,1,null,new Integer[] {3,5,6});
        gebaeudeArr[5] = new Gebaeude("ET_Bistro",5,1,null,new Integer[] {4,6});
        gebaeudeArr[6] = new Gebaeude("Eifriger",6,1,null,new Integer[] {3,4,5,7,9});
        gebaeudeArr[7] = new Gebaeude("Stab",7,1,null,new Integer[] {3,6,8,9});
        gebaeudeArr[8] = new Gebaeude("Mensa",8,1,null,new Integer[] {7,9});
        gebaeudeArr[9] = new Gebaeude("Code",9,1,null,new Integer[] {6,7,8,16});
        gebaeudeArr[10] = new Gebaeude("Teststrecke",10,1,null,new Integer[] {11,12,17,18});
        gebaeudeArr[11] = new Gebaeude("BND_Baracke",11,1,null,new Integer[] {10,12});
        gebaeudeArr[12] = new Gebaeude("Fuhrpark",12,1,null,new Integer[] {1,10,11,13,15});
        gebaeudeArr[13] = new Gebaeude("Rocket",13,1,null,new Integer[] {1,3,12,14,15});
        gebaeudeArr[14] = new Gebaeude("OPZ",14,1,null,new Integer[] {13,15});
        gebaeudeArr[15] = new Gebaeude("Sporthalle",15,1,null,new Integer[] {12,13,14,16});
        gebaeudeArr[16] = new Gebaeude("Lerntempel",16,1,null,new Integer[] {2,9,15,22,27,33});
        gebaeudeArr[17] = new Gebaeude("Ackerbau",17,1,null,new Integer[] {10,18});
        gebaeudeArr[18] = new Gebaeude("Athene Racing",18,1,null,new Integer[] {10,17,19,20});
        gebaeudeArr[19] = new Gebaeude("Prüfungsamt",19,1,null,new Integer[] {18,20,21});
        gebaeudeArr[20] = new Gebaeude("Mucki-Bude",20,1,null,new Integer[] {18,19,21,25,26});
        gebaeudeArr[21] = new Gebaeude("Tempel de Wissens",21,1,null,new Integer[] {19,20,22});
        gebaeudeArr[22] = new Gebaeude("Sprachenzentrum",22,1,null,new Integer[] {2,16,21,27,33});
        gebaeudeArr[23] = new Gebaeude("Driving Range",23,1,null,new Integer[] {24,27,28});
        gebaeudeArr[24] = new Gebaeude("Schicki-Micki-Neubau",24,1,null,new Integer[] {23,25,26,29});
        gebaeudeArr[25] = new Gebaeude("Flight",25,1,null,new Integer[] {20,24,26});
        gebaeudeArr[26] = new Gebaeude("RZ & PAUS",26,1,null,new Integer[] {20,24,25,29,30});
        gebaeudeArr[27] = new Gebaeude("Radarhalle",27,1,null,new Integer[] {2,16,22,23,28,30});
        gebaeudeArr[28] = new Gebaeude("Sportplatz",28,1,null,new Integer[] {23,27,29});
        gebaeudeArr[29] = new Gebaeude("Casino",29,1,null,new Integer[] {24,26,28,30});
        gebaeudeArr[30] = new Gebaeude("Wäsche & Lager",30,1,null,new Integer[] {26,29});
        gebaeudeArr[31] = new Gebaeude("Fliegerpuff",31,1,null,new Integer[] {32,33});
        gebaeudeArr[32] = new Gebaeude("Hirschkäfer",32,1,null,new Integer[] {31,33});
        gebaeudeArr[33] = new Gebaeude("Wache",33,1,null,new Integer[] {2,16,22,27,31,32});
        */
        return true;
        }
        return false;
    }

    @Override
    public boolean spielLaden(String dateipfad) {
        return false;
    }

    @Override
    public boolean spielerAnmelden(String nameSpieler, String passwort) {
       if(nameSpieler == null || passwort == null){
           return false;
       }else{
           Spieler spieler = new Spieler(nameSpieler,passwort,false,false,false);
       }
       return true;
    }

    @Override
    public Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        Integer[] nachbargebaeudeArr = gebaeudeArr[gebaeude].hatNachbargebaeude;
        Integer[] angreifbareNachbarArr = new Integer[6];//-------------------------------------Kann ich das so machen?????
        int j = 0;
        for(int i = 0; i >= nachbargebaeudeArr.length;i++){
            int k = nachbargebaeudeArr[i];
            if(gebaeudeArr[k].Besitzer != nameSpieler){
                angreifbareNachbarArr[j] = k;
                k++;
            }
        }
        return angreifbareNachbarArr;
    }

    @Override
    public boolean spielStarten() {
        return false;
    }

    @Override
    public Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        Integer[] nachbargebaeudeArr = new Integer[6];//--------------------------------------Gleiches Problem ich muss eine Zahl angeben beim erstellen
        nachbargebaeudeArr = gebaeudeArr[gebaeude].hatNachbargebaeude;
        Integer[] angreifbareNachbarArr = new Integer[6];//--------------------------------Hier auch
        int j = 0;
        for(int i = 0; i >= nachbargebaeudeArr.length;i++){
            int k = nachbargebaeudeArr[i];
            if(gebaeudeArr[k].Besitzer == nameSpieler){
                angreifbareNachbarArr[j] = k;
                k++;
            }
        }
        return angreifbareNachbarArr;
    }

    @Override
    public String[] spielerNamen() {

        return new String[0];
    }

    @Override
    public boolean[] spielerBereit() {
        return new boolean[0];
    }

    @Override
    public String[] ipAdressen() {
        return new String[0];
    }

    @Override
    public Integer[] anzahlErstiesAufGebaeude() {
        Integer[] anzahlErstiesAufGebaeudeArr = new Integer[33];
        anzahlErstiesAufGebaeudeArr[0]= null;
        for(int i =1;i< gebaeudeArr.length;i++){
            anzahlErstiesAufGebaeudeArr[i] = gebaeudeArr[i].anzahlErsties;
        }
        return anzahlErstiesAufGebaeudeArr;
    }

    @Override
    public Integer[] anzahlBonuskarten(String nameSpieler) {
        return new Integer[0];
    }

    @Override
    public Integer[] farbeSpieler() {
        return new Integer[0];
    }

    @Override
    public Integer anzahlZuVerteilendeErsties(String nameSpieler) {
        return null;
    }

    @Override
    public boolean anzahlZuVerteilendeErstiesAnpassen(String nameSpieler, Integer anzahlErsties) {
        return false;
    }

    @Override
    public String missionskarteInhalt(String nameSpieler) {
        return null;
    }

    @Override
    public String aktuellePhase() {
        return null;
    }

    @Override
    public Integer[] eigeneGebaeude(String nameSpieler) {

        Integer[] eigeneGebaudeArr = new Integer[32];//--------------------------------------Auch hier
        int j = 0;

        for(int i = 1;i <=gebaeudeArr.length;i++) {
            if (gebaeudeArr[i].Besitzer == nameSpieler) {
                eigeneGebaudeArr[j] = gebaeudeArr[i].ID;
                j++;
            }
        }
        return eigeneGebaudeArr;
    }

    @Override
    public String aktuellerSpieler() {
        return null;
    }

    @Override
    public Zustand spielZustandHolen() {
        return null;
    }

    @Override
    public boolean spielZustandSetzen(Zustand aktuellerZustand) {
        return false;
    }

    @Override
    public boolean anzahlDerBonuskartenAnpassen(String nameSpieler, Bonuskarte typBonuskarte, Integer anzahlBonuskarten) {
        return false;
    }

    @Override
    public Integer anzahlDerBonuskarten(String nameSpieler, Bonuskarte typBonuskarte) {
        return null;
    }
}
