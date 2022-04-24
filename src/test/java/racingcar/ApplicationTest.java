package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCarExeception;

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

    @DisplayName("전진 상황에 대한 테스트")
    @Test
    void 기본_진행_상황_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,javaj,", "3");
                    assertThat(output()).contains(
                            "pobi : -"
                            , "woni : "
                            , "javaj : "
                            , "pobi : --"
                            , "woni : -"
                            , "javaj : "
                            , "javaj : -"
                            , "최종 우승자: pobi");
                },
                MOVING_FORWARD, STOP, STOP
                ,MOVING_FORWARD, MOVING_FORWARD, STOP
                ,STOP,STOP,MOVING_FORWARD
        );
    }
    @DisplayName("이름에 대한 초과길이 예외처리를 사용자 정의 Exception Message 로 처리")
    @Test
    void 이름에_대한_예외_처리2() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(RacingCarExeception.EXCEED_LENGTH_OF_NAME_ERROR);
                }
        );
    }
    @Test
    void 이름에_대한_중복_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,pobi,pobi");
                    assertThat(output()).contains(RacingCarExeception.DUPLICATION_ARGUMENTS_ERROR);
                }
        );
    }
    @Test
    void 잘못된_숫자_입력() {
        assertSimpleTest(
                () -> {
                    runException("pobi,pobi,pobi","ten");
                    assertThat(output()).contains(RacingCarExeception.DUPLICATION_ARGUMENTS_ERROR);
                }
        );
    }
    @Test
    void 잘못된_범위의_숫자_입력() {
        assertSimpleTest(
                () -> {
                    runException("pobi","javaj","-1");
                    assertThat(output()).contains(RacingCarExeception.LACK_NUMBER_OF_CARS_ERROR);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
