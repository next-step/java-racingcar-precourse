package racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private int tryNo;

    public RacingGame(List<Car> cars, int tryNo) {
        this.cars = cars;
        this.tryNo = tryNo;
    }

    public static List<Car> initCars(String carNames) {
        if (carNames == null || carNames.trim().equals("")) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void race() {
        this.tryNo--;
        moveCars();
    }

    public void moveCars() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    public boolean racing() {
        return this.tryNo > 0;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }
}
