package racingcar.domain;

public class Number {
    private int number;

    public Number(String number) {
        this.number = parseInt(number);
    }

    private static int parseInt(String tryCount) {
        if (!isNumeric(tryCount)) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 합니다.");
        }
        return Integer.parseInt(tryCount);
    }

    public static boolean isNumeric(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getNumber() {
        return number;
    }

    public void minusNumber() {
        number--;
    }
}
