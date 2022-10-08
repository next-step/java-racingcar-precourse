package racingcar.model.racing.car;

public class Advance {
    private int value;

    public Advance() {
        this.value = 0;
    }

    public Advance(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void yes() {
        ++value;
    }
}
