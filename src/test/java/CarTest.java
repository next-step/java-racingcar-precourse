import java.util.List;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    @DisplayName("Car이름이 없거나 5자를 초과했을 때 오류를 출력하는지 테스트")
    void carNameValidation() {
        assertThatThrownBy(() -> new Car("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("123456")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("무작위 값이 4이상일때 position이 1 증가하고, 4보다 작을때는 position이 증가하지 않는지 테스트")
    void moveCar() {
        Car car = new Car("test");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 이름이 중복되었을 떄, 오류를 출력하는지 테스트")
    void CarNameDup() {
        List<String> carNames = List.of("aaa","aaa","bbb");
        assertThatThrownBy(() -> Car.CarDup(carNames)).isInstanceOf(IllegalArgumentException.class);
    }
}