package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

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
    void 전진_정지_테스트_2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("lee,suk,june", "2");
                    assertThat(output()).contains("lee : --", "suk : --", "june : --", "최종 우승자: lee, suk, june");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 전진_정지_테스트_3() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("lee,suk,june", "2");
                    assertThat(output()).contains("lee : --", "suk : --", "june : ", "최종 우승자: lee, suk");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
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
    void 비어있는_이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("lee,,june");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 같은_이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("lee,lee,suk,june");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @ParameterizedTest
    @MethodSource("invalid_try_count_parameter")
    void 시도횟수를_올바르지않게_입력한_경우_예외처리(String tryCount) {
        assertSimpleTest(
                () -> {
                    runException("lee,suk,june", tryCount);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    static Stream<String> invalid_try_count_parameter() {
        return Stream.of("-1", "a", "한글");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
