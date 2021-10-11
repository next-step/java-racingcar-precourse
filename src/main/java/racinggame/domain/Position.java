package racinggame.domain;

import java.util.Objects;

public class Position {
    private int position;
    private static final String HYPHEN = "-";
    private static final int MIN_POSITION_VALUE = 0;

    public Position() {
        this(MIN_POSITION_VALUE);
    }

    public Position(int position) {
        this.position = position;
    }

    public void forward() {
        this.position++;
    }

    public String convertToHyphen() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(HYPHEN);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getValue() {
        return position;
    }

}
