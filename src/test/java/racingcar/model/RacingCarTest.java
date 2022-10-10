package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingCarTest {
    @DisplayName("lap이 1씩 증가하는지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"TRUE,1,1", "FALSE,0,1"}, delimiter = ',')
    void raceOneLap(boolean canMove, int expectedLap, int expectedRecordSize) {
        RacingCar racingCar = new RacingCar(new CarName("test"), new TestMoveStrategy(canMove));

        racingCar.raceOneLap();

        assertThat(racingCar.getCurrentLap().getLap()).isEqualTo(expectedLap);
        assertThat(racingCar.getMoveRecords().getRecords()).hasSize(expectedRecordSize);
    }
}
