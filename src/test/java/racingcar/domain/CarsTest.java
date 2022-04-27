package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

import java.util.List;

public class CarsTest {

    @Test
    @DisplayName("차 목록 조회 테스트")
    void cars_get_car_test() {
        Cars cars = new Cars();
        Cars.Test_init();

        List<Car> list = cars.getCars();

        list.add(new Car("one"));
        list.add(new Car("two"));
        list.add(new Car("three"));

        assertThat(cars.getCars()).isEqualTo(list);
    }

    @Test
    @DisplayName("차 목록 사이즈 조회 테스트")
    void car_list_get_size_test() {
        Cars cars = new Cars();
        Cars.Test_init();

        List<Car> list = cars.getCars();

        list.add(new Car("one"));
        list.add(new Car("two"));
        list.add(new Car("three"));
        list.add(new Car("four"));

        assertThat(cars.getCarsSize()).isEqualTo(4);
    }

    @Test
    @DisplayName("차 목록 index별 조회 테스트")
    void cars_get_index_car_test() {
        Cars cars = new Cars();
        Cars.Test_init();

        List<Car> list = cars.getCars();

        list.add(new Car("one"));
        list.add(new Car("two"));
        list.add(new Car("three"));

        assertThat(cars.getCars(0).getName()).isEqualTo("one");
        assertThat(cars.getCars(1).getName()).isEqualTo("two");
        assertThat(cars.getCars(2).getName()).isEqualTo("three");
    }

    @Test
    @DisplayName(",구분자로 자동차 목록 생성 테스트")
    void cars_list_generate_test() {
        Cars cars = new Cars();
        Cars.Test_init();

        InputData inputData = new InputData("one,two,three");

        cars.createCar(inputData);

        assertThat(cars.getCarsSize()).isEqualTo(3);
    }

}
