package racinggame.utils;

import racinggame.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;

public class RacingGameUtils {
    public static final String SPLIT_REGEX = ",";
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final int RACING_CAR_NAME_LENGTH_MIN = 0;
    public static final int RACING_CAR_NAME_LENGTH_LIMIT = 5;

    public static String[] racingCarNameSplit(String racingCarNameInput) {
        return trim(racingCarNameInput.split(SPLIT_REGEX));
    }

    public static void isValidRacingCarNameLengthLimit(String racingCarName) {
        if (racingCarName.length() <= RACING_CAR_NAME_LENGTH_MIN || racingCarName.length() > RACING_CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static String[] trim(String[] target) {
        for (int i = 0; i < target.length; i++) {
            target[i] = target[i].trim();
        }
        return target;
    }

    public static List<RacingCar> getRacingCarList(String racingCarNameInput) {
        List<RacingCar> racingCarList = new ArrayList<>();
        for (String racingCarName : racingCarNameSplit(racingCarNameInput)) {
            racingCarList.add(new RacingCar(racingCarName));
        }
        return racingCarList;
    }
}
