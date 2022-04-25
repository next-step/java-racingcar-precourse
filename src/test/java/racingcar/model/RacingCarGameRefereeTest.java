package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameRefereeTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private RacingCarGameReferee racingCarGameReferee;

    @BeforeEach
    public void setUp() {
        this.racingCarGameReferee = new RacingCarGameReferee();
    }

    @Test
    @DisplayName("4이상으로 전진 진행 테스트")
    void racingCarGameRoundsProcessingGoTest() {
        // Given
        RacingCars racingCars = new RacingCars();
        int racingCarGameRoundNumber;
        GameRoundRandomNumberGanerator gameRoundRandomNumberGanerator = new GameRoundRandomNumberGanerator();

        // When
        racingCars.addRacingCar(new RacingCar("poni"));
        racingCarGameRoundNumber = 1;

        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    racingCarGameReferee.racingCarGameRoundsProcessing(racingCars, racingCarGameRoundNumber, gameRoundRandomNumberGanerator);
                },
                MOVING_FORWARD
        );

        assertThat(racingCars.getRacingCars().get(0).getPosition())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("4를 넘지 못해서 전진하지 못하는 테스트")
    void racingCarGameRoundsProcessingStopTest() {
        // Given
        RacingCars racingCars = new RacingCars();
        int racingCarGameRoundNumber;
        GameRoundRandomNumberGanerator gameRoundRandomNumberGanerator = new GameRoundRandomNumberGanerator();

        // When
        racingCars.addRacingCar(new RacingCar("poni"));
        racingCarGameRoundNumber = 1;

        // Then
        assertRandomNumberInRangeTest(
                () -> {
                    racingCarGameReferee.racingCarGameRoundsProcessing(racingCars, racingCarGameRoundNumber, gameRoundRandomNumberGanerator);
                },
                STOP
        );

        assertThat(racingCars.getRacingCars().get(0).getPosition())
                .isEqualTo(0);
    }

}