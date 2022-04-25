package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("자동차 이름 부여해 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    void makeCar(String input) {
         Car car = new Car(input);
         assertThat(car.getCarName()).isEqualTo(input);
    }

    @DisplayName("자동차 이름 5글자 초과 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"pobi12", "woni35", "jun123"})
    void makeCarWithOverLength(String input) {
        assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 5글자를 초과할 수 없습니다.");
    }

    @DisplayName("자동차 이름 공백 생성 테스트")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", " "})
    void makeCarWithEmpty(String input) {
        assertThatThrownBy(() -> {
            new Car(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차 이름은 1글자 이상이어야 합니다.");
    }

    @DisplayName("자동차 전진 테스트")
    @Test
    void moveForward() {
        Car car = new Car("test");
        car.moveForward();
        car.moveForward();

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @DisplayName("자동차 전진 또는 멈춤 테스트")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void moveOrStop(String input, String expected) {
        Car car = new Car("test");
        car.moveOrStop(() -> Integer.parseInt(input));

        assertThat(car.getPosition()).isEqualTo(Integer.parseInt(expected));
    }

    @DisplayName("n대 자동차 생성")
    @Test
    void makeCars() {
        Cars cars = new Cars();
        cars.addCar(new Car("test"));
        cars.addCar(new Car("test1"));
        cars.addCar(new Car("test2"));
        cars.addCar(new Car("test3"));

        assertThat(cars.carList().size()).isEqualTo(4);
    }
}
