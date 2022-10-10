package racingcar.domain;

import racingcar.utils.CompareUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    public static final String ERROR_MESSAGE_CAR_NAME_IS_DUPLICATED = "중복된 자동차 이름이 존재합니다.";

    private List<Car> carList;

    private Cars(List<Car> carList) {
        validate(carList);
        this.carList = carList;
    }

    private static Cars from(List<Car> cars) {
        return new Cars(cars);
    }

    private static void validate(List<Car> carList) {
        if (isDuplicatedCarName(carList)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_CAR_NAME_IS_DUPLICATED);
        }
    }

    private static boolean isDuplicatedCarName(List<Car> carList) {
        Set<String> carNameSet = new HashSet<>();

        carList.forEach(
                car -> carNameSet.add(
                        car.getCarName()
                )
        );

        return carList.size() != carNameSet.size();
    }

    public static Cars fromStringList(List<String> carNames) {
        List<Car> carList = new ArrayList<>();

        carNames.forEach(
                carName -> carList.add(
                        Car.create(CarName.from(carName))
                )
        );

        return Cars.from(carList);
    }

    public List<Car> getCarList() {
        return carList;
    }

    private List<Car> getWinnerCars() {
        List<Car> winnerCars = new ArrayList<>();

        int largestPosition = this.getLargestPosition();
        for (Car car : this.carList) {
            this.addCarIfEqualCarPosition(winnerCars, car, largestPosition);
        }

        return winnerCars;
    }

    public List<String> getWinnerCarNames() {
        List<String> winnerCarNames = new ArrayList<>();

        List<Car> winnerCars = this.getWinnerCars();
        for (Car winnerCar : winnerCars) {
            winnerCarNames.add(winnerCar.getCarName());
        }

        return winnerCarNames;

    }

    private void addCarIfEqualCarPosition(List<Car> cars, Car car, int targetPosition) {
        if (car.getPosition() == targetPosition) {
            cars.add(car);
        }
    }

    private int getLargestPosition() {
        return CompareUtils.getLargestInteger(getCarPositions());
    }

    private List<Integer> getCarPositions() {
        List<Integer> positions = new ArrayList<>();

        for (Car car : this.carList) {
            positions.add(car.getPosition());
        }

        return positions;
    }

    public void moveByRandomAccelPower() {
        this.carList.forEach(
                car -> car.moveByAccelPower(AccelPower.byRandom())
        );
    }
}
