package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    
    private static final String SPLIT_STRING = ",";

    private final List<Car> cars;
    
    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String carNames) {
        List<Car> cars = new ArrayList<>();
        
        for (String name : carNames.split(SPLIT_STRING)) {
            cars.add(Car.from(name));
        }

        return new Cars(cars);
    }

    public static Cars of(Car... carArr) {
        List<Car> cars = new ArrayList<>();

        for (Car car : carArr) {
            cars.add(car);
        } 
        
        return new Cars(cars);
    }

    public void moveAllByRandom() {
        for (Car car : cars) {
            moveByRandom(car);
        }
    }

    public List<String> getStatusList() {
        List<String> result = new ArrayList<>();
        
        for (Car car : cars) {
            result.add(car.getStatus());
        }

        return result;
    }

    public Winners pickWinners() {
        return new Winners(cars);
    }

    private void moveByRandom(Car car) {
        if (JudgmentNumber.newJudgmentNumber().canMove()) {
            car.move();
        } 
    }
}