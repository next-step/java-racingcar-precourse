package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;
import racingcar.utils.Constants;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        if(car == null) {
            return;
        }
        this.cars.add(car);
    }

    public Car getAt(Integer index) throws IllegalAccessException {
        if(index >= cars.size()) {
            throw new IllegalAccessException(Constants.ERROR_PREFIX+Constants.ERROR_ILLEGAL_ACCESS);
        }
        return cars.get(index);
    }

    public Cars getWinners() {
        Integer maxDistance = this.getMaxDistance();
        Cars winningCars = new Cars();
        for(Car car : this.cars) {
            winningCars.addCar(car.comparePosition(new CarPosition(maxDistance)));
        }

        return winningCars;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Car car : this.cars) {
            stringBuilder.append(car.getCarName()).append(Constants.DIV);
        }

        String rawReturnString = stringBuilder.toString();
        return rawReturnString.substring(0, rawReturnString.length()-2);
    }

    private Integer getMaxDistance() {
        int maxDistance = 0;
        for(Car car : this.cars) {
            maxDistance = Integer.max(maxDistance, car.getCarPosition());
        }

        return maxDistance;
    }

    public List<Car> getCars() {
        return cars;
    }
}
