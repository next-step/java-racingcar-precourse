package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarGroup {

    private final List<Car> cars = new ArrayList<>();
    private final RandomNumberGenerator generator = new RandomNumberGenerator();
    private final int tryCount;
    private int moveCount;

    public CarGroup(String[] carNames, int tryCount) {
        cars.addAll(Arrays.stream(carNames).map(Car::new).toList());
        this.tryCount = tryCount;
    }

    public void move() {
        cars.forEach(car -> car.moveFront(generator.generateRandomNumber()));
        moveCount++;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean isEnded() {
        return moveCount == tryCount;
    }
}
