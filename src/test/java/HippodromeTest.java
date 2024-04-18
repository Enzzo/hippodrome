import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
    //  |   HippodromeTest::hippBlankConstructor                                |
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

    //  +-----------------------------------------------------------------------+
    //  |   HippodromeTest::getHorses                                           |
    //  +-----------------------------------------------------------------------+
    //  |   Сверяет сырой список лошадей со списком лошадей в hippodrome        |
    //  +-----------------------------------------------------------------------+
    @Test
    void getHorses() {
        List<Horse> horses = genMockHorses(30);
        Hippodrome hippodrome = new Hippodrome(horses);
        assertEquals(horses, hippodrome.getHorses());
    }

    //  +-----------------------------------------------------------------------+
    //  |   HippodromeTest::move                                                |
    //  +-----------------------------------------------------------------------+
    //  |   Проверяет наличие вызова метода Horse::move через Hippodrome::move  |
    //  +-----------------------------------------------------------------------+
    @Test
    void move() {
        List<Horse> horses = genMockHorses(50);
        new Hippodrome(horses).move();
        for(Horse h : horses){
            Mockito.verify(h).move();
        }
    }

    //  +-----------------------------------------------------------------------+
    //  |   HippodromeTest::getWinner                                           |
    //  +-----------------------------------------------------------------------+
    //  |   Проверяет валидность самого большого значения distance              |
    //  +-----------------------------------------------------------------------+
    @Test
    void getWinner() {
        List<Horse> horses = genHorses(50);
        Hippodrome hippodrome = new Hippodrome(horses);
        for(int i = 0; i < 50; ++i) {
            hippodrome.move();
        }
        double expected = horses.stream().max(Comparator.comparing(Horse::getDistance)).get().getDistance();
        double actual = hippodrome.getWinner().getDistance();
        assertEquals(expected, actual);
    }

    //  +-----------------------------------------------------------------------+
    //  |   HippodromeTest::genHorses                                           |
    //  +-----------------------------------------------------------------------+
    //  |   count - количество лошадей для генерации                            |
    //  |   Возвращает список лошадей для тестов                                |
    //  +-----------------------------------------------------------------------+
    private List<Horse> genHorses(int count){
        List<Horse> horses = new ArrayList<>();
        for(int i = 0; i < count; ++i){
            horses.add(new Horse("horse "+ i, 2 * i, 4 * i));
        }
        return horses;
    }

    //  +-----------------------------------------------------------------------+
    //  |   HippodromeTest::genMockHorses                                       |
    //  +-----------------------------------------------------------------------+
    //  |   count - количество mock-лошадей для генерации                       |
    //  |   Возвращает список mock-лошадей для тестов                           |
    //  +-----------------------------------------------------------------------+
    private List<Horse> genMockHorses(int count){
        List<Horse> horses = new ArrayList<>();
        for(int i = 0; i < count; ++i){
            horses.add(Mockito.mock(Horse.class));
        }
        return horses;
    }
}