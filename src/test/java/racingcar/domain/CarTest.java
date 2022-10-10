package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("n대의 자동차 생성에 성공한다.")
    @ParameterizedTest
    @ValueSource(strings = {"mrlee", "jplee", "pobi"})
    void release(String name) {
        // given & when
        Car car = Car.release(name);

        // then
        assertThat(car.getCarName()).isEqualTo(name);
    }

    @DisplayName("자동차의 전진처리 시 한칸 앞으로 간다.")
    @Test
    void move() {
        // given & when
        String name = "mrlee";
        Car car = Car.release(name);
        car.move(5);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
