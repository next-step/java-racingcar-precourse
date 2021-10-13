package racinggame;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;
    private int numberOfAttempt;

    public Cars(List<String> carNames, int numberOfAttempt) {
        this.cars = mapCar(carNames);
        this.numberOfAttempt = numberOfAttempt;
    }

    private static List<Car> mapCar(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }

    private void printCarsMoveStatus() {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(Boundary.RANDOM_NUM.getMinNum(), Boundary.RANDOM_NUM.getMaxNum()));
            System.out.println(car.getMoveStatus());
        }
    }
}
