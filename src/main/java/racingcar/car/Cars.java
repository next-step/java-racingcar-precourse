package racingcar.car;

import java.util.List;

public class Cars {
    List<Car> cars;
    public Cars(List<Car> cars){
        this.cars = cars;
    }
    public List<Car> getCars(){
        return this.cars;
    }
}
