package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void create_car_test() {
        //given
        final String carName = "sunki" ;
        //when
        Car newCar = new Car(carName);
        //then
        assertThat(newCar.getCarName()).isEqualTo(carName);
        assertThat(newCar.getCarPosition()).isZero();
    }

    @DisplayName("boolean 값에 따라 한칸 전진 한다.")
    @ParameterizedTest
    @CsvSource(value = {"true, 1", "false, 0"})
    void move_test(boolean goOrNot, int expectedPosition) {
        //given
        final String carName = "sunki" ;
        Car car = new Car(carName);
        //when
        car.move(goOrNot);
        //then
        assertThat(car.getCarPosition()).isEqualTo(expectedPosition);
    }
}
