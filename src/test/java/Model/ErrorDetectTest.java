package Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorDetectTest {

    @Test
    @DisplayName("자동차 이름이 5자를 넘는 지를 검출")
    void carNameTest() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ErrorDetect.carNameTest("SuperCar");
        });
        assertEquals("[ERROR] 자동차 이름은 5자 이하만 가능합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("자동차 이름이 공백을 포함하는지를 검출")
    void carNameTest2() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ErrorDetect.roundsIsValid('-');
        });
        assertEquals("[ERROR] 자동차 이름은 공백을 포함할 수 없습니다.", exception.getMessage());
    }

    @Test
    void roundsIsValid() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ErrorDetect.roundsIsValid('-');
        });
        assertEquals("[ERROR] 라운드는 1 이상의 정수만 입력할 수 있습니다.", exception.getMessage());
    }

    @Test
    void roundIsInt() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ErrorDetect.roundIsInt("231231245151536");
        });
        assertEquals("[ERROR] 라운드의 수가 유효 범위를 벗어났습니다.", exception.getMessage());
    }
}