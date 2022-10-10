package racingcar.domain.racing.result;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.car.Car.SEPARATOR;
import static racingcar.domain.car.move.Move.MOVE_FORWARD;
import static racingcar.domain.racing.result.Result.LINE_BREAK;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.domain.car.Car;
import racingcar.domain.car.carname.CarName;
import racingcar.domain.car.carname.validation.DefaultCarNameValidator;
import racingcar.domain.car.move.DefaultMove;

class MoveResultTest {

    Result result;
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
        result = new MoveResult();
    }

    @ParameterizedTest
    @DisplayName("정지:전진:전진 결과 값")
    @CsvSource(value = {"0:4:9"}, delimiter = ':')
    void result(int stop, int move1, int move2) {
        String expected = names[0] + SEPARATOR + LINE_BREAK
                + names[1] + SEPARATOR + MOVE_FORWARD + LINE_BREAK
                + names[2] + SEPARATOR + MOVE_FORWARD + LINE_BREAK
                + LINE_BREAK;
        assertThat(result.moveResult(cars, Arrays.asList(stop, move1, move2))).isEqualTo(expected);
    }

}