import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HippodromeTest {

    //  +-----------------------------------------------------------------------+
    //  |   hippNullConstructor()                                               |
    //  +-----------------------------------------------------------------------+
    //  |   Класс Hippodrome бросает IllegalArgumentException с сообщением      |
    //  |   "Horses cannot be null." если horses == null                        |
    //  +-----------------------------------------------------------------------+
    @ParameterizedTest
    @NullSource
    void hippNullConstructor(List<Horse> horses){
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));

        String test = new String();

        try{
            Hippodrome hippodrome = new Hippodrome(horses);
        }
        catch(IllegalArgumentException e){
            test = e.getMessage();
        }

        assertEquals("Horses cannot be null.", test);
    }

    //  +-----------------------------------------------------------------------+
    //  |   hippBlankConstructor()                                              |
    //  +-----------------------------------------------------------------------+
    //  |   Класс Hippodrome бросает IllegalArgumentException с сообщением      |
    //  |   "Horses cannot be empty." если horses == isBlank                    |
    //  +-----------------------------------------------------------------------+
    @ParameterizedTest
    @EmptySource
    void hippBlankConstructor(List<Horse> horses){
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(horses));

        String test = new String();

        try{
            Hippodrome hippodrome = new Hippodrome(horses);
        }
        catch(IllegalArgumentException e){
            test = e.getMessage();
        }

        assertEquals("Horses cannot be empty.", test);
    }

    @Test
    void getHorses() {
    }

    @Test
    void move() {
    }

    @Test
    void getWinner() {
    }
}