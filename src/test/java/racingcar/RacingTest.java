package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.model.Rule;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingTest extends NsTest {
    @Test
    void 이동_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("1,2", "2");
                assertThat(output()).contains(
                        "1 : ", "2 : -",
                        "1 : -", "2 : --"
                );
            },
            Rule.CAR_STOP_STAND, Rule.CAR_MOVE_STAND,
            Rule.CAR_MOVE_STAND, Rule.CAR_MOVE_STAND
        );
    }

    @Test
    void 우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("1,2", "1");
                    assertThat(output()).contains("최종 우승자: 2");
                },
                Rule.CAR_STOP_STAND, Rule.CAR_MOVE_STAND
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
