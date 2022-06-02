package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.utils.RandomNumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

class RacingCarMovingCheckTest {

    private RandomNumber randomNumber;
    private RacingCarMovingCheck racingCarMovingCheck;

    @BeforeEach
    void 테스트_준비() {
        randomNumber = mock(RandomNumber.class);
        racingCarMovingCheck = new RacingCarMovingCheck(randomNumber);
    }


    @Test
    void 전진_조건_성공() {
        doReturn(4).when(randomNumber).generator();
        assertThat(racingCarMovingCheck.isMovable()).isTrue();
    }

    @Test
    void 전진_조건_실패() {
        doReturn(3).when(randomNumber).generator();
        assertThat(racingCarMovingCheck.isMovable()).isFalse();
    }
}