package racinggame.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racinggame.domain.GameErrorMessage.ERROR_RACING_CAR_NAME_LENGTH_LIMIT_MESSAGE;
import static racinggame.utils.RacingGameUtils.racingCarNameSplit;

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
                });
    }

    @ParameterizedTest(name = "자동차 이름 [{0}] 길이가 0자 이하면 IllegalArgumentException 발생한다")
    @ValueSource(strings = {","})
    void 쉼표_기준으로_구분한_자동차_이름의_길이가_0자_이하_IllegalArgumentException_발생한다(String racingCarNameInput) {
        for (String racingCarName : racingCarNameSplit(racingCarNameInput)) {
            assertThatExceptionOfType(NoSuchElementException.class)
                    .isThrownBy(() -> {
                        new RacingCarName(racingCarName);
                    });
        }
    }

    @ParameterizedTest(name = "자동차 이름 [{0}] 길이가 5자 초과면 IllegalArgumentException 발생한다")
    @ValueSource(strings = {"javaji,javamaster"})
    void 쉼표_기준으로_구분한_자동차_이름의_길이가_5자_초과_IllegalArgumentException_발생한다(String racingCarNameInput) {
        for (String racingCarName : racingCarNameSplit(racingCarNameInput)) {
            assertThatExceptionOfType(NoSuchElementException.class)
                    .isThrownBy(() -> {
                        new RacingCarName(racingCarName);
                    });
        }
    }

    @ParameterizedTest(name = "자동차 이름 [{0}] 길이가 5자 초과면 메세지를 출력한다")
    @ValueSource(strings = {"javaji,javamaster"})
    void 자동차_이름의_길이가_5자_초과_메세지를_출력한다(String racingCarName) {
        assertThatExceptionOfType(NoSuchElementException.class)
                .isThrownBy(() -> {
                    new RacingCarName(racingCarName);
                })
                .withMessage(ERROR_RACING_CAR_NAME_LENGTH_LIMIT_MESSAGE.getErrorMessage());
    }
}