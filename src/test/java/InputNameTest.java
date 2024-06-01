import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputNameTest {
    
    IsValidInput ivi;

    @BeforeEach
    void setUp(){
        ivi = new IsValidInput();
    }

    @Test
    @DisplayName("input name test")
    public void nameTest(){
        
        //입력된 이름이 5자 초과일 때
        assertThrows(IllegalArgumentException.class, () -> {
            ivi.isValidNames("abcdef,wkk");
        });

        //입력값에 공백이 섞여있을 때 
        assertThrows(IllegalArgumentException.class, () -> {
            ivi.isValidNames("ab cd,wkk");
        });

        //입력된 이름이 중복될 때
        assertThrows(IllegalArgumentException.class, () -> {
            ivi.isValidNames("abc,abc");
        });
    }

}
