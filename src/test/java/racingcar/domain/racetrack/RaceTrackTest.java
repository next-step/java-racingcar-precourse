package racingcar.domain.racetrack;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarNames;
import racingcar.domain.racetrack.Lap;
import racingcar.domain.racetrack.RaceTrack;

public class RaceTrackTest {

    private String inputNameString;
    private int inputLapCountString;

    @BeforeEach
    void setup() {
        //given
        inputNameString = "Test1, Test2, Test3";
        inputLapCountString = 3;
    }

    @Test
    @DisplayName("차량을 초기화 시킨다")
    void 차량_초기화_시킨다() {
        //given
        List<String> carNames = Arrays.asList("Tester1", "Tester2", "Tester3");

        //when
        RaceTrack raceTrack = new RaceTrack(carNames);

        //then
        assertThat(raceTrack.carCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("차량을 Register로 초기화 시킨다")
    void 차량_Register로_초기화_시킨다() {
        //when
        RaceTrack raceTrack = new RaceTrack(new CarNames(inputNameString));

        //then
        assertThat(raceTrack.carCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("레이싱을 시도회수를 등록한다. ")
    void 시도회수를_등록한다() {
        //when
        RaceTrack raceTrack = new RaceTrack(new CarNames(inputNameString),new Lap(inputLapCountString));

        //then
        assertThat(raceTrack.getCurrentLap()).isEqualTo(3);

    }

}
