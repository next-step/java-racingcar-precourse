package view;

import racingcar.Name;

import java.util.*;

public class GameInput {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_SPLIT_REGEX = ",";
    private static final int MIN_ATTEMPT_COUNT = 1;
    private static final int MIN_RACING_CAR_COUNT = 2;

    public static Set<Name> enterRacingCarNames() {
        String[] racingCarNames = SCANNER.next().split(NAME_SPLIT_REGEX);
        try {
            validCountRacingCars(racingCarNames);
            return convertRacingCarNames(racingCarNames);
        } catch (IllegalArgumentException e) {
            GameOutput.printReEnter(e.getMessage());
            return enterRacingCarNames();
        }
    }

    public static int enterAttemptCount() {
        try {
            int attemptCount = SCANNER.nextInt();
            validAttemptCount(attemptCount);
            return attemptCount;
        } catch (InputMismatchException | IllegalArgumentException e) {
            emptyScanner(e);
            GameOutput.printEnterAttemptCountPositive();
            return enterAttemptCount();
        }
    }

    private static void validAttemptCount(int attemptCount) {
        if (isAttemptCountLessThanOne(attemptCount))
            throw new IllegalArgumentException();
    }

    private static boolean isAttemptCountLessThanOne(int attemptCount) {
        return attemptCount < MIN_ATTEMPT_COUNT;
    }

    private static void emptyScanner(Exception e) {
        if (e instanceof InputMismatchException)
            SCANNER.next();
    }

    private static Set<Name> convertRacingCarNames(String[] racingCarNames) {
        Set<Name> names = new LinkedHashSet<>();
        for (String racingCarName : racingCarNames)
            names.add(new Name(racingCarName));
        return names;
    }

    private static void validCountRacingCars(String[] racingCarNames) {
        if (isRacingCarNameLessThanTwo(racingCarNames))
            throw new IllegalArgumentException("경주 자동차는 2대 이상이어야 합니다.");
    }

    private static boolean isRacingCarNameLessThanTwo(String[] racingCarNames) {
        return racingCarNames.length < MIN_RACING_CAR_COUNT;
    }
}
