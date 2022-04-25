package racingcar.utils;

import racingcar.view.OutputView;

public class Validation {
    public static void isNotEmptyName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(OutputView.printInputError());
        }
    }

    public static void isSizeOver(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(OutputView.printInputError());
        }
    }

    public static void isNumeric(String count) {
        try {
            Double.parseDouble(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(OutputView.printInputCountError());
        }
    }

    public static boolean isSameScore(int finalScore, int score) {
        if (finalScore == score) {
            return true;
        }
        return false;
    }
}
