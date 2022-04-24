package racingcar.domain.game;

public class Round {
    private int value;

    public Round(int value) {
        this.value = value;
    }

    public static Round from(int value) {
        return new Round(value);
    }

    public int getValue() {
        return this.value;
    }

    public void increase() {
        this.value++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Round that = (Round) o;

        return value == that.value;
    }
}
