package racingcar.domain;

import racingcar.constant.Error;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Cars {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final Boolean ALREADY_EXIST = false;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateDuplicateName(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(pickNumberInRange(MIN, MAX));
        }
    }

    public List<String> winner() {
        return new CarDistance(cars).winner();
    }

    private void validateDuplicateName(List<Car> cars) {
        Set<String> carUniqueName = new HashSet<>();

        for (Car car : cars) {
            carUniqueName.add(uniqueName(carUniqueName, car.getName()));
        }
    }

    private String uniqueName(Set<String> carUniqueName, String name) {
        if (carUniqueName.add(name) == ALREADY_EXIST) {
            throw new IllegalArgumentException(Error.DUPLICATE_NAME.toString());
        }

        return name;
    }
}
