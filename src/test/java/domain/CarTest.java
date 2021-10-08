package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("이름과 전진 횟수를 가진 자동차 생성")
    public void createCar(){
        Car car = new Car("lee");

        String carName = car.ofName();
        int carMoveCount = car.ofMoveCount();

        assertThat(carName).isEqualTo("lee");
        assertThat(carMoveCount).isEqualTo(1);
    }
}
