package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.vo.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {


    private Cars cars;
    private Cars cars2;

    @BeforeEach
    void setUp() {
        cars = new Cars("car,race,test");
        cars2 = new Cars("car2,race2,test2");
    }

    @Test
    @DisplayName("자동차_이름_검증")
    void carsNameValidate() {
        assertThat(cars.getCarName(0)).isEqualTo("car");
        assertThat(cars.getCarName(1)).isEqualTo("race");
        assertThat(cars.getCarName(2)).isEqualTo("test");
        assertThat(cars2.getCarName(0)).isEqualTo("car2");
        assertThat(cars2.getCarName(1)).isEqualTo("race2");
        assertThat(cars2.getCarName(2)).isEqualTo("test2");
    }

    @Test
    @DisplayName("자동차_이름_검증_Exception")
    void carsNameValidateException() {
        assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Cars("car, race, testFive"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Cars("car, test, race, car"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("최대 이동거리 확인")
    void isMaxPositino() {
        for (Car car : cars.toList()) {
            car.carMove(5);
            System.out.println("car.getCarName() = " + car.getCarName().getName());
            System.out.println("car.getCarPosition() = " + car.getCarPosition().getPosition());
            System.out.println("car.getCarPosition().isPosition() = " + car.getCarPosition().isPosition());
        }

        System.out.println(cars.isMaxPosition());
        System.out.println(String.join(",",cars.winnerName(cars.isMaxPosition())));
    }
}
