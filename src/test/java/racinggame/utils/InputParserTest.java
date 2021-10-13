package racinggame.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import racinggame.dto.GameTurnCntDTO;
import racinggame.dto.PlayerNamesDTO;

public class InputParserTest {
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "hans,you,my,jigi:4"}, delimiter = ':')
    void 사용자가_플레이어들의_이름을_입력하면_형식에_맞게_파싱한다(String playerNamesInput, int playerCnt) {
        Assertions.assertThat(new InputParser().parse(new PlayerNamesDTO(playerNamesInput)).size()).isEqualTo(playerCnt);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,crong,honux", "hans,you,my,jigi"})
    void 사용자가_유효한_플레이어_이름을_입력할_경우_IllegalArgumentException이_발생하지_않는다(String playerNamesInput) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new InputParser().parse(new PlayerNamesDTO(playerNamesInput)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"apobicx,difosionc,vvvggg", "voiz,,vff"})
    void 사용자가_유효하지_않은_플레이어_이름을_입력할_경우_IllegalArgumentException이_발생한다(String playerNamesInput) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputParser().parse(new PlayerNamesDTO(playerNamesInput)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 사용자가_유효한_게임_횟수를_입력한_경우_IllegalArgumentException이_발생하지_않는다(String turnCntInput) {
        Assertions.assertThatNoException()
                .isThrownBy(() -> new InputParser().parse(new GameTurnCntDTO(turnCntInput)));
    }


    @ParameterizedTest
    @ValueSource(strings = {"-1", "!", "@", "#", "abc"})
    void 사용자가_유효하지_않은_게임_횟수를_입력한_경우_IllegalArgumentException이_발생한다(String turnCntInput) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new InputParser().parse(new GameTurnCntDTO(turnCntInput)));
    }
}
