package racingcar.domain;

import java.util.Objects;

public class Number {
    private int number;

    public Number(int number) {
        this.number = number;
    }

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

    public void plusNumber() {
        number++;
    }

    public void minusNumber() {
        number--;
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override public int hashCode() {
        return Objects.hash(number);
    }
}
