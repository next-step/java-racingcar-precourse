package racingcar.domain;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public int getNumberOfCars() {
        return this.cars.size();
    }

    public void moveCars(List<Integer> randomDistances) {
        int index = 0;
        for(Car car: this.getCars()) {
            car.move(randomDistances.get(index));
            index+=1;
        }
    }
}
