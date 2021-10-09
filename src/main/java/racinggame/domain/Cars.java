package racinggame.domain;

import java.util.ArrayList;
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
        int maxStep = findMaxStep();

        List<String> winners = new ArrayList<>();
        for (Car car : carList) {
            addIfMaxStep(winners, maxStep, car);
        }
        return new Winners(winners);
    }

    private int findMaxStep() {
        int maxStep = 0;
        for (Car car : carList) {
            maxStep = Math.max(maxStep, car.getStep());
        }

        return maxStep;
    }

    private void addIfMaxStep(List<String> winners, int maxStep, Car car) {
        if (car.getStep() == maxStep) {
            winners.add(car.getName());
        }
    }
}
