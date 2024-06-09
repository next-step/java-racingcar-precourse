package model;

import java.util.ArrayList;
import java.util.List;


public class CarList {
    List<Car> carList;

    public CarList(){
        carList = new ArrayList<>();
    }
    public void setCarList(String carNames){
        String[] inputList = carNames.split(",");

        for(String name : inputList) {
            Car car = new Car(name.trim(), 0);
            carList.add(car);
        }
    }
    public void addCar(Car car){
        carList.add(car);
    }
    public List<Car> getCarList(){
        return carList;
    }

}
