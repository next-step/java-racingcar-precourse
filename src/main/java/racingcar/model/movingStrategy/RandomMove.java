package racingcar.model.movingStrategy;

import racingcar.model.NumberGenerator;

import java.util.Objects;

public class RandomMove implements MovingStrategy {
    private static final int FORWARD_BEGIN_NUM = 4;
    private static final int FORWARD_END_NUM = 9;

    private final int number;

    public RandomMove() {
        this(NumberGenerator.generate());
    }

    public RandomMove(int number) {
        this.number = number;
    }

    @Override
    public boolean movable() {
        return number >= FORWARD_BEGIN_NUM && number <= FORWARD_END_NUM;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RandomMove that = (RandomMove) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "RandomMove{" +
                "number=" + number +
                '}';
    }
}
