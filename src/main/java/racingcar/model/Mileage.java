package racingcar.model;

/**
 * 주행거리
 */
public class Mileage {

    private int mileage = 0;

    public int mileage() {
        return this.mileage;
    }

    public void addMileage() {
        this.mileage++;
    }
}
