package racinggame.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.domain.CarNames;
import racinggame.domain.Laps;

import static org.assertj.core.api.Assertions.assertThat;

public class GameValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = "1234,kijah,adcd")
    void 입략받은_자동차의_이름이_유효한지_확인(String playerInput) {
        CarNames carNames = new CarNames(playerInput);
        ValidateStatus actual = GameValidator.validateCarName(carNames);
        assertThat(actual.isStatus()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings ={"1234마sk,kijah,adcd", "hugo,adcdef"})
    @NullAndEmptySource
    void 입력받은_자동차의_이름_유효하지_않은지_확인(String playerInput) {
        CarNames carNames = new CarNames(playerInput);
        ValidateStatus actual = GameValidator.validateCarName(carNames);
        assertThat(actual.isStatus()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"kijah,adcd", "1234,kijah,adcd"})
    void 경주을_하기_위해서는_2대_이상의_자동차가_참가한지_확인(String playerInput) {
        CarNames carNames = new CarNames(playerInput);
        ValidateStatus actual = GameValidator.validateCarName(carNames);
        assertThat(actual.isStatus()).isTrue();
    }

    @Test
    void 참가한_자동차가_1대로는_경주를_진행할_수_없다() {
        CarNames carNames = new CarNames("kijah");
        ValidateStatus actual = GameValidator.validateCarName(carNames);
        assertThat(actual.isStatus()).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 한_바퀴_이상이어야_경주를_진행할_수_있다(Integer laps) {
        ValidateStatus actual = GameValidator.validateLaps(new Laps(laps));
        assertThat(actual.isStatus()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0"})
    void 한_바퀴_미만이면_경주를_진행할_수_없다(Integer laps) {
        ValidateStatus actual = GameValidator.validateLaps(new Laps(laps));
        assertThat(actual.isStatus()).isFalse();
    }
}
