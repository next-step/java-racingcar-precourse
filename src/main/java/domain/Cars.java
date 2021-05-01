package domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<>();

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars(String carNames) {
        getDeviceValue(carNames);
    }

    public Cars() {

    }

    public Cars getDeviceValue(String carNames) {

        String [] array = carNames.split(",");
        for(String carNm : array){
            cars.add(new Car(carNm));
        }
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
