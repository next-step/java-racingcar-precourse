package racingcar.service;

import racingcar.common.ErrorMessage;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputService {

    private Cars cars;

    public InputService(Cars cars) {
        this.cars = cars;
    }

    public Cars getCars() {
        return cars;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    private List<String> getCarNameList() {
        List<String> carNameList = new ArrayList<>();
        for (Car car : cars.getCarList()) {
            carNameList.add(car.getName().getCarName());
        }
        return carNameList;
    }

    private Set<String> getCarNameSet() {
        Set<String> carNameSet = new HashSet<>();
        for (Car car : cars.getCarList()) {
            carNameSet.add(car.getName().getCarName());
        }
        return carNameSet;
    }

    public void duplicateValidation() {
        if (getCarNameList().size() != getCarNameSet().size()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_DUPLICATE_NAME);
        }
    }

}
