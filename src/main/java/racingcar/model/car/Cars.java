package racingcar.model.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.strategy.MoveStrategy;
import racingcar.model.value.ErrorMsg;
import racingcar.model.value.Rule;

/**
 * 자동차 그룹 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class Cars {

    private final List<Car> carList;

    public Cars(final String carNamesInput) {
        this.carList = createCarList(carNamesInput);
    }

    private List<Car> createCarList(final String carNamesInput) {
        List<Car> newCarList = new ArrayList<>();
        for (String carName : carNamesInput.split(Rule.SEPARATOR)) {
            newCarList.add(createCar(carName));
        }
        checkCarList(newCarList);
        return newCarList;
    }

    private void checkCarList(List<Car> newCarList) {
        Set<Car> carSet = new HashSet<>(newCarList);
        if (carSet.size() != newCarList.size()) {
            throw new IllegalArgumentException(ErrorMsg.DUPLICATE_NAME);
        }
        if (newCarList.size() < 2) {
            throw new IllegalArgumentException(ErrorMsg.ONE_CAR_NAME);
        }
    }

    private Car createCar(final String carName) {
        return new Car(carName);
    }

    public void moveAll(MoveStrategy moveStrategy) {
        for (Car car : carList) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public int getCarListSize() {
        return carList.size();
    }


    public void orderCarsByPosition() {
        Collections.sort(carList, Collections.reverseOrder());
    }

    public CarPosition getWinningPosition() {
        return carList.get(0).getCarPosition();
    }

    public List<CarName> getWinners() {
        List<CarName> winningList = new ArrayList<>();
        CarPosition winningPosition = carList.get(0).getCarPosition();
        for (Car car : carList) {
            winningList = findCoWinners(winningPosition, car, winningList);
        }
        return winningList;
    }

    private List<CarName> findCoWinners(CarPosition winningPosition, Car car, List<CarName> winningList) {
        if (car.getCarPosition().equals(winningPosition)) {
            winningList.add(car.getCarName());
        }
        return winningList;
    }

    public void printCarsPositions() {
        for (Car car : carList) {
            car.printCarPositionWithName();
        }
    }
}
