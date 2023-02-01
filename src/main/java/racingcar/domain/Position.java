package racingcar.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Position {
    private int position;

    public Position() {
        this.position = 0;
    }

    public Position(int position) {
        if (! valid(position)) {
            throw new IllegalArgumentException("Position은 항상 양수여야 됩니다.");
        }
        this.position = position;
    }

    private boolean valid(int position) {
        return position > 0;
    }

    public Position move(){
        //가변
        this.position = this.position + 1;

        return this;
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

    public boolean compare(Position position) {
        return this.position > position.position;
    }

    public boolean isSame(Position position) {
        return this.position == position.position;
    }

    public String printPosition() {
        String printPosition = "";

        for (int i = 0; i < position; i++) {
            printPosition += "-";
        }

        return printPosition;
    }
}
