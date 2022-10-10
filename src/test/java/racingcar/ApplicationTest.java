package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.domain.Cars.ERROR_MESSAGE_CAR_NAME_IS_DUPLICATED;

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
    @DisplayName("중복된 자동차 이름을 입력한 경우 예외가 발생한다.")
    void 이름에_대한_예외_처리_중복된_이름() {
        assertSimpleTest(
                () -> {
                    runException("same,same");
                    assertThat(output()).contains(ERROR_MESSAGE_CAR_NAME_IS_DUPLICATED);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
