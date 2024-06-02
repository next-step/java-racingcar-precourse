package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CarNameValidatorTest {

    InputValidator carNameValidator;

    @BeforeEach
    void setUp() {
        carNameValidator = new CarNameValidator();
    }

    @Test
    @DisplayName("자동차 이름 최대 길이 초과 확인 테스트")
    void checkInputValueWithOverLength() {
        List<String> carNameList = Arrays.asList("Sonata", "Starex", "SUV");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.checkInputValue(carNameList);
        });
    }

    @Test
    @DisplayName("중복된 자동차 이름 확인 테스트")
    void checkInputValueWithDuplicate() {
        List<String> carNameList = Arrays.asList("test", "SUV", "test");
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carNameValidator.checkInputValue(carNameList);
        });
    }

    @Test
    @DisplayName("올바른 자동차 이름 리스트 확인 테스트")
    void checkInputValueWithCorrectName() {
        List<String> carNameList = Arrays.asList("test", "SUV", "TEST");
        Assertions.assertDoesNotThrow(() -> {
            carNameValidator.checkInputValue(carNameList);
        });
    }
}