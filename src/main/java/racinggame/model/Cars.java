package racinggame.model;


import racinggame.model.enums.Error;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> names) {
        this.cars = constructCars(names);
    }

    private List<Car> constructCars(List<String> names) {
        List<Car> list = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name);
            list.add(car);
        }

        return list;
    }

    public void moveAll(List<Integer> numbers) {
        validateSize(numbers);

        for (int i = 0; i < cars.size(); i++) {
            int number = numbers.get(i);
            MoveCondition condition = new MoveCondition(number);
            Car car = cars.get(i);
            car.move(condition);
        }
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
}
