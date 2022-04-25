package racingcar.module;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingComputerTest {

    @Test
    void test_compute() {
        // Given
        String names = "test,test1";
        int count = 3;
        RacingComputer computer = new RacingComputer(names, count);

        // When
        assertRandomNumberInRangeTest(
                computer::compute,
                4, 4, 4, 3, 6, 6
        );

        List<String> winnerNames = computer.getWinnerNames();

        // Then
        assertThat(winnerNames.size()).isEqualTo(1);
        assertThat(winnerNames.get(0)).isEqualTo("test");
    }
}