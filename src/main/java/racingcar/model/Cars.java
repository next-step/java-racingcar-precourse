package racingcar.model;

import java.util.ArrayList;
import java.util.List;

import static racingcar.model.Name.checkDuplicateCarNames;

public class Cars {
    private final List<Car> cars;

    public Cars() {
        this.cars = new ArrayList<>();
    }

    public Cars(String[] carNames) {
        checkDuplicateCarNames(carNames);
        this.cars = mapCars(carNames);
    }

    private List<Car> mapCars(String[] carNames) {
        List<Car> cars = new ArrayList<Car>();

        for (String carName : carNames) {
            Name name = new Name(carName);
            Car car = new Car(name);
            cars.add(car);
        }

        return cars;
    }

    public void move() {
        for (Car car : cars) {
            int randomNumber = RandomNumber.pickNumber();
            car.move(randomNumber);
        }
    }

    public void addCar(Car car) {
        if (car != null) {
            this.cars.add(car);
        }
    }

    public int size() {
        return cars.size();
    }

    public Car getCar(int idx) {
        return cars.get(idx);
    }

    public Move highestMove() {
        int highestMoveCount = 0;

        for (int i = 0; i < size() - 1; i++) {
            highestMoveCount = Math.max(highestMoveCount, this.getCar(i).getMove().moveCount());
        }

        return new Move(highestMoveCount);
    }

    public String totalCarNames() {
        ArrayList<String> totalCarNames = new ArrayList<>();

        for (int i = 0; i < size(); i++) {
            totalCarNames.add(getCar(i).getName());
        }

        return String.join(", ", totalCarNames);
    }
}
