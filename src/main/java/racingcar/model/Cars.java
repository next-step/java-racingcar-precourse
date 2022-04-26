package racingcar.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    private Cars(List<String> names) {
        validateNonDuplicateNames(names);
        this.cars = generateCars(names);
    }

    public static Cars makeCars(List<String> names) {
        return new Cars(names);
    }

    public List<Integer> generateRandomNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size(); i++) {
            numbers.add(RandomNumber.makeNumber());
        }
        return numbers;
    }

    public void move(List<Integer> randomNumbers) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).move(randomNumbers.get(i));
        }
    }

    public Integer size() {
        return cars.size();
    }

    public Integer getMaxPosition() {
        int result = 0;
        for (Car car : cars) {
            result = Integer.max(result, car.getPosition());
        }
        return result;
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> generateCars(List<String> names) {
        List<Car> temp = new ArrayList<>();
        for (String name : names) {
            temp.add(new Car(name));
        }
        return temp;
    }

    private void validateNonDuplicateNames(List<String> names) {
        if (new HashSet<>(names).size() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차명이 존재합니다");
        }
    }

    @Override
    public String toString() {
        StringBuffer result = new StringBuffer();
        for (Car car : cars) {
            result.append(car.toString() + "\n");
        }
        return result.toString();
    }
}
