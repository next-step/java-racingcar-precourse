package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarGameTest extends NsTest {

    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        racingCarGame = RacingCarGame.getInstance();
    }

    @Test
    @DisplayName("racingCarGame 싱글톤 테스트")
    void racingCarGameTest() {
        RacingCarGame secondRacingCarGame =RacingCarGame.getInstance();
        assertThat(racingCarGame).isEqualTo(secondRacingCarGame);
    }

    @Test
    @DisplayName("run 메서드 테스트")
    void run() {
        assertSimpleTest(
                () -> {
                    run("pobi,java", "5");
                    assertThat(output()).contains("pobi","java","경주할 자동차 이름","실행 결과","최종 우승자");
                }
        );
    }

    @Override
    public void runMain() {
        racingCarGame.run();
    }
}