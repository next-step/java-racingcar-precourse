package view;

import racingcar.Name;

import java.util.*;

public class GameInput {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_SPLIT_REGEX = ",";
    private static final int MIN_ATTEMPT_COUNT = 1;
    private static final int MIN_RACING_CAR_COUNT = 2;

    public static Set<Name> enterCarNames() {
        String[] carNames = SCANNER.next().split(NAME_SPLIT_REGEX);
        try {
            validCountCars(carNames);
            return convertNames(carNames);
        } catch (IllegalArgumentException e) {
            GameOutput.printEnterAgain(e);
            return enterCarNames();
        }
    }

    public static int enterAttemptCount() {
        try {
            int attemptCount = SCANNER.nextInt();
            validAttemptCount(attemptCount);
            return attemptCount;
        } catch (InputMismatchException | IllegalArgumentException e) {
            emptyScanner(e);
            GameOutput.printReEnterAttemptCount();
            return enterAttemptCount();
        }
    }

    private static void validAttemptCount(int attemptCount) {
        if (attemptCount < MIN_ATTEMPT_COUNT)
            throw new IllegalArgumentException();
    }

    private static void emptyScanner(Exception e) {
        if (e instanceof InputMismatchException)
            SCANNER.next();
    }

    private static Set<Name> convertNames(String[] carNames) {
        Set<Name> names = new LinkedHashSet<>();
        for (String carName : carNames)
            names.add(new Name(carName));
        return names;
    }

    private static void validCountCars(String[] carNames) {
        if (carNames.length < MIN_RACING_CAR_COUNT)
            throw new IllegalArgumentException("경주 자동차는 2대 이상이어야 합니다.");
    }
}
