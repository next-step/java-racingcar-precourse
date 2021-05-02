package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @Test
    @DisplayName("입력된 이름으로 차 만들기")
    void createCars() {
        Cars cars = new Cars(new String[] {"pobi", "crong", "honux"});

        assertThat(cars.hasCar("pobi")).isTrue();
        assertThat(cars.hasCar("crong")).isTrue();
        assertThat(cars.hasCar("honux")).isTrue();
        assertThat(cars.hasCar("test")).isFalse();
    }

    @Test
    @DisplayName("입력된 이름이 적절하지 않으면 해당 차는 만들지 않음")
    void createCarsWithInvalidCar() {
        Cars cars = new Cars(new String[] {"pobi", "crong", "honux", "rightning"});

        assertThat(cars.hasCar("pobi")).isTrue();
        assertThat(cars.hasCar("crong")).isTrue();
        assertThat(cars.hasCar("honux")).isTrue();
        assertThat(cars.hasCar("rightning")).isFalse();
    }

    @Test
    @DisplayName("참여할 차 추가하기")
    void addCars() {
        Cars cars = new Cars(new String[] {"pobi"});
        cars.addCars(new String[] {"crong", "honux"});

        assertThat(cars.hasCar("pobi")).isTrue();
        assertThat(cars.hasCar("crong")).isTrue();
        assertThat(cars.hasCar("honux")).isTrue();
    }

    @Test
    @DisplayName("차 대수 체크")
    void size() {
        Cars cars = new Cars(new String[] {"Lighting", "Racer"});

        assertThat(cars.getNumOfCars()).isEqualTo(1);
    }
}

