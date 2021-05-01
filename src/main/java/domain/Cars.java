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
        System.out.println("carNames = "+carNames);
        String [] array = carNames.split(",");
        System.out.println("---------------------");
        for(String carNm : array){
            System.out.println(carNm);
            cars.add(new Car(carNm));
        }
        System.out.println("---------------------");
        return new Cars(cars);
    }

    public List<Car> getCars() {
        return cars;
    }
}
