package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.util.StringUtil;

public class Cars {
    List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String carNames) {
        return new Cars(attendCar(carNames));
    }

    private static List<Car> attendCar(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : StringUtil.splitByComma(carNames)) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void moveOrStopCars() {
        for (Car car : cars) {
            car.moveOrStop();
        }
    }

    public List<Car> getMaxPositionCars() {
        int maxPosition = getMaxPosition();
        List<Car> maxPositionCars = new ArrayList<>();
        for (Car car : cars) {
            addListIfCarMaxPosition(maxPositionCars, car, maxPosition);
        }
        return maxPositionCars;
    }

    private void addListIfCarMaxPosition(List<Car> maxPositionCars, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            maxPositionCars.add(car);
        }
    }

    private int getMaxPosition() {
        List<Integer> positions = new ArrayList<>();
        for (Car car : cars) {
            positions.add(car.getPosition());
        }
        return Collections.max(positions);
    }

}
