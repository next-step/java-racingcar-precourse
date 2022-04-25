package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNamesTest {

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    @DisplayName("자동차_이름_검증_테스트")
    void 자동차_이름_검증_테스트(String carNames) {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        new CarNames(carNames)).isInstanceOf(IllegalArgumentException.class)
        );
    }
}
