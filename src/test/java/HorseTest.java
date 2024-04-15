import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HorseTest {

    @Test
    void horseConstructorTest(){
        Horse testHorse = Mockito.mock(Horse.class);
//        Mockito.when(new Horse(null, Mockito.anyDouble(), Mockito.anyDouble())).thenThrow(IllegalArgumentException.class);
        Mockito.when(new Horse(null, Mockito.anyDouble())).thenThrow(IllegalArgumentException.class);
        //        assertThrows(IllegalArgumentException.class, () -> {
//            new Horse(null, Mockito.anyDouble(), Mockito.anyDouble());
//        });

        assertThrows(IllegalArgumentException.class, () -> {
            new Horse(null, Mockito.anyDouble());
        });
    }
}