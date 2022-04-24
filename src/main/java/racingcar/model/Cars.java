package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.ErrorMessage;
import racingcar.constant.Sign;

public class Cars {

    private final List<Car> cars;

    public Cars(String carNames) {
        validateCarNamesIsEmpty(carNames);
        this.cars = this.mapCars(carNames);
    }

    private List<Car> mapCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames.split(Sign.SPLIT_SIGN.getSign())) {
            validateCarNamesIsEqual(cars, carName);
            cars.add(new Car(carName));
        }
        return cars;
    }

    private void validateCarNamesIsEmpty(String carNames) {
        if (null == carNames) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAP_CAR_NAME.getMessage());
        }
    }

    private void validateCarNamesIsEqual(List<Car> cars, String carName) {
        for (Car car : cars) {
            car.validateCarNamesIsEqual(carName);
        }
    }

    public int getNumberOfCars() {
        return this.cars.size();
    }

    private Car getCar(int carNumber) {
        return this.cars.get(carNumber);
    }

    public void carDrive(int carNumber, int engin) {
        this.getCar(carNumber).drive(engin);
    }

    public String getCarStatus(int carNumber) {
        return this.getCar(carNumber).getStatus();
    }

    public String getWinner() {
        Winners winner = new Winners(getMaxHeadway());
        for (Car car : this.cars) {
            winner.add(car);
        }
        return winner.toString();
    }

    private Headway getMaxHeadway() {
        Headway maxHeadway = new Headway();
        for (Car car : this.cars) {
            maxHeadway.setMax(car.getHeadway());
        }
        return maxHeadway;
    }


}
