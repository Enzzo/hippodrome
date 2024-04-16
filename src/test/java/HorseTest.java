import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HorseTest {

    //  +-----------------------------------------------------------------------+
    //  |   horseNullName()                                                     |
    //  +-----------------------------------------------------------------------+
    //  |   Класс Horse бросает IllegalArgumentException с сообщением           |
    //  |   "Name cannot be null." если name == null                            |
    //  +-----------------------------------------------------------------------+
    @Test
    void horseNullName(){

        // assert-01
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 10.0);                   
        });
        // assert-02
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 10.0, 10.0);   
        });

        String test1 = new String();
        String test2 = new String();

        try{
            Horse testHorse = new Horse(null, 10.0);
        }
        catch(IllegalArgumentException e){
            test1 = e.getMessage();
        }

        try{
            Horse testHorse = new Horse(null, 10.0, 10.0);
        }
        catch(IllegalArgumentException e){
            test2 = e.getMessage();
        }
        // assert-03
        assertEquals("Name cannot be null.", test1);
        // assert-04
        assertEquals("Name cannot be null.", test2);
    }

    //  +-----------------------------------------------------------------------+
    //  |   horseBlankName()                                                    |
    //  +-----------------------------------------------------------------------+
    //  |   Класс Horse бросает IllegalArgumentException с сообщением           |
    //  |   "Name cannot be blank." если name == isBlank                        |
    //  +-----------------------------------------------------------------------+
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "   ", "\n", "\t"})
    void horseBlankName(String name){
        // assert-01
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse(name, 10.0);
        });
        // assert-02
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse(name, 10.0, 10.0);
        });

        String test1 = new String();
        String test2 = new String();

        try{
            Horse testHorse = new Horse(name, 10.0);
        }
        catch(IllegalArgumentException e){
            test1 = e.getMessage();
        }

        try{
            Horse testHorse = new Horse(name, 10.0, 10.0);
        }
        catch(IllegalArgumentException e){
            test2 = e.getMessage();
        }

        // assert-03
        assertEquals("Name cannot be blank.", test1);
        // assert-04
        assertEquals("Name cannot be blank.", test2);
    }

    //  +-----------------------------------------------------------------------+
    //  |   horseNegSpd()                                                       |
    //  +-----------------------------------------------------------------------+
    //  |   Класс Horse бросает IllegalArgumentException, с сообщением          |
    //  |   "Speed cannot be negative." если speed < 0.0                        |
    //  +-----------------------------------------------------------------------+
    @Test
    void horseNegSpd(){
        // assert-01
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Horse1", -10.0);
        });
        // assert-02
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Horse2", -10.0, 10.0);
        });

        String test1 = new String();
        String test2 = new String();

        try{
            Horse testHorse = new Horse("Horse1", -10.0);
        }
        catch(IllegalArgumentException e){
            test1 = e.getMessage();
        }

        try{
            Horse testHorse = new Horse("Horse2", -10.0, 10.0);
        }
        catch(IllegalArgumentException e){
            test2 = e.getMessage();
        }
        // assert-03
        assertEquals("Speed cannot be negative.", test1);
        // assert-04
        assertEquals("Speed cannot be negative.", test2);
    }

    //  +-----------------------------------------------------------------------+
    //  |   horseNegDst()                                                       |
    //  +-----------------------------------------------------------------------+
    //  |   Класс Horse бросает IllegalArgumentException с сообщением           |
    //  |   "Distance cannot be negative.", если distance < 0.0                 |
    //  +-----------------------------------------------------------------------+
    @Test
    void horseNegDst(){
        // assert-01
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse("Horse", 10.0, -10.0);
        });

        String test = new String();

        try{
            Horse testHorse = new Horse("Horse", 10.0, -10.0);
        }
        catch(IllegalArgumentException e){
            test = e.getMessage();
        }
        // assert-02
        assertEquals("Distance cannot be negative.", test);
    }

    //  +-----------------------------------------------------------------------+
    //  |   horseGetName()                                                      |
    //  +-----------------------------------------------------------------------+
    //  |   Метод Horse::getName() должен возвращать имя, переданное в          |
    //  |   конструктор                                                         |
    //  +-----------------------------------------------------------------------+
    @ParameterizedTest
    @ValueSource(strings = {"n1", "n2", "n3"})
    void horseGetName(String name){
        assertEquals(name, new Horse(name, 10.0, 10.0).getName());
    }

    //  +-----------------------------------------------------------------------+
    //  |   horseGetSpd()                                                     |
    //  +-----------------------------------------------------------------------+
    //  |   Метод Horse::getSpeed() должен возвращать скорость, переданную в    |
    //  |   конструктор                                                         |
    //  +-----------------------------------------------------------------------+
    @ParameterizedTest
    @ValueSource(doubles = {.0, .00001, 1000000.0, 9999999999.999999999})
    void horseGetSpd(double speed){
        assertEquals(speed, new Horse("horse", speed, 10.0).getSpeed());
    }

    //  +-----------------------------------------------------------------------+
    //  |   horseGetDst()                                                       |
    //  +-----------------------------------------------------------------------+
    //  |   Метод Horse::getDistance() должен возвращать дистанцию,             |
    //  |   переданную в конструктор                                            |
    //  +-----------------------------------------------------------------------+
    @ParameterizedTest
    @ValueSource(doubles = {.0, .00001, 1000000.0, 9999999999.999999999})
    void horseGetDst(double dst){
        assertEquals(dst, new Horse("horse", 10.0, dst).getDistance());

        //  dist == 0.0, если конструктор вызван с двумя параметрами
        assertEquals(0.0, new Horse("horse", 10.0).getDistance());
    }
}