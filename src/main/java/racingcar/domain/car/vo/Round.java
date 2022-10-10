package racingcar.domain.car.vo;

public final class Round {

    private int number;

    public Round(int number) {
        validationRange(number);
        this.number = number;
    }

    public int value() {
        return number;
    }

    private static void validationRange(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("[ERROR] 최소 1회차는 진행해야 합니다.");
        }
    }
}
