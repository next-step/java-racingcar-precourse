package racingcar.car.domain.models;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.car.domain.errors.CarErrors;

class CarNameTest {

    @DisplayName("정상적으로 이름 객체를 생성한다.")
    @Test
    void create_car_name() {
        // given
        String validName = "sjlee";

        // when, then
        assertThatCode(() -> new CarName(validName))
                .doesNotThrowAnyException();
    }

    @DisplayName("이름 객체를 생성한다. 5글자 이상인 경우에는 에러가 반환되도록 한다.")
    @Test
    void create_car_name_greater_than_5() {
        // given
        String nameLengthGreaterThan5 = "6글자입니다";

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() -> new CarName(nameLengthGreaterThan5))
                .withMessageStartingWith(CarErrors.CAR_NAME_GREATER_THAN_NAME_RULE_ERROR);
    }

    @ParameterizedTest(name = "이름 객체를 생성한다. 이름객체는 비어있을 수 없다.")
    @MethodSource("create_car_name_null_or_empty_parameter")
    void create_car_name_null_or_empty(String emptyName) {
        // given: none

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() -> new CarName(emptyName))
                .withMessageStartingWith(CarErrors.CAR_NAME_EMPTY_ERROR);
    }

    static Stream<String> create_car_name_null_or_empty_parameter() {
        return Stream.of(null, "", " ", "  ", "   ");
    }
}
