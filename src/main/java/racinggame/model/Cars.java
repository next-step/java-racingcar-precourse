package racinggame.model;


import racinggame.model.enums.Error;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;
    private int topPosition;

    public Cars(List<String> names) {
        this.cars = constructCars(names);
        this.topPosition = 0;
    }

    private List<Car> constructCars(List<String> names) {
        List<Car> list = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name.trim());
            list.add(car);
        }

        return list;
    }

    public void moveAll(List<Integer> numbers) {
        validateSize(numbers);

        for (int i = 0; i < cars.size(); i++) {
            int number = numbers.get(i);
            Car car = cars.get(i);
            moveOne(car, number);
        }
    }

    private void moveOne(Car car, int number) {
        MoveCondition condition = new MoveCondition(number);
        car.move(condition);
        topPosition = Math.max(topPosition, car.getPosition());
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != cars.size()) {
            throw new IllegalArgumentException(Error.INVALID_MOVE_NUMBER_SIZE.message());
        }
    }

    public MoveResults getResult() {
        List<MoveResult> results = new ArrayList<>();

        for (Car car : cars) {
            MoveResult result = new MoveResult(car.getName(), car.getRoad());
            results.add(result);
        }

        return new MoveResults(results);
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            addNameIfTopPosition(winners, car);
        }

        return winners;
    }

    private void addNameIfTopPosition(List<String> winners, Car car) {
        if (car.isTopPosition(topPosition)) {
            String name = car.getName();
            winners.add(name);
        }
    }
}
