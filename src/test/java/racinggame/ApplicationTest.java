package racinggame;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void 다중라운드() {
        assertRandomTest(() -> {
            run("pobi,woni", "5");
            verify("pobi : ----", "woni : --", "최종 우승자는 pobi 입니다.");
        }, MOVING_FORWARD, STOP
                , STOP, STOP
                , MOVING_FORWARD, MOVING_FORWARD
                , MOVING_FORWARD, MOVING_FORWARD
                , MOVING_FORWARD, STOP);
    }

    @Test
    void 다중우승자() {
        assertRandomTest(() -> {
                    run("pobi,woni,seok", "5");
                    verify("pobi : ----", "woni : --", "seok : --","최종 우승자는 pobi,woni 입니다.");
                }, MOVING_FORWARD, MOVING_FORWARD, STOP
                , MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
                , MOVING_FORWARD, MOVING_FORWARD, STOP
                , MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
                , MOVING_FORWARD, MOVING_FORWARD, STOP);
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
