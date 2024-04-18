import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mockStatic;

class MainTest {

    @Test
    @Timeout(22)
    void main() throws Exception {
        Main.main(new String[]{" "});
    }
}