package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
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
                assertThat(output()).contains("최종 우승자: pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 다중라운드로_진행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni, na", "3");
                    assertThat(output()).contains("최종 우승자: pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 다중라운드_공동우승자_진행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni, na", "3");
                    assertThat(output()).contains("최종 우승자: pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD,MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름_입력_실패후_게임_진행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,wonidsadsadd,woni", "pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자: pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 라운드_입력_실패후_게임_진행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "d", "3");
                    assertThat(output()).contains("최종 우승자: pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 공동우승자_처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("최종 우승자: pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,javaji");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 라운드값에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,jav", "d");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
