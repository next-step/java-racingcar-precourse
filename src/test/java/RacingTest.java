import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class RacingTest {
    @DisplayName("nextMove test")
    @ParameterizedTest(name = "남은 시도 횟수가 {0} 일 때, {1}이 반환되는가")
    @CsvSource({
            "5, true",
            "0, false",
            "1, true"
    })
    public void nextMoveTest(int leftTryCnt, boolean expected) {
        String[] carNames = {"aa", "bb", "cc"};

        Racing model = new Racing(carNames, leftTryCnt);

        Assertions.assertThat(model.nextMove())
                .isEqualTo(expected);
    }

    @DisplayName("judgeWinner test")
    @ParameterizedTest(name = "{3}")
    @CsvSource({
            "'aa,bb,cc', '0,0,0', 'aa,bb,cc', 'progress가 모두 0인 경우'",
            "'aa,bb,cc', '0,1,2', 'cc', '한명의 우승자만 존재할 경우'",
            "'aa,bb,cc', '5,0,5', 'aa,cc', '다수의 우승자가 존재할 경우'"
    })
    public void judgeWinnerTest(String carNamesStr, String progressesStr, String expectedWinnersStr, String testName) {
        String[] carNames = carNamesStr.split(",");
        int[] progresses = toIntArray(progressesStr);
        String[] expectedWinners = expectedWinnersStr.split(",");

        Racing model = new Racing(carNames, 5);
        CarProgress[] cars = model.getCarProgresses();

        for (int carNum = 0; carNum < cars.length; carNum++) {
            while (progresses[carNum]-- > 0) {
                cars[carNum].move();
            }
        }

        Assertions.assertThat(model.judgeWinners())
                .isEqualTo(expectedWinners);
    }

    private int[] toIntArray(String commaDelimeted) {
        return Arrays.stream(commaDelimeted.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
