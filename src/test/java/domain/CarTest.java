package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    @Test
    @DisplayName("Car의 위치와 이름을 입력받아서 생성 TEST")
    void makeCar() {
        Car car = new Car(1, new Name("test"));
        assertAll(
                () -> assertThat(car.carName()).isEqualTo("test"),
                () -> assertThat(car.distance()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("Car이름만 입력받아서 생성 TEST")
    void makeNameCar() {
        Car car = new Car(new Name("test"));
        assertAll(
                () -> assertThat(car.carName()).isEqualTo("test"),
                () -> assertThat(car.distance()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("Car move Test")
    void moveCar() {
        Car car = new Car(new Name("test"));
        Car movedCar = car.move();
        assertAll(
                () -> assertThat(movedCar.carName()).isEqualTo("test"),
                () -> assertThat(movedCar.distance()).isEqualTo(1)
        );
    }

    @Test
    @DisplayName("상수를 입력받아서 4초과이면 움직이고 4이하면 움직이지 않는 테스트")
    void cannotMoveCar() {
        Car car = new Car(new Name("test"));
        assertAll(
                () -> assertThat(car.isMovable(4)).isFalse(),
                () -> assertThat(car.isMovable(5)).isTrue()

        );
    }

    @Test
    @DisplayName("Int 범위 넘어서면 에러내는 테스트")
    void intOverflowMoveCar() {
        assertThatThrownBy(() -> {
            Car car = new Car(Integer.MAX_VALUE, new Name("test"));
            car.move();
        }).isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("자동차가 움직일수 있는 범위를 넘었습니다.(Integer 범위를 넘었습니다.)");
    }

}
