package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "fefgge", "testtttt"})
    void 자동차_이름_길이_초과(String inputValue) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new CarName(inputValue));
    }
}
