package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RoundTest {
    @DisplayName(value = "음수로 반복 횟수 생성")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-3", "-100", "-29", "-346"})
    void 음수로_반복_횟수_생성(String round) {
        assertThatThrownBy(() -> new Round(round)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "문자 포함한 값으로 반복 횟수 생성")
    @ParameterizedTest
    @ValueSource(strings = {"car10car", "test123", "10번", "15회"})
    void 문자_포함한_값으로_반복_횟수_생성(String round) {
        assertThatThrownBy(() -> new Round(round)).isInstanceOf(IllegalArgumentException.class);
    }
}
