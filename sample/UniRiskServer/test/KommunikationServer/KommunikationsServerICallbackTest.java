/*Ehrlich gesagt wüsste ich nicht was bei den Methoden dieser Schnittstelle testen könnte. Alle Methoden
* geben nur Information weiter. Ich kann natürlich einen Test für erfolgreich, nicht erfoglreich schreiben, aber ich
* glaube dass sollten wir ja nicht machen.*/

package KommunikationServer;

import org.junit.jupiter.api.*;

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)

@DisplayName("Test der Callback Schnittstelle")
public class KommunikationsServerICallbackTest {

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


}
