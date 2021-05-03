import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarPlayerTest {
    private static final String TEST_CAR_NAME = "test";

    private RandomGenerator randomGenerator;
    private CarPlayer carPlayer;

    @BeforeEach
    void setup() {
        this.randomGenerator = mock(RandomGenerator.class);
        this.carPlayer = new CarPlayer(new CarName(TEST_CAR_NAME), this.randomGenerator);
    }

    @ParameterizedTest
    @CsvSource(value = {"6", "5", "4", "7", "9"})
    @DisplayName("랜덤 값이 전진 조건을 만족할 경우 한 칸 이동한다.")
    void move_car_when_random_value_is_greater_than_or_equal_to_forward_value(int forwardCount) {
        when(this.randomGenerator.get()).thenReturn(Car.MOVE_MIN_RANDOM_VALUE);

        for (int i = 0; i < forwardCount; i++) {
            this.carPlayer.tryMoveCar();
        }

        Assertions.assertThat(this.carPlayer.getMoveCount()).isEqualTo(forwardCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "3", "2", "1"})
    @DisplayName("랜덤 값이 전진 조건을 만족하지 않을 경우 이동하지 않는다.")
    void stay_car_when_random_value_is_less_than_forward_value(int forwardCount) {
        when(this.randomGenerator.get()).thenReturn(Car.STAY_MAX_RANDOM_VALUE);

        for (int i = 0; i < forwardCount; i++) {
            this.carPlayer.tryMoveCar();
        }

        Assertions.assertThat(this.carPlayer.getMoveCount()).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"5:----- (5)", "6:------ (6)", "7:------- (7)", "13:------------- (13)"}, delimiter = ':')
    @DisplayName("자동차가 이동한 만큼 문자열을 표시한다.")
    void print_car_move_state(int forwardCount, String printString) {
        when(this.randomGenerator.get()).thenReturn(Car.MOVE_MIN_RANDOM_VALUE);

        for (int i = 0; i < forwardCount; i++) {
            this.carPlayer.tryMoveCar();
        }

        Assertions.assertThat(this.carPlayer.getMoveCount()).isEqualTo(forwardCount);
        Assertions.assertThat(this.carPlayer.toString()).isEqualTo(TEST_CAR_NAME + " : " + printString);
    }
}
