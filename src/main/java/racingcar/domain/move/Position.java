package racingcar.domain.move;

import racingcar.util.StringFlatAppender;

import java.util.Objects;

public class Position {

    private static final String PRESENT_STRING = "-";
    private int point;

    public Position(int point) {
        this.point = point;
    }

    public void go() {
        this.point += 1;
    }

    public int get() {
        return this.point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return point == position.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(point);
    }

    @Override
    public String toString() {
        StringFlatAppender appender = new StringFlatAppender("");
        for (int i = 0; i < point; i++) {
            appender.append(PRESENT_STRING);
        }
        return appender.get();
    }
}
