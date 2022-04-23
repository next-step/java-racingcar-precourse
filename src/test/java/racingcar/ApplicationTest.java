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
                }
        );
    }

    @Test
    void 전진_정지_v2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    assertThat(output()).contains("pobi : --", "woni : ---", "최종 우승자: woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @DisplayName("우승자가 두명 이상이라면 쉼표로 구분되어 출력되어야 한다")
    @Test
    void 전진_정지_v3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,test", "3");
                    assertThat(output()).contains("pobi : -", "woni : ---", "test : ---", "최종 우승자: woni,test");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @DisplayName("레이싱카 모두 0점이라면 모두 공동 우승자가 되어야 한다")
    @Test
    void 전진_정지_v4() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,test", "3");
                    assertThat(output()).contains("pobi : ", "woni : ", "test : ", "최종 우승자: pobi,woni,test");
                },
                STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP, STOP
        );
    }

    @DisplayName("입력한 사용자가 한명이라면 예외가 발생해야 한다")
    @Test
    void 이름에_대한_예외_처리_v2() {
        assertSimpleTest(
                () -> {
                    runException("pobi");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("입력한 사용자 이름에 중복이 있다면 예외가 발생해야 한다")
    @Test
    void 이름에_대한_예외_처리_v3() {
        assertSimpleTest(
                () -> {
                    runException("pobi, wood, pobi");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("시도할 횟수가 1~9 사이의 정수가 아니라면 예외가 발생해야 한다")
    @Test
    void 횟수_대한_예외_처리_문자() {
        assertSimpleTest(
                () -> {
                    runException("pobi, wood", "asd");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("시도할 횟수가 1~9 사이의 정수가 아니라면 예외가 발생해야 한다")
    @Test
    void 횟수_대한_예외_처리_0() {
        assertSimpleTest(
                () -> {
                    runException("pobi, wood", "0");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("시도할 횟수가 1~9 사이의 정수가 아니라면 예외가 발생해야 한다")
    @Test
    void 횟수_대한_예외_처리_9초과() {
        assertSimpleTest(
                () -> {
                    runException("pobi, wood", "13");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @DisplayName("시도할 횟수가 1~9 사이의 정수가 아니라면 예외가 발생해야 한다")
    @Test
    void 횟수_대한_예외_처리_음수() {
        assertSimpleTest(
                () -> {
                    runException("pobi, wood", "-7");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
