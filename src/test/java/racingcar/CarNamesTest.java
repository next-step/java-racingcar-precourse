package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

@DisplayName("입력한 문자열이 요건에 맞는지 테스트")
public class CarNamesTest {

    CarNames carNames = new CarNames();

    @ParameterizedTest
    @NullSource
    @DisplayName("입력한 문자열이 null인 경우 테스트")
    void carNames_Null(String s) {

        assertThatThrownBy(() -> {
            carNames.isCarNamesNull(s);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("입력한 문자열이 빈 경우 테스트")
    void carNames_Empty(String s) {

        assertThatThrownBy(() -> {
            carNames.isCarNamesEmpty(s);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi"})
    @DisplayName("입력한 문자열에 쉼표가 없는 경우 테스트")
    void carNames_Comma(String s) {

        assertThatThrownBy(() -> {
            carNames.isCarNamesNotInComma(s);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

    }

}
