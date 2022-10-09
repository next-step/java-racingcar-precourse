package racingcar.domain;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static racingcar.common.ErrorMessage.CAR_NAME_DUPLICATE;

public class CarList {

    private List<Car> carList;

    public CarList(List<Car> carList) {
        validDuplicatedName(carList);
        this.carList = carList;
    }

    private void validDuplicatedName(List<Car> carList) {
//        List<String> carNameList = carList.stream().map(item -> item.getCarName().getCarName()).collect(Collectors.toList());
        Set<String> nameSet = setCarName(carList);
        if (nameSet.size() == carList.size()) {
            return;
        }
        throw new IllegalArgumentException(CAR_NAME_DUPLICATE);
    }

    private Set<String> setCarName(List<Car> carList) {
        Set<String> stringSet = new LinkedHashSet<>();
        for (Car car : carList) {
            stringSet.add(car.getCarName().getCarName());
        }
        return stringSet;
    }

    public void progress() {
        carList.forEach(Car::randomMove);
    }

    public List<Car> getCarList() {
        return carList;
    }

    public List<String> getWinnerList() {
        List<String> result = new ArrayList<>();

        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        for (Car car : carList) {
            addWinnerCar(result, car, maxPosition);
        }
        return result;
    }

    private void addWinnerCar(List<String> result, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            result.add(car.getCarName().getCarName());
        }
    }
}
