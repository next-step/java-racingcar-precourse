package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;


class ApplicationTest extends NsTest {
    
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni :", "최종 우승자", "pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리_빈값() {
        assertSimpleTest(
                () -> {
                    runException("", "1,2", "1");
                    assertThat(output()).contains(ExceptionMessage.CAR_NAME_EMPTY.getMessage());
                }
        );
    }

    @Test
    void 이름에_대한_예외_처리_길이5이상금지() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji", "1,2", "1");
                    assertThat(output()).contains(ExceptionMessage.CAR_NAME_MAX_SIZE.getMessage());
                }
        );
    }

    @Test
    void 이름에_대한_예외_처리_중복값() {
        assertSimpleTest(
                () -> {
                    runException("1,1", "1,2", "1");
                    assertThat(output()).contains(ExceptionMessage.CAR_NAME_OVERLAY.getMessage());
                }
        );
    }

    @Test
    void 게임시도횟수_대한_예외_처리_빈값() {
        assertSimpleTest(
                () -> {
                    runException("1,2", "", "1");
                    assertThat(output()).contains(ExceptionMessage.GAME_COUNT_EMPTY.getMessage());
                }
        );
    }

    @Test
    void 게임시도횟수_대한_예외_처리_음수() {
        assertSimpleTest(
                () -> {
                    runException("1,2", "-1", "1");
                    assertThat(output()).contains(ExceptionMessage.GAME_COUNT_NEGATIVE.getMessage());
                }
        );
    }

    @Test
    void 게임시도횟수_대한_예외_처리_한글() {
        assertSimpleTest(
                () -> {
                    runException("1,2", "가", "1");
                    assertThat(output()).contains(ExceptionMessage.GAME_COUNT_NOT_NUMBER.getMessage());
                }
        );
    }

    @Test
    void 게임시도횟수_대한_예외_처리_영어() {
        assertSimpleTest(
                () -> {
                    runException("1,2", "ea", "1");
                    assertThat(output()).contains(ExceptionMessage.GAME_COUNT_NOT_NUMBER.getMessage());
                }
        );
    }

    @Test
    void 게임시도횟수_대한_예외_처리_문자() {
        assertSimpleTest(
                () -> {
                    runException("1,2", "&", "1");
                    assertThat(output()).contains(ExceptionMessage.GAME_COUNT_NOT_NUMBER.getMessage());
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
