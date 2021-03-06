package Spieldaten;

public class Spieldaten implements ISpieldaten, IAnzeigedaten{


    Gebaeude[] gebaeudeArr = new Gebaeude[34];
    Spieler[] spielerArr = new Spieler[6];
    Zustand zustand = null;
    Missionskarte[] MissionskarteArr = new  Missionskarte[11];
    int Mission1 = 0;
    int Mission2 = 0;
    int Mission3 = 0;
    int Mission4 = 0;
    int Mission5 = 0;



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
        //TODO Löschen in Absprache
        return false;
    }

    @Override
    public Missionskarte missionskarteSpieler(String nameSpieler) {
        //TODO Klären was hier passieren soll
        return null;
    }

    @Override
    public boolean aktuellePhaseSetzen(String phase) {
        //TODO Prof fragen -> Brauchen wir das in den Daten
        return false;
    }

    @Override
    public boolean naechsterSpieler() {
        //TODO Prof fragen -> Brauchen wir das in den Daten
        return false;
    }

    @Override
    public boolean spielAnlegen(int spielerAnzahl) {

        MissionskarteArr[0] = Missionskarte.BefreienVonStudiengangETTI;
        MissionskarteArr[1] = Missionskarte.BefreienVonStudiengangSPO;
        MissionskarteArr[2] = Missionskarte.BefreienVonStudiengangWOW;
        MissionskarteArr[3] = Missionskarte.ZweiFachbereicheEinnehmen;
        MissionskarteArr[4] = Missionskarte.ZweiFachbereicheEinnehmen;
        MissionskarteArr[5] = Missionskarte.ZweiFachbereicheEinnehmen;
        MissionskarteArr[6] = Missionskarte.ZweiFachbereicheEinnehmen;
        MissionskarteArr[7] = Missionskarte.FuenfzehnGebaeudeEinnehmen;
        MissionskarteArr[8] = Missionskarte.ZehnGebaeudeEinnehmenUndZweiEinheitenJeweils;
        MissionskarteArr[9] = Missionskarte.BefreienVonStudiengangAero;
        MissionskarteArr[10] = Missionskarte.BefreienVonStudiengangBAU;


        Missionskarte MissionSpieler1 = MissionskarteArr[1];
        Missionskarte MissionSpieler2 = MissionskarteArr[2];
        Missionskarte MissionSpieler3 = MissionskarteArr[3];
        Missionskarte MissionSpieler4 = MissionskarteArr[4];
        Missionskarte MissionSpieler5 = MissionskarteArr[5];


        //Missionskarten verteilen an die Spieler (per Zufall)(Spieler sind die Studiengänge)
        //Anlegen nur zulässig wenn mindestens 3 und höchstens 5 Spieler angemeldet sind

        if(spielerAnzahl >5 || spielerAnzahl <3){
            return false;
        }
            Integer[] zufallsArray3 = { 1,1,1,1,1,1,1,1,1,1,1,
                                        2,2,2,2,2,2,2,2,2,2,2,
                                        3,3,3,3,3,3,3,3,3,3,3 };

            Integer[] zufallsArray4 = { 1,1,1,1,1,1,1,1,1,
                                        2,2,2,2,2,2,2,2,2,
                                        3,3,3,3,3,3,3,3,3,
                                        4,4,4,4,4,4,4,4 };

            Integer[] zufallsArray5 = { 1,1,1,1,1,1,1,
                                        2,2,2,2,2,2,2,
                                        3,3,3,3,3,3,3,
                                        4,4,4,4,4,4,
                                        5,5,5,5,5,5 };

            Integer[] zufallsArray = new Integer[33];

            //Anzahl Ersties bei SpielerAnzahl 3:26 ;4:23 ; 5:19
           Integer zuVerteilendeErstiesDifferenz = 0;
            switch(spielerAnzahl) {
                case 3: zufallsArray = arrayMischen(zufallsArray3);
                        zuVerteilendeErstiesDifferenz =15;//15 ist die Differenz zwischen 26(AnzahlErstiesInitial) und 11 Gebäude


                        //Missionskarte MissionSpieler1 = MissionskarteArr[randomMission(0,0,0,0,0,8)];

                    break;
                case 4: zufallsArray = arrayMischen(zufallsArray4);
                        zuVerteilendeErstiesDifferenz = 14;
                    break;
                case 5: zufallsArray = arrayMischen(zufallsArray5);
                        zuVerteilendeErstiesDifferenz = 7;
                    break;
            }


            //Missionsziel muss noch vergeben werden

        // Spieler vom Index 0 existiert nicht!
        spielerArr[0] = null;
        spielerArr[1] = new Spieler(null,null,false,false,false,MissionSpieler1,zuVerteilendeErstiesDifferenz+0);
        spielerArr[2] = new Spieler(null,null,false,false,false,MissionSpieler2,zuVerteilendeErstiesDifferenz+0);
        spielerArr[3] = new Spieler(null,null,false,false,false,MissionSpieler3,zuVerteilendeErstiesDifferenz+0);
        spielerArr[4] = new Spieler(null,null,false,false,false,MissionSpieler4,zuVerteilendeErstiesDifferenz-1);
        spielerArr[5] = new Spieler(null,null,false,false,false,MissionSpieler5,zuVerteilendeErstiesDifferenz-1);


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

        //Zustand wird auf initial gesetzt.
        zustand = Zustand.Initial;
        return true;

    }

    @Override
    public boolean spielLaden(String dateipfad) {
        return false;
    }

    @Override
    public boolean spielerAnmelden(String nameSpieler, String passwort) {
      for(int i = 1; i< spielerArr.length;i++){
          if(spielerArr[i].Name==null){
              spielerArr[i].Name = nameSpieler;
              spielerArr[i].Passwort = passwort;
              return true;
          }

      }
       return false;
    }

    @Override
    public Integer[] angreifbareNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        Integer[] nachbargebaeudeArr = gebaeudeArr[gebaeude].hatNachbargebaeude;
        int k = 0;
        for(int i = 0 ; i< nachbargebaeudeArr.length;i++){
            if(gebaeudeArr[nachbargebaeudeArr[i]].Besitzer != nameSpieler){k++;}
        }
        Integer[] angreifbareNachbarArr = new Integer[k];
        for(int i = 0 ; i< nachbargebaeudeArr.length;i++){
            if(gebaeudeArr[nachbargebaeudeArr[i]].Besitzer != nameSpieler){angreifbareNachbarArr[i] = nachbargebaeudeArr[i];}
        }
        return angreifbareNachbarArr;
    }

    @Override
    public boolean spielStarten() {
        //TODO Spieler müssen noch Karten bekommen (Missionskarten)

        //Gebäude werden final den Spielern zugewiesen
        for(int i = 1; i<gebaeudeArr.length;i++){
            gebaeudeArr[i].Besitzer = spielerArr[gebaeudeArr[i].spielerArrPos].Name;
        }
        //Zustand wird auf das initiale Ersties verteilen gesetzt
        zustand = Zustand.ErstiesVerteilen;
        return true;
    }

    @Override
    public Integer[] eigeneNachbarGebaeude(Integer gebaeude, String nameSpieler) {
        Integer[] nachbargebaeudeArr = gebaeudeArr[gebaeude].hatNachbargebaeude;//
        int j = 0;
        int k = 0;
        for(int i = 0; i > nachbargebaeudeArr.length;i++){
            if(gebaeudeArr[i].Besitzer == nameSpieler){
                k++;
            }
        }
        Integer[] eigeneNachbarArr = new Integer[k];

        for(int i = 0; i > nachbargebaeudeArr.length;i++){
            if(gebaeudeArr[i].Besitzer == nameSpieler){
               eigeneNachbarArr[i] = gebaeudeArr[i].ID;
            }
        }

        return eigeneNachbarArr;
    }

    @Override
    public String[] spielerNamen() {

        String[] spielerNamenArr = new String[6];
        spielerNamenArr[0]=null;
        for(int i = 1;i<spielerArr.length;i++) {
            spielerNamenArr[i] = spielerArr[i].Name;

        }
        return spielerNamenArr;
    }

    @Override
    public boolean[] spielerBereit() {
        boolean[] bereit = new boolean[6];
        for(int i = 1 ; i<spielerArr.length;i++){
            bereit[i] = spielerArr[i].bereit;
        }
        return bereit;
    }

    @Override
    public boolean spielerAusgestiegen(String nameSpieler) {
        for(int i = 0;i<spielerArr.length;i++){
            if(nameSpieler == spielerArr[i].Name){spielerArr[i].bereit = false;}
        }

        return true;
    }

    @Override
    public String[] ipAdressen() {
        //TODO warten bis hannes was brauchbares liefert
        return new String[6];
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
        //TODO Warum hier ein Array Bonuskarten ? Klären
        return new Integer[0];
    }

    @Override
    public Integer[] farbeSpieler() {
        //TODO Klären was das hier bringen soll
        return new Integer[0];
    }

    @Override
    public Integer anzahlZuVerteilendeErsties(String nameSpieler) {
             Integer anzahlZuVerteilendeErsties = 0;
        for(int i =1; i<spielerArr.length;i++){
            if(spielerArr[i].Name==nameSpieler){anzahlZuVerteilendeErsties = spielerArr[i].zuVerteilendeErsties;}
        }

        return null;
    }

    @Override
    public boolean anzahlZuVerteilendeErstiesAnpassen(String nameSpieler, Integer anzahlErsties) {
                for(int i =1; i<spielerArr.length;i++){
            if(spielerArr[i].Name==nameSpieler){spielerArr[i].setZuVerteilendeErsties(anzahlErsties);}
        }
        return false;
    }

    @Override
    public String missionskarteInhalt(String nameSpieler) {
        return null;
    }

    @Override
    public String aktuellePhase() {
        //TODO Prof fragen -> Brauchen wir das in den Daten
        return null;
    }

    @Override
    public Integer[] eigeneGebaeude(String nameSpieler) {
        int j = 0;
        for(int i = 1;i <gebaeudeArr.length;i++) {
            if (gebaeudeArr[i].Besitzer == nameSpieler) { j++;}
        }
        Integer[] eigeneGebaudeArr = new Integer[j];
        for(int i = 1;i <gebaeudeArr.length;i++) {
            if (gebaeudeArr[i].Besitzer == nameSpieler) {
                eigeneGebaudeArr[i] = gebaeudeArr[i].ID;

            }
        }
        return eigeneGebaudeArr;
    }

    @Override
    public String aktuellerSpieler() {
        //TODO Prof fragen -> Brauchen wir das in den Daten
        return null;
    }

    @Override
    public Zustand spielZustandHolen() {
        //TODO Prof fragen -> Brauchen wir das in den Daten
        return null;
    }

    @Override
    public boolean spielZustandSetzen(Zustand aktuellerZustand) {
        //TODO Prof fragen -> Brauchen wir das in den Daten
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
        //TODO Warten auf anzahlBonuskarten klärung
        return false;
    }

    @Override
    public Integer anzahlDerBonuskarten(String nameSpieler, Bonuskarte typBonuskarte) {
        //TODO Klasse Spieler brauch noch datentyp Bonuskarten
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
/*
   public int randomMission(int spieler1,int spieler2, int spieler3, int spieler4,int spieler5 , int high){
       int random = (int)Math.random()*high;
        if(random == spieler1 || random == spieler2 || random == spieler4 || random == spieler4 || random == spieler5){
            return randomMission(spieler1,spieler2,spieler3,spieler4,spieler5 ,high);
        }
          return random;
   }*/
}
