package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Cars {
    private static final String CAR_NAME_SEPARATOR = ",";
    private final List<Car> carList;

    public Cars(String carsStr) {
        carList = new ArrayList<>();
        String[] names = carsStr.split(CAR_NAME_SEPARATOR);
        for (String name : names) {
            carList.add(new Car(name));
        }
    }

    public int getSize() {
        return carList.size();
    }

    public void moveForwardOrStop(int idx, MoveStatus moveStatus) {
        carList.get(idx).moveForwardOrStop(moveStatus);
    }

    public Winners findWinners() {
        Step maxStep = Collections.max(carList, Comparator.comparing(Car::getStep)).getStep();

        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            addIfMaxStep(winners, maxStep, car);
        }
        return new Winners(winners);
    }

    private void addIfMaxStep(List<String> winners, Step maxStep, Car car) {
        if (car.getStep().equals(maxStep)) {
            winners.add(car.getName());
        }
    }
}
