package racingcar.domain;

import java.util.Objects;

public class RoundNumber {

    private final int number;

    public RoundNumber(int number) {
        this.number = number;
    }

    public RoundNumber nextRound() {
        return new RoundNumber(number + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundNumber that = (RoundNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public boolean isNext(RoundNumber currentRound) {
        return number < currentRound.number;
    }
}
