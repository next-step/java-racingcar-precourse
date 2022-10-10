package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarRaceTest {

    @ParameterizedTest
    @ValueSource(strings = {"test,abc,macbook", "abcde,nextstep"})
    @DisplayName("자동차 이름이 5글자를 초과하는 경우 IllegalArgumentException가 발생한다.")
    void check_validate_carname_test(String carNameString) {
        assertThatThrownBy(() ->
            new CarRace(carNameString, "3")
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 이름은 5자 이하만 가능합니다.");

    }

    @ParameterizedTest
    @CsvSource(value = {"test,abc,mac:a", "abcde,next:l"}, delimiter = ':')
    @DisplayName("시도 횟수가 숫자가 아닌 경우 IllegalArgumentException가 발생한다.")
    void check_validate_carname_test(String carNameString, String tryCount) {
        assertThatThrownBy(() ->
            new CarRace(carNameString, tryCount)
        ).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 시도 횟수는 숫자여야 합니다.");
    }
}