package Spieldaten;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import Spieldaten.ISpieldaten;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der ISpieldaten Schnittstelle")
class SpieldatenTest {

    ISpieldaten spieldaten = null;

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
    void anzahlGebaeudeSpielerTest(String nameSpieler){
        System.out.println("[AnzahlGebäudeSieler] läuft");
        //assertEquals(5, spieldaten.anzahlGebaeudeSpieler("David"),"Ungleich");
    }

    @Test
    void besitzerGebaeudeTest(Integer gebaeude){
        System.out.println("[BesitzerGebäude] läuft");
        assertEquals("David", spieldaten.besitzerGebaeude(1));
    }

    @Test
    void besitzerGebaeudeAnpassenTest(Integer gebaeude, String nameSpieler){
        System.out.println("[BesitzerGebäudeAnpassen] läuft");
        assertEquals(true, spieldaten.besitzerGebaeudeAnpassen(1, "David"));

    }


}
