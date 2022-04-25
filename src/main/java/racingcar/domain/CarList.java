package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    public static final String SPLIT_REGEX = ",";
    private static final int START_POSITION = 0;

    private final List<Car> carList;

    private CarList(List<Car> carList) {
        this.carList = carList;
    }

    public static CarList createCarList(String input) {
        List<Car> inputCarList = new ArrayList<>();
        String[] carNames = input.split(SPLIT_REGEX);

        for (String carName : carNames) {
            inputCarList.add(new Car(carName));
        }
        return new CarList(inputCarList);
    }

    public void play() {
        for (Car car : carList) {
            car.tryToGo();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<Car> getWinner() {
        List<Car> winnerCarList = new ArrayList<>();
        int winnerPosition = getMaxPositionValue();
        for (Car car : carList) {
            addIfWinner(winnerCarList, car, winnerPosition);
        }
        return winnerCarList;
    }

    private int getMaxPositionValue() {
        int maxPosition = START_POSITION;
        for (Car car: carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    private void addIfWinner(List<Car> winnerCarList, Car car, int winnerPosition) {
        if (car.getPosition() == winnerPosition) {
            winnerCarList.add(car);
        }
    }
}
