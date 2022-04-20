package racingcar;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarMovePrintTest {

    @Test
    @DisplayName("전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.")
    void print_car_name() {
        Car car = new Car("kkobi");
        car.move(4);
        Assertions.assertThat(car.getPrintString()).contains("kkobi : -");
    }
}
