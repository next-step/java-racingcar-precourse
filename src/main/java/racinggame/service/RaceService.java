package racinggame.service;

import racinggame.domain.Car;
import racinggame.domain.CarName;
import racinggame.domain.Cars;
import racinggame.domain.InputCarsName;

import java.util.ArrayList;
import java.util.List;

public class RaceService {

    public String[] splitNameWithComma(InputCarsName inputCarsName) {
        return inputCarsName.getName().split(",");
    }

    public Cars createCars(String[] carNameList) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNameList) {
            carList.add(Car.of(CarName.of(name)));
        }
        return Cars.of(carList);
    }

    public List<String> getWinner(Cars cars) {
        final int max = getMaxPosition(cars.getCars());
        return retrieveWinnerWithMaxValue(cars.getCars(), max);
    }

    private List<String> retrieveWinnerWithMaxValue(List<Car> carsList, int max) {
        List<String> winners = new ArrayList<>();
        for (Car car : carsList) {
            if (car.getCarPosition().getValue() == max) {
                winners.add(car.getCarName().getName());
            }
        }
        return winners;
    }

    private int getMaxPosition(List<Car> carsList) {
        int max = Integer.MIN_VALUE;
        for (Car car : carsList) {
            if (car.getCarPosition().getValue() > max) {
                max = car.getCarPosition().getValue();
            }
        }
        return max;
    }
}
