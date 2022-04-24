package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarRepository;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void clearRepository() {
        CarRepository carRepository = CarRepository.getInstance();
        carRepository.clear();
    }

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
    void 참가자_인원수에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 중복된_이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,pobi");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 공백_이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException(" ");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 양수가_아닌_값_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("aaa,bbb", "0");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 너무_큰_값_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("aaa,bbb", "2200000000");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 두명_중복_우승자() {
        assertRandomNumberInRangeTest(() -> {
            run("aaaa,bbbb,shwan", "2");
            assertThat(output()).contains("aaaa : --", "bbbb : -","shwan : -","최종 우승자: aaaa, shwan");
        }, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void 세명_중복_우승자() {
        assertRandomNumberInRangeTest(() -> {
                run("aaaa,bbbb,shwan,soso", "4");
                assertThat(output()).contains("aaaa : ---", "bbbb : ---","shwan : ---", "soso : --","최종 우승자: aaaa, bbbb, shwan");
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,
            STOP, STOP, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Test
    void 참가자_이름_분리_공백_예외() {
        assertSimpleTest(
                () -> {
                    runException("aaa,bbb, ccc,ddd");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 참가자_이름_공백_예외() {
        assertSimpleTest(
                () -> {
                    runException("aaa,bbb,,ddd");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Test
    void 단독_우승자() {
        assertRandomNumberInRangeTest(() -> {
                    run("aaaa,bbbb,shwan,soso", "8");
                    assertThat(output()).contains("aaaa : -----", "bbbb : ------","shwan : ----", "soso : ----","최종 우승자: bbbb");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,
                STOP, STOP, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD,
                STOP, STOP, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP, MOVING_FORWARD, STOP, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
