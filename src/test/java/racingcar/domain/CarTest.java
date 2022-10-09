package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int FIRST_DISTANCE_INDEX = 0;

    @DisplayName("자동차 객체에 전달된 입력값이 이름이 된다")
    @Test
    void 자동차_이름_테스트() {
        Car car = new Car("자동차이름");
        assertThat(car.getName()).isEqualTo("자동차이름");
    }

    @DisplayName("자동차에 4 이상의 값이 전달되면 이동한다")
    @ParameterizedTest
    @ValueSource(strings = {"4", "7", "9"})
    void 자동차_이동_하는_테스트(int input) {
        Car car = new Car("자동차이름");

        car.move(input);

        assertThat(car.getDistances().get(FIRST_DISTANCE_INDEX)).isTrue();
    }

    @DisplayName("자동차에 4 미만 값이 전달되면 이동하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "3"})
    void 자동차_이동_하지않는_테스트(int input) {
        Car car = new Car("자동차이름");

        car.move(input);

        assertThat(car.getDistances().get(FIRST_DISTANCE_INDEX)).isFalse();
    }
}
