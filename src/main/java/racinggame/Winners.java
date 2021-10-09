package racinggame;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    List<Car> cars;
    List<String> winners;

    public Winners(List<Car> cars) {
        this.cars = cars;
        winners = new ArrayList<>();
        maxPositionCar();
    }

    public static Winners of(List<Car> cars) {
        return new Winners(cars);
    }


    private void maxPositionCar() {
        Car maxPositionCar = cars.get(0);

        for (int i = 0; i < cars.size() - 1; i++) {
            maxPositionCar = compareCar(maxPositionCar, cars.get(i));
        }

        checkDuplicateWinner(maxPositionCar);
    }

    private Car compareCar(Car maxPositionCar, Car car) {

        if (!maxPositionCar.comparePostion(car)) {
            maxPositionCar = car;
        }
        return maxPositionCar;
    }

    private void checkDuplicateWinner(Car maxPositionCar) {
        for (Car car : cars) {
            equalsCar(maxPositionCar, car);
        }
    }

    private void equalsCar(Car maxPositionCar, Car car) {

        if (maxPositionCar.equalsPosition(car)) {
            winners.add(car.getCarName());
        }
    }

    public String winners() {
        String resultWinner = "";

        for (String winner : winners) {
            resultWinner += winner + ",";
        }

        return resultWinner.replaceFirst(".$", "");
    }
}
