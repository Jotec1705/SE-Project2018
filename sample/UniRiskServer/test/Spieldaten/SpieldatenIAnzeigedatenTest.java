package Spieldaten;

import org.junit.jupiter.api.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)


@DisplayName("Test der Anzeigedaten Schnittstelle")
class SpieldatenIAnzeigedatenTest {

    public SpieldatenDummy dummy = null;


    @BeforeAll
    public void initVorAllenTests(){
        System.out.println("[Start] Bereite einige Tests vor");
    }


    @BeforeEach
    public  void initVorEinemTest(){
        System.out.println("[Init] Bereite einen konkreten Test vor");

    }

    @AfterEach
    public void testEnde(){
        System.out.println("..Test erfolgreich beendet!!");
    }

    @AfterAll
    public void Aufraeumen(){
        System.out.println("[End] Alle Tests beendet. Räume auf.");

    }





    @Test
    public void testAngreifbareNachbarGebaeude() {
        System.out.println("[AngreifbareNachbarGebaeude] Läuft..");


    }

}
