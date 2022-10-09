package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"pobi,javaji", ",", ",pobi", "pobi,", "pobi,pobi"})
    void 이름에_대한_예외_처리(String carNames) {
        assertSimpleTest(
                () -> {
                    runException(carNames);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "0", "2147483648"})
    void 이동_횟수에_대한_예외_처리(String lap) {
        assertSimpleTest(
                () -> {
                    runException("pobi,woni", lap);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 예시와_동일한_시나리오() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,crong,honux", "5");
                    assertThat(output()).contains("pobi : -", "crong : ", "honux : -",
                                                  "pobi : --", "crong : -", "honux : --",
                                                  "pobi : ---", "crong : --", "honux : ---",
                                                  "pobi : ----", "crong : ---", "honux : ----",
                                                  "pobi : -----", "crong : ----", "honux : -----",
                                                  "최종 우승자 : pobi, honux");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 예외_후_재입력_받아서_진행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(",", "pobi,crong,honux", "0", "5");
                    assertThat(output()).contains(ERROR_MESSAGE, ERROR_MESSAGE,
                                                  "pobi : -", "crong : ", "honux : -",
                                                  "pobi : --", "crong : -", "honux : --",
                                                  "pobi : ---", "crong : --", "honux : ---",
                                                  "pobi : ----", "crong : ---", "honux : ----",
                                                  "pobi : -----", "crong : ----", "honux : -----",
                                                  "최종 우승자 : pobi, honux");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
