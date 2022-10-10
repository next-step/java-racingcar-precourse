package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import racingcar.rule.GoStopRule;

public class Cars {
    public static final String INPUT_ERROR_CAR_NAME_DUPLICATE = "자동차 이름은 중복될 수 없습니다.";

    private final List<Car> cars;

    public Cars(List<String> nameList) {
        cars = new ArrayList<>();
        for (String name : nameList) {
            cars.add(new Car(name));
        }
        isNotDuplicate((String[])nameList.toArray());
    }

    private void isNotDuplicate(String[] names) {
        Set<String> set = new HashSet<>(Arrays.asList(names));

        if (set.size() != names.length) {
            throw new IllegalArgumentException(INPUT_ERROR_CAR_NAME_DUPLICATE);
        }
    }

    public int getSize() {
        return cars.size();
    }

    public void process(GoStopRule goStopRule) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).goOrStop(goStopRule.get(i));
        }
    }

    public Car getCar(int index) {
        return this.cars.get(index);
    }

    public Distance getMaxDistance() {
        cars.sort(Car::compare);
        return cars.get(cars.size() - 1).getDistance();
    }

    public List<Name> getNames(Distance distance) {
        List<Name> nameList = new ArrayList<>();
        for (Car car : cars) {
            addNameList(car, distance, nameList);
        }
        return nameList;
    }

    private void addNameList(Car car, Distance distance, List<Name> nameList) {
        if (isSameDistance(car.getDistance(), distance)) {
            nameList.add(car.getName());
        }
    }

    private boolean isSameDistance(Distance carDistance, Distance distance) {
        return carDistance.compare(distance) == 0;
    }
}
