package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racinggame.utils.RacingGameUtils.ERROR_MESSAGE;

class RacingCarNameTest {
    @ParameterizedTest(name = "{0} 자동차 이름 객체를 생성한다")
    @ValueSource(strings = {"crong"})
    void 자동차_이름_객체를_생성한다(String racingCarNameInput) {
        assertThat(new RacingCarName(racingCarNameInput).getRacingCarName()).isEqualTo(racingCarNameInput);
    }

    @ParameterizedTest(name = "[{0}] 자동차 이름 객체 유효성을 검증한다")
    @ValueSource(strings = {"javaji", ""})
    void 자동차_이름_객체_유효성을_검증한다(String racingCarNameInput) {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> {
                    new RacingCarName(racingCarNameInput);
                }).withMessage(ERROR_MESSAGE);
    }
}