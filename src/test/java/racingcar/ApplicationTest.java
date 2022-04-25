package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("게임 실행 중 정상적으로 전진 정차의 결과와 우승자 포맷이 정상적으로 출력되는지 확인한다.")
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
    @DisplayName("모두가 우승자일때 결과 값이 정상적으로 출력되는지 확인한다.")
    void 모두가_우승자() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sebom", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "sebom : --", "최종 우승자: pobi, sebom, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("참가자 3명 중 우승자가 2명일때 결과 값이 정상적으로 출력되는지 확인한다.")
    void 우승자_2명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sebom", "2");
                    assertThat(output()).contains("pobi : --", "woni : --", "sebom : -", "최종 우승자: pobi, woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("참가자 3명 중 우승자가 1명일때 결과 값이 정상적으로 출력되는지 확인한다.")
    void 우승자_1명() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sebom", "2");
                    assertThat(output()).contains("pobi : -", "woni : --", "sebom : -", "최종 우승자: woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP,           MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("게임을 10회 실행 해본 후 결과가 정상적인지 확인한다.")
    void GAME_10회_실행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sebom", "10");
                    assertThat(output()).contains("pobi : ------", "woni : --------", "sebom : --", "최종 우승자: woni");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP,           MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP,           STOP,
                STOP,           MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP,           MOVING_FORWARD, STOP,
                MOVING_FORWARD, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP,           STOP,
                STOP,           MOVING_FORWARD, STOP
        );
    }


    @Test
    @DisplayName("자동차 10대 실행 해본 후 결과가 정상적인지 확인한다.")
    void 자동차_10대_실행() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sebom,bts,bp,ses,hot,bb,2ne1,you", "3");
                    assertThat(output()).contains(
                            "pobi : -",
                            "woni : --",
                            "sebom : --",
                            "bts : -",
                            "bp : --",
                            "ses : ",
                            "hot : ---",
                            "bb : -",
                            "2ne1 : ",
                            "you : ---",
                            "최종 우승자: hot, you");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,           STOP,           STOP, MOVING_FORWARD, MOVING_FORWARD,   STOP, MOVING_FORWARD,
                STOP,           MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,             STOP, MOVING_FORWARD,
                STOP,           STOP,           STOP,           STOP,           MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,             STOP, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("참가자가 0명일 때 에러 메시지를 정상적으로 출력되는지 확인한다.")
    void 자동차_0개() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("", "2");
                    assertThat(output()).contains("[ERROR] 경주할 자동차를 1대 이상 입력해 주세요.");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP,           MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("참가자가 0명일 때 에러 메시지를 정상적으로 출력되는지 확인한다.")
    void 실행회수_0회() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sebom", "0");
                    assertThat(output()).contains("[ERROR] 실행할 횟수를 0 이상 입력해주세요.");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP,           MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("실행 회수가 비정상적으로 입력 되었을 때 에러 메시지를 출력하는지 확인한다.")
    void 실행회수_입력_비정상() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,sebom", "F");
                    assertThat(output()).contains("[ERROR] 잘못된 값을 입력하셨습니다.(정수 입력)");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                STOP,           MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("자동차 이름이 포맷에 맞지 않을 때 에러 메시지를 정상적으로 출력하는지 확인한다.")
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
            () -> {
                runException("pobi,javaji");
                assertThat(output()).contains(ERROR_MESSAGE);
            }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
