package racingcar.util;

import java.util.Objects;

public class ValidationUtils {
    public static final int MAX_LENGTH = 5;
    public static final int MAX_POSITION = 9;
    public static final int MIN_POSITION = 0;

    public static boolean validCarName(String name) {
        return Objects.nonNull(name) && !name.trim().isEmpty() && (name.length() <= MAX_LENGTH);
    }

    public static boolean validCarPosition(int position) {
        return MIN_POSITION <= position && position <= MAX_POSITION;
    }

    public static boolean validRaceRound(String round) {
        try {
            Integer.parseInt(round);
        } catch (NumberFormatException e) {
            return false;
        }
        return round.matches("\\d+");
    }
}
