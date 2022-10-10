package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class RacingCntTest extends NsTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc", " ", "9df92"})
    void 레이싱_횟수_숫자_타입_아닌_값_예외_처리_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCnt(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-4"})
    void 레이싱_횟수_입력값_예외_처리_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new RacingCnt(input);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
