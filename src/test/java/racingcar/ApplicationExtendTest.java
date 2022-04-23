package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationExtendTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 시도_횟수가_숫자가_아닐_경우_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("rock,pro", "a1");
                    assertThat(output()).contains(ErrorMessage.LAP_COUNT_NOT_NUMBER);
                }
        );
    }

    @Test
    void 최소_자동차_개수_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("rock");
                    assertThat(output()).contains(ErrorMessage.ENTRY_NOT_VALID_SIZE);
                }
        );
    }

    @Test
    void 자동차_이름_빈값일_경우_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("rock,,pro");
                    assertThat(output()).contains(ErrorMessage.CAR_NAME_EMPTY);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
