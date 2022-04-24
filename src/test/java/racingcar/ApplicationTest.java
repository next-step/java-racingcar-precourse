package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.constant.ErrorStatus;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자: pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                    assertThat(output()).contains(ErrorStatus.CAR_NAME_OVER_MAXIMUM_LENGTH.getMessage());
                }
        );
    }

    @Test
    void 이름_쉼표가_아닌_구분자() {
        assertSimpleTest(
                () -> {
                    runException("pobi..ryan");
                    assertThat(output()).contains(ERROR_MESSAGE);
                    assertThat(output()).contains(ErrorStatus.CAR_NAME_PATTERN_NOT_MATCHED.getMessage());
                }
        );
    }

    @Test
    void 입력이_공백() {
        assertSimpleTest(
                () -> {
                    runException("\n");
                    assertThat(output()).contains(ERROR_MESSAGE);
                    assertThat(output()).contains(ErrorStatus.INPUT_BLANK.getMessage());
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
