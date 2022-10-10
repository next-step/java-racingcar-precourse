package racingcar.domain;

public class Location {

    private int x;

    public Location() {
        this.x = 0;
    }

    public void apply(boolean result) {
        if (result) {
            this.x++;
        }
    }

    public int getX() {
        return x;
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            sb.append('-');
        }
        return sb.toString();
    }
}
