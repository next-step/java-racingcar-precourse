package racingcar;

public class RacingCar {

    private String name;
    private int numberOfAdvances = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberOfAdvances() {
        return this.numberOfAdvances;
    }

    public void forward() {
        this.numberOfAdvances++;
    }
}
