package racingcar;

import main.java.racingcar.domain.Car;
import main.java.racingcar.domain.CarName;
import main.java.racingcar.domain.Cars;
import main.java.racingcar.message.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("createByString 성공 테스트")
    @Test
    void createByStringSuccessTest() {
        Cars cars = Cars.createByString("A,B,C,D");
        Cars answer = new Cars(List.of(
                new Car(new CarName("A")),
                new Car(new CarName("B")),
                new Car(new CarName("C")),
                new Car(new CarName("D"))
        ));
        assertThat(cars.toString()).isEqualTo(answer.toString());
    }

    @DisplayName("createByString 실패 테스트")
    @Test
    void createByStringFailTest() {
        Assertions.assertThatThrownBy(() -> Cars.createByString("A B C D"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_CAR_NAME);
    }

    @DisplayName("commandAllCarsToMove를 실행하면 최개 실행 횟수까지 전진한다.")
    @Test
    void commandAllCarsToMove() {
        Car car1 = new Car(new CarName("car1"));
        Car car2 = new Car(new CarName("car2"));
        Car car3 = new Car(new CarName("car3"));

        Cars cars = new Cars(List.of(car1, car2, car3));

        cars.commandAllCarsToMove();
        cars.commandAllCarsToMove();
        cars.commandAllCarsToMove();

        assertThat(car1.getPosition()).isLessThanOrEqualTo(3);
        assertThat(car1.getPosition()).isLessThanOrEqualTo(3);
        assertThat(car1.getPosition()).isLessThanOrEqualTo(3);
    }
}
