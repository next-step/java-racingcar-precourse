package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.constant.MoveStatus;

import static org.junit.jupiter.api.Assertions.*;


class RacingCarMoveServiceTest {

    private RacingCarMoveService racingCarMoveService;

    @BeforeEach
    void before() {
        racingCarMoveService = new RacingCarMoveService();
    }


    @DisplayName("랜덤 넘버가 4 이상이면 FORWARD를 return")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void getMoveStatus_FORWARD(int randomNumber) {

        MoveStatus moveStatus = racingCarMoveService.getMoveStatus(randomNumber);
        assertEquals(MoveStatus.FORWARD, moveStatus);
    }

    @DisplayName("랜덤 넘버가 3 이하면 STOP을 return")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void getMoveStatus_STOP(int randomNumber) {

        MoveStatus moveStatus = racingCarMoveService.getMoveStatus(randomNumber);
        assertEquals(MoveStatus.STOP, moveStatus);
    }

}