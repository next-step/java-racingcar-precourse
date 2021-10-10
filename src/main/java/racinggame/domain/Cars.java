package racinggame.domain;

import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars() {
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }



    public void racing() {
        for (Car car : cars) {
            car.racing();
        }
    }


    public static Cars of(List<Car> cars) {
        return new Cars(cars);
    }

    public void printResult() {
        for (Car car : cars) {
            car.printResult();
        }
    }
}
