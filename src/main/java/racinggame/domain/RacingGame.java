package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private int tryNo;

    public RacingGame(Cars cars, int tryNo) {
        this.cars = cars;
        this.tryNo = tryNo;
    }

    public static Cars initCars(String carNames) {
        if (carNames == null || carNames.trim().equals("")) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(new Name(name)));
        }
        return new Cars(cars);
    }

    public void race() {
        this.tryNo--;
        moveCars();
    }

    public void moveCars() {
        cars.move();
    }

    public boolean racing() {
        return this.tryNo > 0;
    }

    public List<Car> getCars() {
        return this.cars.getCars();
    }

    public List<Car> getWinners() {
        return this.cars.findWinners();
    }
}
