package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class RacingCarTest {

    private RacingCar racingCar;
    private MovingCheck movingCheck;

    @BeforeEach
    void 테스트_준비() {
        racingCar = new RacingCar("test");
        movingCheck = mock(MovingCheck.class);
    }

    @Test
    void 자동차_움직임_테스트() {
        doReturn(true).when(movingCheck).isMovable();
        racingCar.move(movingCheck);
        assertThat(racingCar.getStatus()).isEqualTo(1);
    }
}
