import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

public class RacingTest {

    @DisplayName("judgeWinner test")
    @ParameterizedTest(name = "{3}")
    @CsvSource({
            "'aa,bb,cc', '0,0,0', 'aa,bb,cc', 'progress가 모두 0인 경우'",
            "'aa,bb,cc', '0,1,2', 'cc', '한명의 우승자만 존재할 경우'",
            "'aa,bb,cc', '5,0,5', 'aa,cc', '다수의 우승자가 존재할 경우'"
    })
    public void judgeWinnerTest(String carNamesStr, String progressesStr, String expectedWinnersStr, String testName) {
        String[] carNames = carNamesStr.split(",");
        int[] progresses = Arrays.stream(progressesStr.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
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
}
