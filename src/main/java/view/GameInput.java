package view;

import racingcar.Name;

import java.util.*;

public class GameInput {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NAME_SPLIT_REGEX = ",";

    public static Set<Name> enterCarNames() {
        String[] carNames = scanner.next().split(NAME_SPLIT_REGEX);
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
            int attemptCount = scanner.nextInt();
            validAttemptCount(attemptCount);
            return attemptCount;
        } catch (InputMismatchException | IllegalArgumentException e) {
            emptyScanner(e);
            GameOutput.printReEnterAttemptCount();
            return enterAttemptCount();
        }
    }

    private static void validAttemptCount(int attemptCount) {
        if (attemptCount < 1)
            throw new IllegalArgumentException();
    }

    private static void emptyScanner(Exception e) {
        if (e instanceof InputMismatchException)
            scanner.next();
    }

    private static Set<Name> convertNames(String[] carNames) {
        Set<Name> names = new HashSet<>();
        for (String carName : carNames)
            names.add(new Name(carName));
        return names;
    }

    private static void validCountCars(String[] carNames) {
        if (carNames.length < 2)
            throw new IllegalArgumentException("경주 자동차는 2대 이상이어야 합니다.");
    }
}
