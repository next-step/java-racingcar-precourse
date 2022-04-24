package racingcar.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;

class ExceptionTest extends NsTest {
    public static Exception exception;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeAll
    static void initAll() {
        exception = new Exception();
    }

    @Test
    void 이름_길이_예외_처리() {
        assertSimpleTest(() -> {
            exception.nameLengthException("LongCarName");
        });
        assertThat(output()).contains(ERROR_MESSAGE, "5자 이하");
    }

    @Test
    void 이름_중복_예외_처리() {
        assertSimpleTest(() -> {
            exception.nameDuplicationException(new String[]{"same", "same"});
        });
        assertThat(output()).contains(ERROR_MESSAGE, "중복");
    }

    @Test
    void 시도_횟수_숫자_이외_값_처리() {
        assertSimpleTest(() -> {
            exception.prepareAttemptException("a");
        });
        assertThat(output()).contains(ERROR_MESSAGE, "숫자만");
    }

    @Override
    protected void runMain() {
    }
}