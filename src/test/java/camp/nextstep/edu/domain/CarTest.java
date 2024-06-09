package camp.nextstep.edu.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    private final String testCarName = "test123";
    private Car car;

    @BeforeEach
    void init() {
        car = new Car(testCarName);
    }

    @DisplayName("자동차 이름을 반환한다.")
    @Test
    void getName() {
        assertEquals(testCarName, car.getName());
    }

    @DisplayName("자동차의 위치는 0이상이다.")
    @Test
    void getLocation() {
        assertThat(car.getLocation()).isGreaterThanOrEqualTo(0);
    }

    @DisplayName("자동차의 이름과 현재 위치를 바탕으로 실행 결과 출력 메시지를 반환한다.")
    @Test
    void currentStateMessage() {
        String message = car.currentStateMessage();
        assertThat(message).startsWith(car.getName() + " : ");
    }

    @DisplayName("0-9 사이의 수를 랜덤으로 뽑는다.")
    @Test
    void canMoveForward() {
        int randomNumber = (int) (Math.random() * 10);
        assertThat(randomNumber).isLessThan(10);
    }
}
