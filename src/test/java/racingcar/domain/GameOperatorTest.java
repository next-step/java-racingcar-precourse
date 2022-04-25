package racingcar.domain;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_INPUT_IS_NOT_NUMBER;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_INPUT_IS_NULLE;
import static racingcar.common.CommonVariable.ERROR_MESSAGE_INPUT_IS_ONE_LESS;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class GameOperatorTest {

    @DisplayName("레이싱카 게임 진행 횟수 입력 테스트 - 실패(입력값없음)")
    @ParameterizedTest
    @CsvSource(value = {"null"}, nullValues={"null"})
    void gameOperationInputNumberGamesToFailAtInputNull(String numberGamesString){
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    new GameOperator().gameStartInput(numberGamesString);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + ERROR_MESSAGE_INPUT_IS_NULLE);
    }

    @DisplayName("레이싱카 게임 진행 횟수 입력 테스트 - 실패(입력값 숫자 아님)")
    @Test
    void gameOperationInputNumberGamesToFailAtNotInputNumber(){
        // given
        String numberGamesString = "abc";

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    new GameOperator().gameStartInput(numberGamesString);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + ERROR_MESSAGE_INPUT_IS_NOT_NUMBER);
    }

    @DisplayName("레이싱카 게임 진행 횟수 입력 테스트 - 실패(1미만인경우)")
    @ParameterizedTest
    @CsvSource(value = {"0", "-1"})
    void gameOperationInputNumberGamesToFailAtNumberLessOne(String numberGamesString){

        // when & then
        org.assertj.core.api.Assertions.assertThatThrownBy(
                () -> {
                    new GameOperator().gameStartInput(numberGamesString);
                }
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MESSAGE + ERROR_MESSAGE_INPUT_IS_ONE_LESS);
    }

    @DisplayName("레이싱카 게임 진행 횟수 입력 테스트 - 실패(1미만인경우)")
    @ParameterizedTest
    @CsvSource(value = {"2", "10", "100"})
    void gameOperationInputNumberGamesToSuccess(String numberGamesString) {

        // when
        final GameOperator gameOperator = new GameOperator();
        gameOperator.gameStartInput(numberGamesString);
        assertTrue(gameOperator.isSameNumberGames(numberGamesString));

    }
}