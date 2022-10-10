package racingcar.domain;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RaceTest  extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private Race race;

    @BeforeEach
    void initRace() {
        List<String> names = Arrays.asList("yb","pobi","java");
        race = new Race(new Cars(names),1);
    }

    @Test
    @DisplayName("승리한사람 이름 확인")
    void roundWinnersName() {
        assertRandomNumberInRangeTest(
                () -> {
                    runMain();
                    assertThat(race.roundWinnersName()).isEqualTo("yb,java");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        race.start();
    }
}