package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("Car는 name을 가지고 최초 position 값은 0이다.")
    @Test
    void carTest01() {
        String name = "myCar";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("Car는 현재 상태를 주어진 포맷에 맞게 String으로 반환한다.")
    @Test
    void carTest02() {
        String name = "myCar";
        Car car = new Car(name);
        assertThat(car.toStatusString())
                .isEqualTo(name + " : ");
    }

    @DisplayName("Car는 확률적으로 전진할 수 있다.")
    @RepeatedTest(value = 100)
    void carTest03() {
        String name = "myCar";
        Car car = new Car(name);
        if (car.move()) {
            assertThat(car.getPosition()).isEqualTo(1);
        } else {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}