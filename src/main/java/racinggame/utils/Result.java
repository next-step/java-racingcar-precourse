package racinggame.utils;

import java.util.ArrayList;
import java.util.List;

import racinggame.domain.Car;


public class Result {
    public List<Car> result;

    public Result() {
        this.result = new ArrayList<>();
    }

    public void addResult(Car car) {
        result.add(car);
    }
}
