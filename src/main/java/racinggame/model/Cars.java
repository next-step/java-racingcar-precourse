package racinggame.model;

import java.util.ArrayList;

public class Cars extends ArrayList<Car> {
    private static final String NEWLINE = "\n";

    public void add(Cars otherCars) {
        for (Car otherCar : otherCars) {
            this.add(otherCar);
        }
    }

    public void addOnlyOnce(Car car) {
        if (this.contains(car)) {
            return;
        }

        this.add(car);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (Car car : this) {
            builder.append(car.toString() + NEWLINE);
        }

        return builder.toString();
    }
}
