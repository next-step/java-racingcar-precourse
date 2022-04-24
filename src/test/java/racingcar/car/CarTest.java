package racingcar.car;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.DisplayedParameterizedTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayedParameterizedTest
    @CsvSource({"나는자동차", "imcar", "a"})
    void 자동차_모델_생성(String carName) {
        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @DisplayedParameterizedTest
    @MethodSource("자동차_모델_생성_예외_발생_케이스")
    void 자동차_모델_생성_예외_발생(String carName, String errorMessage) {
        assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }

    static List<Arguments> 자동차_모델_생성_예외_발생_케이스() {
        return Arrays.asList(
                Arguments.of("이건여섯글자", "자동차 이름은 1~5 글자만 허용됩니다"),
                Arguments.of("", "자동차 이름은 1~5 글자만 허용됩니다"),
                Arguments.of("공백 멈춰", "자동차 이름은 한글/영문만 허용됩니다"),
                Arguments.of("특문!멈춰", "자동차 이름은 한글/영문만 허용됩니다"),
                Arguments.of("漢字멈춰", "자동차 이름은 한글/영문만 허용됩니다"),
                Arguments.of(null, "자동차 이름은 null 일 수 없습니다")
        );
    }

}