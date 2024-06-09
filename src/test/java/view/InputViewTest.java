package view;

import model.Car;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    @Test
    void 입력받은_차이름_콤마로_구분() {
        String input = "aaa,bbb, ccc";
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        List<Car> cars = carNames.stream().map(Car::new).toList();

        // 예상되는 Car 객체 생성 확인
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("aaa");
        assertThat(cars.get(1).getName()).isEqualTo("bbb");
        assertThat(cars.get(2).getName()).isEqualTo("ccc");
    }
}