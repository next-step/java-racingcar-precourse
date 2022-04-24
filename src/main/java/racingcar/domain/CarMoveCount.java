package racingcar.domain;

public class CarMoveCount {

    private int value;

    CarMoveCount() {
    }

    void increase() {
        this.value++;
    }

    int value() {
        return value;
    }
}
