package racingcar.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {

    @Test
    @DisplayName("이름이 공백인 자동차 생성")
    public void testGenerateEmptyNameCar() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarName.generate("");
        });
    }

    @Test
    @DisplayName("이름 글자수를 초과하는 자동차 생성")
    public void testGenerateExceededNameCharacterCountCar() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CarName.generate("123456");
        });
    }
}
