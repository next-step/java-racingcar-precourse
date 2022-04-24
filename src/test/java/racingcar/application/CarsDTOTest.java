package racingcar.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsDTOTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "pobi.crong.honux", "pobi", "pobi crong honux"})
    void 예외테스트_옳바르지_못한_입력(final String carNames) {
        Assertions.assertThatThrownBy(() -> new CarsDTO(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

}