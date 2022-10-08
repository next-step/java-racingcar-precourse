package racingcar.model.finalwinner.prepare;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.model.racing.car.Advance;
import racingcar.model.racing.car.CarName;
import racingcar.model.racing.car.RacingCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class FinalWinnerDataPreparerTest {
    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2345:2345"}, delimiter = ':')
    public void prepareAndGetMaxAdvanceReturnsCorrectMaxAdvanceFromOneRacingCar(int advance, int expected) {
        ArrayList<RacingCar> racingCars = new ArrayList<>(Arrays.asList(
                new RacingCar(new CarName("1"), new Advance(advance))
        ));
        Map<String, Integer> advanceMap = new HashMap<>();
        FinalWinnerDataPreparer finalWinnerDataPreparer = new FinalWinnerDataPreparer(racingCars, advanceMap);
        int maxAdvance = finalWinnerDataPreparer.prepareAndGetMaxAdvance();
        assertThat(maxAdvance).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1:1", "1:0:1", "33:1:33"}, delimiter = ':')
    public void prepareAndGetMaxAdvanceReturnsCorrectMaxAdvanceFromTwoRacingCars(int advance1,
                                                                                 int advance2,
                                                                                 int expected) {
        ArrayList<RacingCar> racingCars = new ArrayList<>(Arrays.asList(
                new RacingCar(new CarName("1"), new Advance(advance1)),
                new RacingCar(new CarName("2"), new Advance(advance2))
        ));
        Map<String, Integer> advanceMap = new HashMap<>();
        FinalWinnerDataPreparer finalWinnerDataPreparer = new FinalWinnerDataPreparer(racingCars, advanceMap);
        int maxAdvance = finalWinnerDataPreparer.prepareAndGetMaxAdvance();
        assertThat(maxAdvance).isEqualTo(expected);
    }
}
