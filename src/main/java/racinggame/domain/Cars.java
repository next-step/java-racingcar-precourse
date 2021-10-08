package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private final static String SEPARATOR = ",";

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars createCars() {
        return new Cars(new ArrayList<>());
    }

    public void add(Car car) {
        cars.add(car);
    }

    public Car get(int idx) {
        return cars.get(idx);
    }

    public int size() {
        return cars.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName().getValue()).append(SEPARATOR);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.lastIndexOf(SEPARATOR));
        }
        return sb.toString();
    }

}
