package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {

    private CarPosition carPosition;
    @BeforeEach
    void setUp() {
        carPosition = new CarPosition();
    }

    @Test
    @DisplayName("carPosition instance는 최초 생성시에 위치 0을 갖는다.")
    void carPositionTest() {
        assertThat(carPosition.isStart()).isTrue();
    }

    @Test
    @DisplayName("호출한 메서드에서 자동차에게 전진하라는 메세지를 날린 경우, 차의 위치는 한칸 전진한다.")
    void moveTest() {
        carPosition.move();
        assertThat(carPosition.getPosition()).isEqualTo(1);
        assertThat(carPosition.getTrace()).isEqualTo("-");
    }
}
