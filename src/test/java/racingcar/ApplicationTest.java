package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("입력된 이름이 5자가 넘는 경우 예외 처리")
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    @DisplayName("입력된 이름이 비어있는 경우 예외 처리")
    void 이름에_대한_예외_처리2() {
        assertSimpleTest(
                () -> {
                    runException("\n");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    @DisplayName("시도 횟수가 숫자 이외의 값일 때 예외 처리")
    void 시도_횟수에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,java", "abc");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    @DisplayName("시도 횟수가 비어있는 경우 예외 처리")
    void 시도_횟수에_대한_예외_처리2() {
        assertSimpleTest(
                () -> {
                    runException("pobi,java", "\n");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
