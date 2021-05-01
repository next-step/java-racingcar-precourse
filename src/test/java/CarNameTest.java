import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CarNameTest {
    @ParameterizedTest
    @CsvSource(value = {"pobi", "crong", "honux", "ssem", "korsa", "!@566", "acx1$", "a"})
    @DisplayName("사용자가 5글자 이하의 자동차 이름을 입력했을 경우 예외를 던지지 않는다.")
    void insert_valid_car_name_not_throw_exception(String userInputCarName) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new CarName(userInputCarName));
    }

    @ParameterizedTest
    @CsvSource(value = {"zxcvewdsfsdaf", "123456", "dsf4567", "%$^&*(!"})
    @DisplayName("사용자가 빈 자동차 이름 혹은 5글자보다 많은 자동차 이름을 입력했을 경우 예외를 던진다.")
    void insert_invalid_car_name_throw_exception(String userInputCarName) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(userInputCarName));
    }

    @Test
    @DisplayName("사용자가 빈 자동차 이름 혹은 공백 문자로만 이루어진 자동차 이름을 입력했을 경우 예외를 던진다.")
    void insert_empty_car_name_throw_exception() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName(""));
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new CarName("   "));
    }
}
