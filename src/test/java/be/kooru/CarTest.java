package be.kooru;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"abcde", "abcdef", "abcdefg"})
    void CAR_INIT(String name) {
        if (name.length() > Car.CAR_NAME_MAX_SIZE) {

            Assertions
                    .assertThatThrownBy(() -> new Car(name))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("Over Car Name Length");

        } else {

            Assertions
                    .assertThat(new Car(name))
                    .isNotNull();
        }
    }

}