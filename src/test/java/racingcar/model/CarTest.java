package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"123456", ""})
    void 자동차_이름은_1자_이상_5자_이하(String input) {
        assertThatThrownBy(() -> new Car(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
