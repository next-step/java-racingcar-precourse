package racingcar.domain;

public class RandomMoveNumber {
    private int value;

    public RandomMoveNumber(int value) {
        this.value = value;
    }

    public boolean okToGo() {
        return this.value >= 4;
    }
}
