package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("자동차 이름 입력 성공")
    void 자동차_이름_입력() {
        Cars cars = new Cars("car1,car2,car3,car4");
        assertThat(cars.countCars()).isEqualTo(4);
        assertThat(cars.getCarList().get(0).getName()).isEqualTo("car1");
        assertThat(cars.getCarList().get(3).getName()).isEqualTo("car4");
    }

    @Test
    @DisplayName("자동차 이름 입력 실패")
    void 자동차_이름_입력_실패() {
        assertThatThrownBy(() ->{
            Cars cars = new Cars("car1,car222,car3,car4");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자 이하만 가능합니다.");
    }
}
