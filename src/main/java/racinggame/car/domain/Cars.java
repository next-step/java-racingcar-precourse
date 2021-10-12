package racinggame.car.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    List<Car> cars;
    int positionMaxValue = 0;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void roundOneRun() {
        for (Car car: cars) {
            car.confirmCarEngine();
        }
    }

    public void getMaxPositionValue() {
        for(Car findMaxPositionCar : cars) {
            positionMaxValue = Math.max(positionMaxValue, findMaxPositionCar.getPosition());
        }
    }

    public String toStringWinnerName() {
        StringBuilder sb = new StringBuilder();
        List<String> winCar = new ArrayList<>();
        for(Car carObj : cars) {
            makeWinnerList(carObj, winCar);
        }

        return String.join(",", winCar);
    }

    private void makeWinnerList(Car car, List<String> list) {
        if(car.getPosition() == this.positionMaxValue) {
            list.add(car.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car: cars) {
            sb.append(car.getName())
                    .append(" : ")
                    .append(String.join("",Collections.nCopies(car.getPosition(),"-")))
                    .append("\n");
        }
        return sb.toString();
    }
}
