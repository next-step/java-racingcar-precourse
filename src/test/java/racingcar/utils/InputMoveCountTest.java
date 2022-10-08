package racingcar.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingcar.utils.RacingCarConstants.MSG_MOVE_COUNT_LENGTH_EXCEED_EXCEPTION;
import static racingcar.utils.RacingCarConstants.MSG_MOVE_MIN_VALUE_EXCEPTION;

public class InputMoveCountTest extends NsTest {
    @DisplayName("입력받은 시도할 횟수에 대한 정상 입력 확인")
    @Test
    public void 시도할_횟수_정상_입력_테스트() {
        //given
        String inputCli = "5";
        int expectedNum = 5;

        //when
        System.setIn(new ByteArrayInputStream(inputCli.getBytes(StandardCharsets.UTF_8)));
        int moveCount = InputMoveCount.inputMoveCount();

        //then
        assertThat(moveCount).isEqualTo(expectedNum);
    }

    @DisplayName("입력받은 시도할 횟수에 대한 길이 테스트(최대 4)")
    @Test
    public void 입력받은_숫자_4자리_초과_예외발생() {
        assertSimpleTest(
                () -> {
                    runException("tobi,venue", "555555");
                    assertThat(output()).contains(MSG_MOVE_COUNT_LENGTH_EXCEED_EXCEPTION);
                }
        );
    }

    @DisplayName("입력받은 시도할 횟수에 대한 값 테스트(최소 1)")
    @Test
    public void 입력받은_숫자_1이상_아님_예외발생() {
        assertSimpleTest(
                () -> {
                    runException("tobi,venue", "0");
                    assertThat(output()).contains(MSG_MOVE_MIN_VALUE_EXCEPTION);
                }
        );
    }

    @DisplayName("숫자가 아닌 다른 문자를 입력 했을 때 예외처리 테스트")
    @Test
    public void 입력받은_값이_숫자가_아니면_예외처리() {
        // given
        String inputCli = "asd5";

        // when
        System.setIn(new ByteArrayInputStream(inputCli.getBytes(StandardCharsets.UTF_8)));

        // then
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> InputMoveCount.inputMoveCount());

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
