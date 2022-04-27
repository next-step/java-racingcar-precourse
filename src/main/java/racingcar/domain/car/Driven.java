package racingcar.domain.car;

public class Driven {
    private int driven;

    public void addDriven(int distance) {
        this.driven += distance;
    }

    public int getDriven() {
        return driven;
    }

    public void setDriven(int driven) {
        this.driven = driven;
    }
}
