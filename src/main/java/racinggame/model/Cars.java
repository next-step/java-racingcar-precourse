package racinggame.model;

import java.util.ArrayList;

public class Cars extends ArrayList<Car> {
    private static final String NEWLINE = "\n";

    public Cars findFurthestCars() {
        CarLocation furthestLocation = this.findFurthestLocation();

        return this.findFurthestCarsInternal(furthestLocation);
    }

    private Cars findFurthestCarsInternal(CarLocation furthestLocation) {
        Cars furthestCars = new Cars();

        for (Car candidateCar : this) {
            furthestCars.tryAddFurthestCar(candidateCar, furthestLocation);
        }

        return furthestCars;
    }

    public CarLocation findFurthestLocation() {
        CarLocation furthestLocation = new CarLocation(-1);

        for (int i = 0; i < this.size(); i++) {
            CarLocation curCarLocation = this.get(i).getLocation();

            furthestLocation = furthestLocation.getGreaterCompareWith(curCarLocation);
        }

        return furthestLocation;
    }

    public Boolean tryAddFurthestCar(Car car, CarLocation furthestLocation) {
        if (furthestLocation.isGreaterThan(car.getLocation())) {
            return false;
        }

        this.add(car);
        return true;
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
