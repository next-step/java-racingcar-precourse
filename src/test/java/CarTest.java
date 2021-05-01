import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarTest {
    private Car car;

    @BeforeEach
    void setup() {
        this.car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"4", "5", "6", "7", "8", "9"})
    @DisplayName("랜덤 값이 4~9 사이의 정수 값일 경우 자동차를 전진시킨다.")
    void go_forward_when_random_value_is_greater_than_or_equal_to_4(int randomValue) {
        Assertions.assertThat(car.tryMove(randomValue)).isEqualTo(MoveResult.FORWARD);
    }

    @ParameterizedTest
    @CsvSource(value = {"0", "1", "2", "3"})
    @DisplayName("랜덤 값이 0~3 사이의 정수 값일 경우 자동차를 전진시키지 않는다.")
    void stay_when_random_value_is_less_than_or_equal_to_3(int randomValue) {
        Assertions.assertThat(car.tryMove(randomValue)).isEqualTo(MoveResult.STAY);
    }
}
