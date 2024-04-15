import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HorseTest {

    @Test
    void horseConstructorNullNameExceptionTest(){

        assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 10.0);                   
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, 10.0, 10.0);   
        });
    }

    @Test
    void horseConstructorNullNameExceptionMessageTest(){
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

        assertEquals("Name cannot be null.", test1);
        assertEquals("Name cannot be null.", test2);
    }

    @ParameterizedTest
    @ValueSource(names = {"", " ", "  ", "   "})
    void horseConstructorBlankNameExceptionTest(String name){
        
    }
}