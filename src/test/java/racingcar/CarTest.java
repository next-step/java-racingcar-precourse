package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void carNameTest() {
        Car car = Car.of("kkjkk", () -> true);
        assertThat(car.getCarName()).isEqualTo("kkjkk");

        assertThatThrownBy(
                () -> Car.of("superk", () -> true)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void carMoveTest() {
        Car moveCar = Car.of("kkjkk", () -> true);
        Car notMoveCar = Car.of("kkjkk", () -> false);

        moveCar.forward();
        notMoveCar.forward();

        assertThat(moveCar.matchPosition(1)).isTrue();
        assertThat(notMoveCar.matchPosition(0)).isTrue();

    }

    @Test
    void carsComparePositionTest() {
        Car moveCar = Car.of("kkjkk", () -> true);
        Car notMoveCar = Car.of("kkjkk", () -> true);

        moveCar.forward();
        moveCar.forward();
        notMoveCar.forward();

        System.out.println(moveCar.comparePostion(notMoveCar));


    }

    @Test
    void carEqualsPositionTest() {
        Car moveCar = Car.of("kkjkk", () -> true);
        Car notMoveCar = Car.of("kkjkk", () -> true);

        moveCar.forward();
        notMoveCar.forward();

        System.out.println(moveCar.equalsPosition(notMoveCar));

    }

}