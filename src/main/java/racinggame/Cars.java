package racinggame;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private static final int START_NUM_IN_RANGE = 0;
    private static final int END_NUM_IN_RANGE = 9;

    private final List<Car> cars;

    public Cars(List<String> carsStr) {
        this.cars = generateCars(carsStr);
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

    public void play() {
        for (Car car: cars) {
            car.decideMove(Randoms.pickNumberInRange(START_NUM_IN_RANGE, END_NUM_IN_RANGE));
        }
    }
}
