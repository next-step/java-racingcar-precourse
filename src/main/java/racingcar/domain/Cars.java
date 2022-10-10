package racingcar.domain;

import racingcar.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final String REGEX = ",";
    private final List<Car> cars;

    public Cars(String inputName) {
        this.cars = getCarsFromInputName(inputName);
    }

    private List<Car> getCarsFromInputName(String inputName) {
        List<Car> result = new ArrayList<>();
        String[] names = inputName.split(REGEX);
        for (String name : names) {
            result.add(new Car(name));
        }
        return result;
    }

    public List<Car> cars() {
        return this.cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(RandomUtils.getRandomNumber());
        }
    }
}
