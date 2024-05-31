import static org.junit.jupiter.api.Assertions.*;

import DTO.Car;
import Util.Util;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilTest {

    Util u = new Util();

    @Test
    @DisplayName("0~9사이 값인지 검증")
    void generateRandomNumber() {
//        given
        int random = u.generateRandomNumber();

//        when

//        then
        assertTrue(random >= 0 && random <= 9);
    }

}