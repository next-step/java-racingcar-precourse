package racingcar.application;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.application.ValidService.validCarsNameAnswer;
import static racingcar.application.ValidService.validRoundNumberAnswer;

class ValidServiceTest {

    @Test
    @DisplayName("자동차 이름들 마지막에 쉼표가 있다면, 다음 자동차 이름 값이 없는 것으로 간주하여 IllegalArgumentException를 반환한다.")
    void test_validCarsNameAnswer() {
        //given
        String carNameAnswer = "하나,둘,셋,";

        //when
        assertThatThrownBy(() -> validCarsNameAnswer(carNameAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차들의 이름은 쉼표(,)로 구분되어야 합니다.");
    }

    @Test
    @DisplayName("시도할 회수가 숫자가 아니라면 IllegalArgumentException를 반환한다.")
    void test_validRoundNumberAnswerInteger() {
        //given
        String roundNumberAnswer = "삼";

        //when
        assertThatThrownBy(() -> validRoundNumberAnswer(roundNumberAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-3"})
    @DisplayName("시도할 회수가 0이하라면 IllegalArgumentException를 반환한다.")
    void test_validRoundNumberAnswerRange(String roundNumberAnswer) {
        assertThatThrownBy(() -> validRoundNumberAnswer(roundNumberAnswer))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도할 횟수는 1번 이상이어야 합니다.");
    }
}
