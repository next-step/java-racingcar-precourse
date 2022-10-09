package racingcar.model.progress;

import java.util.Objects;

public class MoveScore implements Comparable<MoveScore> {
    private final int score;

    private MoveScore(int score) {
        this.score = score;
    }

    public static MoveScore of(int score) {
        return new MoveScore(score);
    }

    public int get() {
        return score;
    }

    @Override
    public boolean equals(Object obj) {
        return Objects.equals(this.toString(), obj.toString())
                && getClass() == obj.getClass()
                && this.get() == ((MoveScore) obj).get();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + String.format("[score=%s]", this.get());
    }

    @Override
    public int compareTo(MoveScore o) {
        return Integer.compare(this.get(), o.get());
    }
}
