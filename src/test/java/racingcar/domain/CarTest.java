package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void 자동차_생성(String name) {
        Car car = new Car(name);

        assertThat(car.getName()).isEqualTo(new Name(name));
        assertThat(car.getPosition()).isEqualTo(new Position());
    }

    @Test
    void 자동차는_한칸만_이동가능() {
        Car car = new Car("yang");
        car.move(() -> true);

        Position movedPosition = new Position();
        movedPosition.increase();
        assertThat(car.getPosition()).isEqualTo(movedPosition);
    }

    @Test
    void 자동차는_이동하지_않을_수_있다() {
        Car car = new Car("yang");
        car.move(() -> false);

        Position notMovedPosition = new Position();
        assertThat(car.getPosition()).isEqualTo(notMovedPosition);
    }
}
