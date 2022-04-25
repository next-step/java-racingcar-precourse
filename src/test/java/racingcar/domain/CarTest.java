package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스 테스트 시작")
public class CarTest {
    @Test
    @DisplayName("Car 클래스 생성 성공 - name 유효성 검증, distance 초기화")
    public void checkCar() {
        Car car = new Car(new CarName("eunji"));
        assertThat(car.getName()).isEqualTo("eunji");
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("distance가 1로 증가되면 통과")
    public void checkIncreaseDistance() {
        Car car = new Car(new CarName("eunji")).increaseDistance();
        assertThat(car.getDistance()).isEqualTo(1);
    }
}
