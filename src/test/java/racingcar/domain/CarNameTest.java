package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarNameTest {
    @Test
    @DisplayName("자동차 이름 입력 예외 테스트")
    void validateInputNameThrowTest() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new CarNumber("AAAAA,BBBBBBB")
        );
    }
}
