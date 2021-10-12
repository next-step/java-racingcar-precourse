package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void enterRacingGame(List<Name> names) {
        for (Name name : names) {
            cars.add(new Car(name));
        }
    }

    public void MoveOrStopCars() {
        for (Car car : cars) {
            car.moveCar(CarMovingGenerator.randomCarMove());
        }
    }

    public void currentLocationCars() {
        for (Car car : cars) {
            car.printCurrentLocation();
        }
    }

    public Location inFormFirstRecord() {
        Car car = cars.get(0);
        Location location = car.getLocation();
        for (int i = 1; i < cars.size(); i++) {
            location = location.compareToLocation(cars.get(i).getLocation());
        }
        return location;
    }

    public Names inFormWinners(Location firstRecord) {
        Names names = new Names();
        for (Car car : cars) {
            compareToRecord(names, car.getName(), firstRecord, car.getLocation());
        }
        return names;
    }

    private void compareToRecord(Names names, Name entryCarName, Location firstRecord, Location entryCarRecord) {
        if (firstRecord.equals(entryCarRecord)) {
            names.addName(entryCarName);
        }
    }
}
