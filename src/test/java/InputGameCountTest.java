import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class InputGameCountTest {

    IsValidInput ivi;

    @BeforeEach
    void setUp(){
        ivi = new IsValidInput();
    }

    @Test
    @DisplayName("input game count test")
    public void nameTest(){
        
        //입력된 값이 숫자가 아닐 때
        assertThrows(IllegalArgumentException.class, () -> {
            ivi.isValidCnt("a");;
        });

    }
}
