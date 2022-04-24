package racingcar.domain;

public class Position {
    private int value;

    public Position() {
        this.value = 0;
    }

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void goForward() {
        this.value++;
    }

    @Override
    public String toString() {
        return new String(new char[value]).replace("\0", "-");
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Position)) {
            return false;
        }
        return value == (((Position) obj).getValue());
    }

    public static int compare(Position x, Position y) {
        return Integer.compare(x.getValue(), y.getValue());
    }

}
