package racinggame.domain;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import racinggame.utils.Message;

public class RacingCarsTest {

    @DisplayName("자동차들 이동 후 우승자 제대로 불러오는지 확인")
    @Test
    void moveForwardOrStopAndFindWinners_success() {
        try (final MockedStatic<MoveStatus> mockMoveStatus = mockStatic(MoveStatus.class)) {
            mockMoveStatus.when(MoveStatus::createRandom)
                .thenReturn(MoveStatus.FORWARD, MoveStatus.FORWARD, MoveStatus.STOP);
            RacingCars racingCars = new RacingCars("1,2,3");
            racingCars.moveForwardOrStop();
            assertThat(racingCars.findWinners())
                .isEqualTo(new Winners(Arrays.asList(new CarName("1"), new CarName("2"))));
        }
    }

    @DisplayName("자동차 레이싱 실행 결과 메시지 제대로 생성하는지 테스트")
    @Test
    void makeResultMessage_success() {
        RacingCars racingCars = new RacingCars("1,2,3");

        racingCars.moveForwardOrStop(0, MoveStatus.FORWARD);
        racingCars.moveForwardOrStop(1, MoveStatus.FORWARD);
        racingCars.moveForwardOrStop(2, MoveStatus.STOP);

        assertThat(racingCars.makeResultMessage()).isEqualTo(new Message("1 : -\n2 : -\n3 : \n"));
    }

}
