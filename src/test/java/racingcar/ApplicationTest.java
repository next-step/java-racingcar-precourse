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
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
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
                }
        );
    }

    @Test
    void 입력_오류_후_재입력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("aaa,bbb,111111", "aaa,bbb,111111", "pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, STOP, STOP, STOP, STOP
        );
    }

    @Test
    void 모든_자동차_전부_우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("11,22,33,44,55,66,77,88,99,00", "1");
                    assertThat(output()).contains(
                            "11 : -", "22 : -", "33 : -", "44 : -", "55 : -",
                            "66 : -", "77 : -", "88 : -", "99 : -", "00 : -",
                            "최종 우승자 : 11, 22, 33, 44, 55, 66, 77, 88, 99, 00");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 시도_횟수_음수_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,java", "-1", "1");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 시도_횟수_문자_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,java", "hello", "1");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
