package racinggame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {

    @Test
    @DisplayName("경주하는 차들 일급 컬렉션으로 만들기")
    void createCars() {
        //given

        final Cars cars = Cars.of(Arrays.asList(Car.of(CarName.of("1번차")), Car.of(CarName.of("2번차")), Car.of(CarName.of("3번차"))));
        //when
        final List<Car> carList = cars.getCars();
        //then
        assertThat(carList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 이름은 쉼표를 기준으로 구분한다.")
    void NameSplitComma() {
        //given
        final String input = "1번차,2번차,3번차";
        final String[] inputList = input.split(",");
        ArrayList<Car> carList = new ArrayList<>();
        //when
        for (String name : inputList) {
            carList.add(Car.of(CarName.of(name)));
        }
        final Cars cars = Cars.of(carList);
        //then
        assertThat(cars.getCars().get(0).getCarName().getName()).isEqualTo("1번차");

    }
}
