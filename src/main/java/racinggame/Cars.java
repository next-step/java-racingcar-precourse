package racinggame;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int START_NUM_IN_RANGE = 0;
    private static final int END_NUM_IN_RANGE = 9;

    private final List<Car> cars;
    private final List<String> winnersName;

    public Cars(List<String> carsStr) {
        this.cars = generateCars(carsStr);
        this.winnersName = new ArrayList<>();
    }

    private List<Car> generateCars(List<String> carsStr) {
        List<Car> cars = new ArrayList<>();
        for (String carStr: carsStr) {
            cars.add(new Car(carStr));
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public RaceResult play() {
        for (Car car: cars) {
            car.decideMove(Randoms.pickNumberInRange(START_NUM_IN_RANGE, END_NUM_IN_RANGE));
        }

        return new RaceResult(this);
    }

    public List<String> getWinnersName() {
        for (Car car: cars) {
            findMaximumCar(car);
        }

        return winnersName;
    }

    private void findMaximumCar(Car car) {
        if (car.isMaximumMoveCount(getMaximumMoveCount())) {
            winnersName.add(car.getName());
        }
    }

    private int getMaximumMoveCount() {
        int maxMoveCount = 0;
        for (Car car: cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        return maxMoveCount;
    }

    @Override
    public String toString() {
        return Message.printCarsSpecification(cars);
    }
}
