package domain;

import constant.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String names) {
        this.cars = new ArrayList<>();
        for(String name : names.split(Constant.CAR_NAME_DELEMETER)) {
            this.cars.add(new Car(name));
        }
    }

    public int size() {
        return cars.size();
    }

    public void start(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            move();
        }
    }

    public void move() {
        Random random = new Random();
        for (Car car : cars) {
            car.movable(random.nextInt(Constant.RANDOM_LIMIT));
        }
        System.out.println(resultString());
    }

    public String resultString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Car car : this.cars) {
            stringBuilder.append(car.resultString() + Constant.NEW_LINE);
        }
        return stringBuilder.toString();
    }

    public int maxPosition() {
        int maxPosition = 0;
        for(Car car : this.cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }

    public List<String> winners() {
        return this.cars.stream()
                .filter(car -> car.getPosition() == maxPosition())
                .map(car -> car.name())
                .collect(Collectors.toList());
    }
}
