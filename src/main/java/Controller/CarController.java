package Controller;

import Model.Car;
import java.util.ArrayList;

public class CarController {
    private ArrayList<Car> cars;

    public CarController() {
        this.cars = new ArrayList<>();
    }

    public void addCar(String name){
        cars.add(new Car(name));
    }

    public ArrayList<Car> getAllCar(){
        return cars;
    }

    public Car getCar(String name){
        for(Car car : cars){
            if(car.getName() == name){
                return car;
            }
        }
        return null;
    }
}
