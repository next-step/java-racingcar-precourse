package racinggame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import nextstep.test.NSTest;

public class ApplicationTest extends NSTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 전진_정지() {
        assertRandomTest(() -> {
            run("pobi,woni", "1");
            verify("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,javaji");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 횟수에_대한_예외_처리() {
        assertSimpleTest(() -> {
            runNoLineFound("pobi,woni", "00");
            verify(ERROR_MESSAGE);
        });
    }

    @Test
    void 가상_레이싱() {
        assertRandomTest(() -> {
            run("pobi,woni", "4");
            verify("pobi : -", "woni : ", "최종 우승자는 woni 입니다.");
        }, 1, 4, 2, 5, 6, 7, 7, 8);
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }
}
