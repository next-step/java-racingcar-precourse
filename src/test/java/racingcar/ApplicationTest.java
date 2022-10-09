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

    private static final int TEST_INPUT_ZERO = 0;
    private static final int TEST_INPUT_ONE = 1;
    private static final int TEST_INPUT_TWO = 2;

    private static final int TEST_INPUT_FIVE = 5;
    private static final int TEST_INPUT_SIX = 6;
    private static final int TEST_INPUT_SEVEN = 7;
    private static final int TEST_INPUT_EIGHT = 8;
    private static final int TEST_INPUT_NINE = 9;

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
    void _3인_경주_전진_정지_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,dong", "2");
                    assertThat(output()).contains("pobi : -", "woni : ", "dong : -", "pobi : --", "woni : -", "dong : -", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, TEST_INPUT_FIVE, TEST_INPUT_NINE, TEST_INPUT_SEVEN, TEST_INPUT_TWO
        );
    }

    @Test
    void _3인_경주_공동우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,dong", "3");
                    assertThat(output()).contains("pobi : -", "woni : -", "dong : ", "pobi : --", "woni : -", "dong : -", "pobi : --", "woni : -", "dong : --","최종 우승자 : pobi,dong");
                },
                MOVING_FORWARD, TEST_INPUT_EIGHT, TEST_INPUT_ONE, TEST_INPUT_NINE, TEST_INPUT_TWO, TEST_INPUT_SIX, TEST_INPUT_ZERO, STOP, TEST_INPUT_FIVE
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
    void 공백에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("po bi,ji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"one", "원", "12!"})
    void 라운드에_대한_예외_처리(String roundInput) {
        assertSimpleTest(
                () -> {
                    runException("pobi,ji", roundInput);
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
