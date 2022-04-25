package racingcar;

import java.util.Objects;

public enum RacingResult {
    Lose, Draw, Win;

    public static boolean isWin(RacingResult result) {
        return Objects.equals(result, Win);
    }

    public static boolean isLose(RacingResult result) {
        return Objects.equals(result, Lose);
    }
}
