package model;

import dto.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {
    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public RaceResult race(List<Integer> numbers) {
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            car.move(new MoveJudgmentNumber(numbers.get(i)));
        }

        return new RaceResult(cars);
    }
}
