package racingcar.domain.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.CarName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {
    private WinNames winName_alone;
    private WinNames winName_multiple;
    private Result result_alone;
    private Result result_multiple;

    @BeforeEach
    void setUp() {
        winName_alone = new WinNames(Arrays.asList("Jin"));
        result_alone = new Result(winName_alone);
        List<String> names = new ArrayList<>();
        names.add("Jin");
        names.add("Park");
        winName_multiple = new WinNames(names);
        result_multiple = new Result(winName_multiple);
    }

    @Test
    @DisplayName("단독_우승_출력_테스트")
    void printWinNamesTest_alone() {
        String expectNames = "Jin";
        assertThat(result_alone.getWinners()).isEqualTo(expectNames);
    }

    @Test
    @DisplayName("여러명_우승_출력_테스트")
    void printWinNamesTest_multiple() {
        String expectNames = "Jin, Park";
        assertThat(result_multiple.getWinners()).isEqualTo(expectNames);
    }

    @Test
    @DisplayName("우승자_추가_테스트")
    void printWinNamesTest_add_winner() {
        String expectNames = "Jin, Park, Kim";
        result_multiple.addWinner(new CarName("Kim"));
        assertThat(result_multiple.getWinners()).isEqualTo(expectNames);
    }
}
