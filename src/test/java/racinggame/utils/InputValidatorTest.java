package racinggame.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "hans,you,my"})
    void 사용자가_입력한_플레이어들의_이름이_유효할_경우_IllegalArgumentException이_발생하지_않는다(String playerNamesInput) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new InputValidator().validatePlayerNames(playerNamesInput.split(",", 0)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"apobicx,difosionc,vvvggg", "voiz,,vff"})
    void 사용자가_입력한_플레이어들의_이름이_유효하지_않을_경우_IllegalArgumentException이_발생한다(String playerNamesInput) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputValidator().validatePlayerNames(playerNamesInput.split(",", 0)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10, 100})
    void 사용자가_입력한_게임_횟수가_유효할_경우_IllegalArgumentException이_발생하지_않는다(int gameTurnInput) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new InputValidator().validateGameTurnCnt(gameTurnInput));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, -100, -99999})
    void 사용자가_입력한_게임_횟수가_유효하지_않을_경우_IllegalArgumentException이_발생한다(int gameTurnInput) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputValidator().validateGameTurnCnt(gameTurnInput));
    }
}
