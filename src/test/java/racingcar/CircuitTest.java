package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestUtil.makeRacingCarArrayListWithFixedDistance;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CircuitTest {
    @Test
    @DisplayName("콤마로 구분한 참가 자동차 이름 목록으로 서킷에 자동차 등록이 되는지 검사한다")
    void registerRacingCarEntriesByCommaSeparatedCarNames() {
        CommaSeparatedCarNames car_names = new CommaSeparatedCarNames("a_car,b_car,c_car");
        Circuit test_circuit = new Circuit();

        test_circuit.registerCarEntries(car_names);

        for (int i = 0; i < test_circuit.getLengthOfCarEntries(); ++i) {
            RacingCar car = test_circuit.getRacingCarAt(i);

            assertThat(new String[] {"a_car", "b_car", "c_car"}).contains(car.getCarName().toString());
        }
    }

    Circuit registerLapsCountToCircuit(int lap_count) {
        Laps laps = new Laps(lap_count);
        CommaSeparatedCarNames car_names = new CommaSeparatedCarNames("a_car,b_car");
        Circuit test_circuit = new Circuit();
        test_circuit.registerCarEntries(car_names);
        test_circuit.registerLapsCount(laps);

        return test_circuit;
    }

    @Test
    @DisplayName("잔여 Laps이 0일 때 경기 완료로 알 수 있는지 검사한다")
    void checkFinishedRaceIfRemainingLapsIsZero() {
        Circuit test_circuit = registerLapsCountToCircuit(0);

        boolean finished = test_circuit.isFinished();

        assertThat(finished).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("잔여 Laps이 1 이상이면 경주 완료가 아님을 검사한다")
    void checkInProgressRaceIfRemainingLapsIsGreaterEqualThenZero(int lap_count) {
        Circuit test_circuit = registerLapsCountToCircuit(lap_count);

        boolean finished = test_circuit.isFinished();

        assertThat(finished).isFalse();
    }

    @Test
    @DisplayName("1 Laps 서킷에서 한 바퀴 경주한 후 경주가 완료임을 검사한다")
    void checkFinishedRaceWhenItTakesALap() {
        Circuit test_circuit = registerLapsCountToCircuit(1);

        test_circuit.takeALap();
        boolean finished = test_circuit.isFinished();

        assertThat(finished).isTrue();
    }

    @Test
    @DisplayName("2 Laps 서킷에서 한 바퀴 경주한 후 아직 경주중인지 검사한다")
    void checkInProgressRaceWhenItTakesALap() {
        Circuit test_circuit = registerLapsCountToCircuit(2);

        test_circuit.takeALap();
        boolean finished = test_circuit.isFinished();

        assertThat(finished).isFalse();
    }

    @Test
    @DisplayName("3,4,5 이동한 자동차 목록에서 우승자를 검사한다")
    void getWinnerNameInSoloWinner() {
        String[] sample_data = {"a_car:3", "b_car:4", "c_car:5"};
        RacingCarEntries entries = makeRacingCarArrayListWithFixedDistance(sample_data);
        Laps laps = new Laps(0);
        Circuit circuit = new Circuit(entries, laps);

        CommaSeparatedCarNames winner_names = circuit.getWinnerNames();

        assertThat(winner_names.toString()).isEqualTo("c_car");
    }
}
