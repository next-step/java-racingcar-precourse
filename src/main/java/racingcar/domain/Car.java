package racingcar.domain;

import racingcar.vo.Location;

import java.util.ArrayList;
import java.util.List;


public class Car {
    private final String name;
    private final Location location;

    public Car(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location.getLocation();
    }

    public void proceed() {
        location.move(1);
    }

    public boolean isWinningLocation(int winningLocation) {
        return location.isWinningLocation(winningLocation);
    }

    public static List<Car> createBatch(CarNames carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames.getCarNameList()) {
            cars.add(new Car(carName, new Location(0)));
        }
        return cars;
    }
}
