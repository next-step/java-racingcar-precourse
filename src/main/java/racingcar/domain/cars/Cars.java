package racingcar.domain.cars;

import racingcar.domain.car.Car;

import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getMaxLocation(){
        Collections.sort(cars);
        return cars.get(0).getLocation();
    }

    public Car getCar(int index){
        return cars.get(index);
    }

}
