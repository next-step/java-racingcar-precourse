package racingcar.domain.racing.result;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.racing.result.Result.SEPARATOR;
import static racingcar.domain.racing.result.WinnerResult.WINNER_PREPEND;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.carname.CarName;
import racingcar.domain.car.carname.validation.DefaultCarNameValidator;
import racingcar.domain.car.move.DefaultMove;

class WinnerResultTest {

    WinnerResult result;
    String[] names = new String[]{"pobi", "woni", "java"};
    List<Car> cars;

    @BeforeEach
    void beforeEach() {
        DefaultCarNameValidator validator = new DefaultCarNameValidator();
        CarName carName1 = new CarName(names[0], validator);
        CarName carName2 = new CarName(names[1], validator);
        CarName carName3 = new CarName(names[2], validator);
        cars = Arrays.asList(new Car(carName1, new DefaultMove()),
                new Car(carName2, new DefaultMove()), new Car(carName3, new DefaultMove()));
        result = new WinnerResult(new MoveResult());
    }

    @ParameterizedTest
    @CsvSource(value = {"0:3:9"}, delimiter = ':')
    void 단독_우승자(int stop1, int stop2, int move2) {
        result.moveResult(cars, Arrays.asList(stop1, stop2, move2));
        assertThat(result.winner(cars)).isEqualTo(WINNER_PREPEND + names[2]);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:4:9"}, delimiter = ':')
    void 공동_우승자(int stop, int move1, int move2) {
        result.moveResult(cars, Arrays.asList(stop, move1, move2));
        assertThat(result.winner(cars)).isEqualTo(WINNER_PREPEND + names[1] + SEPARATOR + names[2]);
    }
}