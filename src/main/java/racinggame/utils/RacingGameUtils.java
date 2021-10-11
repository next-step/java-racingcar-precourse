package racinggame.utils;

import racinggame.domain.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RacingGameUtils {
    public static final String SPLIT_REGEX = ",";
    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final int RACING_CAR_NAME_LENGTH_MIN = 0;
    public static final int RACING_CAR_NAME_LENGTH_LIMIT = 5;
    public static final int TRY_COUNT_MIN_VALUE = 0;
    public static final int CHECK_NUMBER_VALUE = 4;

    public static String[] racingCarNameSplit(String racingCarNameInput) {
        return trim(racingCarNameInput.split(SPLIT_REGEX));
    }

    public static void isValidRacingCarNameLengthLimit(String racingCarName) {
        if (racingCarName.length() <= RACING_CAR_NAME_LENGTH_MIN || racingCarName.length() > RACING_CAR_NAME_LENGTH_LIMIT) {
            System.out.println(ERROR_MESSAGE);
            throw new NoSuchElementException(ERROR_MESSAGE);
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

    public static void isValidTryCountGreaterThanZero(int tryCount) {
        if (tryCount <= TRY_COUNT_MIN_VALUE) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static void isValidOnlyNumber(String readLine) {
        for (char ch : readLine.toCharArray()) {
            isDigit(ch);
        }
    }

    private static void isDigit(char ch) {
        if (!Character.isDigit(ch)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    public static int isValidTryCount(String readLine) {
        isValidOnlyNumber(readLine);
        int tryCount = Integer.parseInt(readLine);
        isValidTryCountGreaterThanZero(tryCount);
        return tryCount;
    }

    public static boolean isMoved(int pickNumber) {
        if (pickNumber >= CHECK_NUMBER_VALUE) {
            return true;
        }
        return false;
    }
}
