package racingcar.model;

import java.util.ArrayList;

public class Cars extends ArrayList<Car>{

    private ArrayList<Car> cars;

    public Cars() {
        cars = new ArrayList<>();
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    @Override
    public Car get(int index) {
        return cars.get(index);
    }

    @Override
    public boolean add(Car car) {
        return cars.add(car);
    }

    @Override
    public void clear() {
        cars.clear();
    }


}
