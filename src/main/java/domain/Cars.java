package domain;

import constant.Constant;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String names) {
        this.cars = new ArrayList<>();
        for(String name : names.split(Constant.CAR_NAME_DELEMETER)) {
            this.cars.add(new Car(name));
        }
    }

    public int size() {
        return cars.size();
    }
}
