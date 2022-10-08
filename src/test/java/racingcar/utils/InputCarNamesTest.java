package racingcar.utils;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.utils.RacingCarConstants.MSG_CAR_NAME_DUPLICATE_EXCEPTION;
import static racingcar.utils.RacingCarConstants.MSG_GAME_PARTICIPANT_ILLEGAR_EXCEPTION;

public class InputCarNamesTest extends NsTest {
    @Test
    @DisplayName("자동차 이름 입력 테스트")
    void 자동차_이름_입력_테스트() {
        //given
        String inputCli = "abc,def,ghi";
        String[] expectedStr = {"abc", "def", "ghi"};

        //when
        System.setIn(new ByteArrayInputStream(inputCli.getBytes(StandardCharsets.UTF_8)));
        String[] carName = InputCarNames.inputCarNames();

        //then
        assertThat(expectedStr).containsExactly(carName);
    }

    @DisplayName("입력받은 이름 중 중복 시 예외처리")
    @Test
    void 이름_중복_체크() {
        assertSimpleTest(
                () -> {
                    runException("pobi,dobi,pobi");
                    assertThat(output()).contains(MSG_CAR_NAME_DUPLICATE_EXCEPTION);
                }
        );
    }

    @DisplayName("참가자 인원이 2 미만인 경우 예외처리")
    @Test
    void 참가자_인원_부족_테스트() {
        assertSimpleTest(
                () -> {
                    runException("pobi");
                    assertThat(output()).contains(MSG_GAME_PARTICIPANT_ILLEGAR_EXCEPTION);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
