package racinggame.utils;

import static racinggame.domain.GameConfig.*;

public class RacingGameUtils {
    public static String[] racingCarNameSplit(final String racingCarNameInput) {
        return trim(racingCarNameInput.split(SPLIT_REGEX.getSplitRegex(), -1));
    }

    public static String[] trim(final String[] target) {
        for (int i = 0; i < target.length; i++) {
            target[i] = target[i].trim();
        }
        return target;
    }
}
