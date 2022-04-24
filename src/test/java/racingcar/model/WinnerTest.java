package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class WinnerTest {
    private static final int MOVE_NUMBER = 5;
    private static final int STOP_NUMBER = 1;
    private CarRepository carCandidates = CarRepository.getInstance();

    @BeforeEach
    void getReadyCarCandidates() {
        carCandidates.clear();
    }

    @RepeatedTest(5)
    @DisplayName("우승자 고르기 검증")
    void selectWinner() {
        int carNum = 10;
        for (int i = 0; i < carNum; i++)
            carCandidates.addCar(new Car("test_" + i));

        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(MOVE_NUMBER,STOP_NUMBER,MOVE_NUMBER,STOP_NUMBER);

            carCandidates.startRound();
            carCandidates.startRound();
            carCandidates.startRound();
            carCandidates.startRound();

            Winner winner = new Winner(carCandidates);
            assertThat(winner.getSize()).isEqualTo(2);
        }
    }

}