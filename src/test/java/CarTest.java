import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("차량 이름 검증 테스트")
    void carNameLengthTest() {
        assertThatThrownBy(() -> new Car("testLongName")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Car.move() 반복 후 이동 여부 테스트")
    void carMoveTest(){
        Car car = new Car("car1");
        for (int i = 0; i < 1000; i++){
            car.move();
        }
        assertThat(car.getPos()).isNotZero();
    }
}
