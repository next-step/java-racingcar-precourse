package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;
import static racingcar.BaseConstants.MAX_RANDOM_NUMBER_RANGE_OF_MOVING_FORWARD;
import static racingcar.BaseConstants.MIN_MOVING_FORWARD_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

/**
 * @author jinyoung
 * @since 2022/04/23
 */
public class RacingPlayerTest {

    private RacingPlayer racingPlayer;

    @BeforeEach
    protected final void init() {
        racingPlayer = new RacingPlayer("mango");
    }

    @Test
    @DisplayName("RacingPlayerMoving: 경주 플레이어가 생성한 랜덥 값이 4 이상인 경우 전진하는지 검증")
    void 생성한_랜덤값이_4이상인경우_전진하는지_RacingPlayerMoving_test() {
        assertPlayerTryForwardResult(MIN_MOVING_FORWARD_NUMBER, 1);
        assertPlayerTryForwardResult(MIN_MOVING_FORWARD_NUMBER + 1, 2);
        assertPlayerTryForwardResult(MAX_RANDOM_NUMBER_RANGE_OF_MOVING_FORWARD, 3);
    }

    @Test
    @DisplayName("RacingPlayerMoving: 경주 플레이어가 생성한 랜덤 값이 3 이하인 경우 멈추는지 검증")
    void 생성한_랜덤값이_3이하인경우_멈추는지_RacingPlayerMoving_test() {
        assertPlayerTryForwardResult(MIN_MOVING_FORWARD_NUMBER - 1, 0);
        assertPlayerTryForwardResult(MIN_MOVING_FORWARD_NUMBER + 1, 1);
        assertPlayerTryForwardResult(MIN_MOVING_FORWARD_NUMBER - 1, 1);
    }

    void assertPlayerTryForwardResult(Integer expectedRandomNumber, int expectedMovingForwardCount) {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(expectedRandomNumber);
            racingPlayer.tryMovingForward();
            assertEquals(expectedMovingForwardCount, racingPlayer.getMovingForwardCount());
        }
    }
}
