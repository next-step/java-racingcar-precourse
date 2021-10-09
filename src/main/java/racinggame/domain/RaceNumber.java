package racinggame.domain;

public class RaceNumber {

    private int value;

    public RaceNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static RaceNumber of(int value) {
        return new RaceNumber(value);
    }
}
