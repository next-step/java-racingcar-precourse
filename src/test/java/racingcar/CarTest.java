package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 이름 초기화 테스트")
    public void testInitializeCar() {
        String carName = "car1";
        Car car = new Car(carName);
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    public void testCarMove() {
        Car car = new Car("car1");
        car.move();
        //자동차 이동관련 값, 0또는 1인지 확인
        assertThat(car.getPosition()).isBetween(0, 1);
    }

    @Test
    @DisplayName("자동차 전진 조건 테스트")
    public void testCarMoveCondition() {
        Car car = new Car("car1") {
            @Override
            protected boolean canMove() {
                return true;
            }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 멈춤 조건 테스트")
    public void testCarStopCondition() {
        Car car = new Car("car1") {
            @Override
            protected boolean canMove() {
                return false;
            }
        };
        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}