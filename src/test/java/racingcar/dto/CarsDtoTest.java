package racingcar.dto;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsDtoTest {

    @Test
    void 자동차_리스트_변환() {
        //given
        String carsString = "k3, k5, k7, k9";
        String[] carsArray = carsString.split(",");
        List<Car> list = new ArrayList<>();

        //when
        for (String car : carsArray) {
            list.add(Car.of(car));
        }

        Cars cars = new Cars(list);
        Car car = cars.getCars().get(2);

        //then
        assertThat(car.getName().getName()).isEqualTo("k7");
    }

    @Test
    void DTO_Cars_변환_예외_최소_자동차수() {
        assertThatThrownBy(() -> new CarsDto("k3").toDomain())
                .hasMessage("자동차 경주를 위한 최소 2대의 자동차가 필요합니다.");
    }

    @Test
    void DTO_Cars_변환_예외_자동차_이름_길이() {
        assertThatThrownBy(() -> new CarsDto("k3, hyundai").toDomain())
                .hasMessage("자동차 입력 값이 유효하지 않습니다.");
    }
}
