package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.model.enums.Error;

import static org.assertj.core.api.Assertions.*;

@DisplayName("CarName: 자동차 이름")
public class CarNameTest {

    @DisplayName("자동차 이름은 5자 이하만 가능")
    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    void carNameIsLessThan5(String name) {
        CarName carName = new CarName(name);
        assertThat(carName.getName()).isEqualTo(name);
    }

    @DisplayName("자동차 이름에 null 이 들어오면 에러")
    @Test
    void throwExceptionWhenNull() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName(null))
                .withMessage(Error.INVALID_CAR_NAME.message());
    }

    @DisplayName("자동차 이름은 5자 초과하면 에러")
    @Test
    void throwExceptionWhenMoreThan5() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new CarName("abcdef"))
                .withMessage(Error.INVALID_CAR_NAME_RANGE.message());
    }
}
