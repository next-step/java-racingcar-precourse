package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.racing.RacingCarNames;
import racingcar.racing.RacingMoveCount;

public class RacingPropertiesInput {

    private final static Character delimiter = ',';

    public static RacingCarNames requireCarNames() {
        String str = Console.readLine();
        String[] split = str.split(String.valueOf(delimiter));
        List<String> carNames = Arrays.asList(split);
        return new RacingCarNames(carNames);
    }

    public static RacingMoveCount requireMoveCount() {
        String s = Console.readLine();
        try {
            return new RacingMoveCount(Integer.parseInt(s));
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("[ERROR] 시도 회수는 숫자여야 합니다.");
        }
    }

}
