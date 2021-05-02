package model;

import dto.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    public static final int ZERO = 0;

    private final List<Car> cars;
    private int maxPosition;

    public RacingCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
        this.maxPosition = ZERO;
    }

    public RaceResult race(List<Integer> numbers) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.move(new MoveJudgmentNumber(numbers.get(i)));
            this.maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return new RaceResult(cars);
    }

    public Winners getWinners() {
        return new Winners(maxPosition, cars);
    }

    public int getSize() {
        return cars.size();
    }
}
