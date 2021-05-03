package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.model.Car;
import racing.model.Cars;
import racing.model.strategy.RandomMoving;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTests {

    private static final String INPUT_CAR_NAME_DELIMITER = ",";
    private static final int MAX_RANDOM_VALUE = 9;
    private static final int MIN_MOVING_RANGE = 4;

    private List<String> carNames;
    private Cars cars;

    @BeforeEach
    public void 자동차목록_초기화() {
        String inputCarNames = "pobi,crong,honux";
        carNames = Arrays.asList(inputCarNames.split(INPUT_CAR_NAME_DELIMITER));
        cars = new Cars(carNames);
    }

    @DisplayName("자동차목록")
    @Test
    public void 자동차목록() {
        assertThat(cars).isNotNull();
        assertThat(cars.getList())
                .isNotNull()
                .asList();
        for (int i = 0; i < cars.getList().size(); i++) {
            assertThat(cars.getList().get(i).getName())
                    .isNotEmpty()
                    .isEqualTo(carNames.get(i));
        }
    }

    @DisplayName("경주(레이싱)")
    @Test
    public void 경주() {
        cars.race(new RandomMoving(MAX_RANDOM_VALUE, MIN_MOVING_RANGE));

        for (Car car : cars.getList()) {
            assertThat(car.getRecordResult())
                    .isNotNull()
                    .isGreaterThanOrEqualTo(0);
        }
    }

    @DisplayName("경주(레이싱) 3라운드")
    @ParameterizedTest
    @ValueSource(ints = 3)
    public void 경주_3라운드(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars.race(new RandomMoving(MAX_RANDOM_VALUE, MIN_MOVING_RANGE));
        }

        for (Car car : cars.getList()) {
            assertThat(car.getRecordResult())
                    .isNotNull()
                    .isGreaterThanOrEqualTo(1);
        }
    }

    @DisplayName("우승자 목록")
    @ParameterizedTest
    @ValueSource(ints = 3)
    public void 우승자_목록(int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            cars.race(new RandomMoving(MAX_RANDOM_VALUE, MIN_MOVING_RANGE));
        }

        String winners = cars.getWinners();
        System.out.println(winners);

        assertThat(winners).isNotEmpty();
    }

}
