package Spieldaten;

public class Spieldaten implements ISpieldaten, IAnzeigedaten{


    Gebaeude[] gebaeudeArr = new Gebaeude[34];
    Spieler[] spielerArr = new Spieler[6];


    @Override
    public Integer anzahlGebaeudeSpieler(String nameSpieler) {
        Integer anzahlGebaeudeSpieler = 0;

        for(int i = 1; i > gebaeudeArr.length;i++) {
            if (gebaeudeArr[i].Besitzer == nameSpieler) {
                anzahlGebaeudeSpieler++;
            }
        }

        return anzahlGebaeudeSpieler;
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

        gebaeudeArr[gebaeude].setBesitzer(nameSpieler);
        return true;
    }

    @Override
    public Integer[] nachbarGebaeude(Integer gebaeude) {

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


        Integer neueAnzahlErsties;
        neueAnzahlErsties = (gebaeudeArr[gebaeude].anzahlErsties + anzahlErsties);
        gebaeudeArr[gebaeude].setAnzahlErsties(neueAnzahlErsties);
        return true;
    }

    @Override
    public Integer anzahlFachbereicheSpieler(String nameSpieler) {
        Integer anzahlA = 0;
        Integer anzahlB = 0;
        Integer anzahlC = 0;
        Integer anzahlD = 0;
        Integer anzahlAERO = 0;
        Integer anzahlFachbereicheSpieler = 0;

        for(int i = 1; i > gebaeudeArr.length;i++){
            if(gebaeudeArr[i].Besitzer == nameSpieler && gebaeudeArr[i].Fachbereiche == Fachbereiche.A){anzahlA++;}
            if(gebaeudeArr[i].Besitzer == nameSpieler && gebaeudeArr[i].Fachbereiche == Fachbereiche.B){anzahlB++;}
            if(gebaeudeArr[i].Besitzer == nameSpieler && gebaeudeArr[i].Fachbereiche == Fachbereiche.C){anzahlC++;}
            if(gebaeudeArr[i].Besitzer == nameSpieler && gebaeudeArr[i].Fachbereiche == Fachbereiche.D){anzahlD++;}
            if(gebaeudeArr[i].Besitzer == nameSpieler && gebaeudeArr[i].Fachbereiche == Fachbereiche.AERO){anzahlAERO++;}
        }
        if(anzahlA==7){anzahlFachbereicheSpieler++;}// / weil es 7 A-Gebaeude in Fachbereiche.A gibt
        if(anzahlB==9){anzahlFachbereicheSpieler++;}// / weil es 9 B-Gebaeude in Fachbereiche.B gibt
        if(anzahlC==8){anzahlFachbereicheSpieler++;}// / weil es 8 C-Gebaeude in Fachbereiche.C gibt
        if(anzahlD==6){anzahlFachbereicheSpieler++;}// / weil es 7 D-Gebaeude in Fachbereiche.D gibt
        if(anzahlAERO ==3){anzahlFachbereicheSpieler++;}// / weil es 3 AERO-Gebaeude in Fachbereiche.AERO gibt


        return anzahlFachbereicheSpieler;
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
        spielerArr[0] = null;
        spielerArr[1] = new Spieler(null,null,false,false,false);
        spielerArr[2] = new Spieler(null,null,false,false,false);
        spielerArr[3] = new Spieler(null,null,false,false,false);
        spielerArr[4] = new Spieler(null,null,false,false,false);
        spielerArr[5] = new Spieler(null,null,false,false,false);




            Integer[] zufallsArray3 = { 1,1,1,1,1,1,1,1,1,1,1,
                                        2,2,2,2,2,2,2,2,2,2,2,
                                        3,3,3,3,3,3,3,3,3,3,3 };

            Integer[] zufallsArray4 = { 1,1,1,1,1,1,1,1,1,
                                        2,2,2,2,2,2,2,2,
                                        3,3,3,3,3,3,3,3,
                                        4,4,4,4,4,4,4,4 };

            Integer[] zufallsArray5 = { 1,1,1,1,1,1,1,1,1,
                                        2,2,2,2,2,2,2,2,2,
                                        3,3,3,3,3,3,3,3,3,
                                        4,4,4,4,4,4,
                                        5,5,5,5,5,5 };

            Integer[] zufallsArray = new Integer[33];

            switch(spielerAnzahl) {
                case 3: zufallsArray = arrayMischen(zufallsArray3);
                    break;
                case 4: zufallsArray = arrayMischen(zufallsArray4);
                    break;
                case 5: zufallsArray = arrayMischen(zufallsArray5);
                    break;
            }


        // Gebäude vom Index 0 existiert nicht!
        gebaeudeArr[0] = null;


        gebaeudeArr[1] = new Gebaeude("Hotel Alpenblick",       1,1,null ,zufallsArray[0], Fachbereiche.B,new Integer[] {2, 3, 12, 13});
        gebaeudeArr[2] = new Gebaeude("Parkplatz Ost",          2,1,null ,zufallsArray[1], Fachbereiche.B,new Integer[] {1,3,16,22,27,33});
        gebaeudeArr[3] = new Gebaeude("Freizeit-Area",          3,1,null ,zufallsArray[2], Fachbereiche.B,new Integer[] {1,2,4,6,7,13});
        gebaeudeArr[4] = new Gebaeude("Sternbau",               4,1,null ,zufallsArray[3], Fachbereiche.B,new Integer[] {3,5,6});
        gebaeudeArr[5] = new Gebaeude("ET_Bistro",              5,1,null ,zufallsArray[4], Fachbereiche.B,new Integer[] {4,6});
        gebaeudeArr[6] = new Gebaeude("Eifriger",               6,1,null ,zufallsArray[5], Fachbereiche.B,new Integer[] {3,4,5,7,9});
        gebaeudeArr[7] = new Gebaeude("Stab",                   7,1,null ,zufallsArray[6], Fachbereiche.B,new Integer[] {3,6,8,9});
        gebaeudeArr[8] = new Gebaeude("Mensa",                  8,1,null ,zufallsArray[7], Fachbereiche.B,new Integer[] {7,9});
        gebaeudeArr[9] = new Gebaeude("Code",                   9,1,null ,zufallsArray[8], Fachbereiche.B,new Integer[] {6,7,8,16});
        gebaeudeArr[10] = new Gebaeude("Teststrecke",           10,1,null ,zufallsArray[9], Fachbereiche.A,new Integer[] {11,12,17,18});
        gebaeudeArr[11] = new Gebaeude("BND_Baracke",           11,1,null ,zufallsArray[10], Fachbereiche.A,new Integer[] {10,12});
        gebaeudeArr[12] = new Gebaeude("Fuhrpark",              12,1,null ,zufallsArray[11], Fachbereiche.A,new Integer[] {1,10,11,13,15});
        gebaeudeArr[13] = new Gebaeude("Rocket",                13,1,null ,zufallsArray[12], Fachbereiche.A,new Integer[] {1,3,12,14,15});
        gebaeudeArr[14] = new Gebaeude("OPZ",                   14,1,null ,zufallsArray[13], Fachbereiche.A,new Integer[] {13,15});
        gebaeudeArr[15] = new Gebaeude("Sporthalle",            15,1,null ,zufallsArray[14], Fachbereiche.A,new Integer[] {12,13,14,16});
        gebaeudeArr[16] = new Gebaeude("Lerntempel",            16,1,null ,zufallsArray[15], Fachbereiche.A,new Integer[] {2,9,15,22,27,33});
        gebaeudeArr[17] = new Gebaeude("Ackerbau",              17,1,null ,zufallsArray[16], Fachbereiche.D,new Integer[] {10,18});
        gebaeudeArr[18] = new Gebaeude("Athene Racing",         18,1,null ,zufallsArray[17], Fachbereiche.D,new Integer[] {10,17,19,20});
        gebaeudeArr[19] = new Gebaeude("Prüfungsamt",           19,1,null ,zufallsArray[18], Fachbereiche.D,new Integer[] {18,20,21});
        gebaeudeArr[20] = new Gebaeude("Mucki-Bude",            20,1,null ,zufallsArray[19], Fachbereiche.D,new Integer[] {18,19,21,25,26});
        gebaeudeArr[21] = new Gebaeude("Tempel de Wissens",     21,1,null ,zufallsArray[20], Fachbereiche.D,new Integer[] {19,20,22});
        gebaeudeArr[22] = new Gebaeude("Sprachenzentrum",       22,1,null ,zufallsArray[21], Fachbereiche.D,new Integer[] {2,16,21,27,33});
        gebaeudeArr[23] = new Gebaeude("Driving Range",         23,1,null ,zufallsArray[22], Fachbereiche.C,new Integer[] {24,27,28});
        gebaeudeArr[24] = new Gebaeude("Schicki-Micki-Neubau",  24,1,null ,zufallsArray[23], Fachbereiche.C,new Integer[] {23,25,26,29});
        gebaeudeArr[25] = new Gebaeude("Flight",                25,1,null ,zufallsArray[24], Fachbereiche.C,new Integer[] {20,24,26});
        gebaeudeArr[26] = new Gebaeude("RZ & PAUS",             26,1,null ,zufallsArray[25], Fachbereiche.C,new Integer[] {20,24,25,29,30});
        gebaeudeArr[27] = new Gebaeude("Radarhalle",            27,1,null ,zufallsArray[26], Fachbereiche.C,new Integer[] {2,16,22,23,28,30});
        gebaeudeArr[28] = new Gebaeude("Sportplatz",            28,1,null ,zufallsArray[27], Fachbereiche.C,new Integer[] {23,27,29});
        gebaeudeArr[29] = new Gebaeude("Casino",                29,1,null ,zufallsArray[28], Fachbereiche.C,new Integer[] {24,26,28,30});
        gebaeudeArr[30] = new Gebaeude("Wäsche & Lager",        30,1,null ,zufallsArray[29], Fachbereiche.C,new Integer[] {26,29});
        gebaeudeArr[31] = new Gebaeude("Fliegerpuff",           31,1,null ,zufallsArray[30], Fachbereiche.AERO,new Integer[] {32,33});
        gebaeudeArr[32] = new Gebaeude("Hirschkäfer",           32,1,null ,zufallsArray[31], Fachbereiche.AERO,new Integer[] {31,33});
        gebaeudeArr[33] = new Gebaeude("Wache",                 33,1,null ,zufallsArray[32], Fachbereiche.AERO,new Integer[] {2,16,22,27,31,32});
        
        return true;

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
        for(int i = 0; i <= nachbargebaeudeArr.length;i++){
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

        //Gebäude müssen final den Spielern zugewiesen werden
        for(int i = 1; i<gebaeudeArr.length;i++){
            gebaeudeArr[i].Besitzer = spielerArr[gebaeudeArr[i].spielerArrPos].Name;
        }
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
        return angreifbareNachbarArr;   //?????????kann das sein????
    }

    @Override
    public String[] spielerNamen() {

        return new String[0];
    }

    @Override
    public boolean[] spielerBereit() {
        boolean[] bereit = new boolean[5];
        for(int i = 1 ; i<spielerArr.length;i++){
            bereit[i] = spielerArr[i].bereit;
        }
        return bereit;
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
    public boolean spielerBereitMelden(String nameSpieler) {
        for(int i = 1 ; i<spielerArr.length;i++) {
            if (spielerArr[i].Name == nameSpieler) {
                spielerArr[i].setSpielerBereit();
            }
        }
        return true;
    }

    @Override
    public boolean anzahlDerBonuskartenAnpassen(String nameSpieler, Bonuskarte typBonuskarte, Integer anzahlBonuskarten) {
        return false;
    }

    @Override
    public Integer anzahlDerBonuskarten(String nameSpieler, Bonuskarte typBonuskarte) {
        return null;
    }




    /**
     * Dies Methode dient dazu ein Array(Interger) zu mischen um die Karten später an die Spieler zu verteilen
     * @param zufallsArray ist ein von der Methode spielAnlegen übergebenes Array in dem die Zahlen die Spieler repräsentieren
     * @return ist das Array durchgemischt
     */
    public Integer[] arrayMischen(Integer[] zufallsArray ){
        Integer[] zufallsArrayZurueck = zufallsArray;
        int i = 0;
        int merke;
        int position1;
        int position2;
        while(i < 1000){
            position1= (int) ((Math.random()*((33-0)+0))+0);  // Aus Formel :: (Math.random()*((Max-min)+1))+min

            position2= (int) ((Math.random()*((33-0)+0))+0);  // Aus Formel :: (Math.random()*((Max-min)+1))+min

            merke = zufallsArrayZurueck[position1];
            zufallsArrayZurueck[position1] = zufallsArrayZurueck[position2];
            zufallsArrayZurueck[position2] = merke;

            i++;
        }
        return zufallsArrayZurueck;
    }
}
