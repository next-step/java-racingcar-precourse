package racingcar.model;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameSystemTest {
    RacingGameSystem racingGameSystem;

    @BeforeEach
    void setUp() {
        racingGameSystem = new RacingGameSystem();
    }

    @Test()
    @DisplayName("올바른 자동차 이름 validation 테스트")
    void carCorrectNameValidationTest() {
        String carNames = "bmw,kia,benz";
        assertThatNoException().isThrownBy(() -> racingGameSystem.validateCarNames(carNames));
    }

    @ParameterizedTest()
    @ValueSource(strings = {"sonata", "ffff,ffff", "fff,aaaaaa"})
    @DisplayName("부정확한 자동차 이름 validation 테스트")
    void carIncorrectNameValidationTest(String carNames) {
        assertThatThrownBy(() -> {
            racingGameSystem.validateCarNames(carNames);
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("자동차 경주 횟수 validation")
    void carCountValidationTest() {
        String carCount = "12";
        assertThatNoException().isThrownBy(() -> racingGameSystem.convertGameCountToInteger(carCount));

        String wrongCarCount = "fff";
        assertThatThrownBy(() -> {
            racingGameSystem.convertGameCountToInteger(wrongCarCount);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}