package model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceCars {

    private final List<Car> cars;

    public RaceCars() {
        cars = new ArrayList<>();
    }

    public List<Car> getCars() {
        return cars;
    }

}
