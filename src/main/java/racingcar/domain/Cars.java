package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public Cars(List<String> carNames) {
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
    }

    public static Cars createCarsFromList(List<Car> listCars) {
        Cars cars = new Cars();
        for (Car car : listCars) {
            cars.add(car);
        }
        return cars;
    }

    public void add(Car car) {
        this.cars.add(car);
    }

    public Car get(int index) {
        return cars.get(index);
    }

    public int size() {
        return cars.size();
    }

    public void tryToMove(Standards standards) {
        for (int i = 0; i < cars.size(); i++) {
            Standard standard = standards.get(i);
            cars.get(i).tryToMove(standard);
        }
    }

    public Cars getTheFarthest() {
        cars.sort(Collections.reverseOrder());
        Position farthest = cars.get(0).getPosition();
        return getCarsByPosition(farthest);
    }

    private Cars getCarsByPosition(Position position) {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            addCarIfIsAtThePosition(result, car, position);
        }
        return Cars.createCarsFromList(result);
    }

    private void addCarIfIsAtThePosition(List<Car> set, Car car, Position position) {
        if (car.isAtThePosition(position)) {
            set.add(car);
        }
    }

    public String getNamesWithComma() {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.getNameToString());
        }
        return String.join(",", names);
    }

    public void print() {
        System.out.println();
        for (Car car : cars) {
            car.print();
        }
    }

}
