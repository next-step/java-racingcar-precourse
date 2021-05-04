package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    @Test
    @DisplayName("입력된_자동차_이름_배열_반환_4개")
    void string_car_names_to_list() {
        String carNames = "hello,jeju,kirk,land";
        List<String> listCar = Cars.carNamesToList(carNames);
        assertThat(listCar).contains("hello");
        assertThat(listCar).contains("jeju");
        assertThat(listCar).contains("kirk");
        assertThat(listCar).contains("land");
    }

    @Test
    @DisplayName("입력된_자동차_이름_배열_반환_1개")
    void string_car_names_to_list2() {
        String carNames = "hello";
        List<String> listCar = Cars.carNamesToList(carNames);
        assertThat(listCar).contains("hello");
    }

}
