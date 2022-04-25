package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {

    public static final int START_INCLUSIVE = 0;
    public static final int END_INCLUSIVE = 9;
    private List<Car> cars;

    public RacingCar(List<String> carNames) {
        this.cars = mapCar(carNames);
    }

    public List<Car> mapCar(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public void move() {
        for (Car car : cars) {
            car.carBehavior(Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
            System.out.println(car.displayTrace());
        }
    }
}
