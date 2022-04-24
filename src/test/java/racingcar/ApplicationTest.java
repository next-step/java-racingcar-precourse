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
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자: pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리_옳바르지_않은_길이() {
        assertSimpleTest(
            () -> {
                runException("pobi,javaji");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Test
    void 입력에_대한_예외_처리_중복된_차량_이름() {
        assertSimpleTest(
                () -> {
                    runException("steve,steve");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 입력에_대한_예외_처리_완전하지_않은_입력_1() {
        assertSimpleTest(
                () -> {
                    runException("steve,");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 입력에_대한_예외_처리_완전하지_않은_입력_2() {
        assertSimpleTest(
                () -> {
                    runException(",steve");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 입력에_대한_예외_처리_라운드_횟수_0() {
        assertSimpleTest(
                () -> {
                    runException("steve,jobs", "0");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 입력에_대한_예외_처리_라운드_문자() {
        assertSimpleTest(
                () -> {
                    runException("steve,jobs", "hello");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
