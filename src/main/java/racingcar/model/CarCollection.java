package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarCollection {
    private List<Car> cars;

    public CarCollection(CarNames carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException("자동차 이름이 제대로 입력되지 않았습니다.");
        }
        this.cars = new ArrayList<>();
        for (String carName : carNames.getCarNames()) {
            cars.add(new Car(carName));
        }
    }

    public List<String> findFirst() {
        int topPosition = findTopPosition();
        return findCarsInPosition(topPosition);
    }

    private List<String> findCarsInPosition(int topPosition) {
        List<String> result = new ArrayList<>();
        for (Car car : this.cars) {
            result.addAll(checkPosition(car, topPosition));
        }
        return result;
    }

    private List<String> checkPosition(Car car, int position) {
        if (position == car.getPosition()) {
            List<String> carNames = new ArrayList<>();
            carNames.add(car.getName());
            return carNames;
        }
        return new ArrayList<>();
    }

    private int findTopPosition() {
        int position = Integer.MIN_VALUE;
        for (Car car : this.cars) {
            position = Math.max(position, car.getPosition());
        }
        return position;
    }

    public void go(int index) {
        if (!isValidIndex(index)) {
            return;
        }
        Car car = cars.get(index);
        car.go();
    }
    public void stop(int index) {
        if (!isValidIndex(index)) {
            return;
        }
        Car car = cars.get(index);
        car.stop();
    }
    public int getCarCount() {
        return this.cars.size();
    }
    private boolean isValidIndex(int index) {
        return index >= 0 && index < cars.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : this.cars) {
            sb.append(car);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
