package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputCarNamesTest {

    public static final String SPLITTER = ",";

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    @DisplayName("사용자 입력 자동차 이름 생성 성공 테스트")
    void valueOf(String carNameString) {
        // given
        final String[] splitStrings = carNameString.split(SPLITTER);
        final int splitSize = splitStrings.length;

        // when
        final InputCarNames inputCarNames = InputCarNames.valueOf(carNameString);

        // then
        assertThat(inputCarNames.count()).isEqualTo(splitSize);

    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdefg,",",,,"})
    @DisplayName("사용자 입력 자동차 이름 생성 실패 테스트")
    void valueOf_exception(String carNameString) {
        // given

        // when & then
        assertThatThrownBy(() -> InputCarNames.valueOf(carNameString))
                .isInstanceOf(IllegalArgumentException.class);

    }
}