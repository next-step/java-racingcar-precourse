package Service;

import Model.Car;
import java.util.ArrayList;

public class CarService {
    private ArrayList<Car> cars;
    Accelator accelator;

    public CarService(){
        cars = new ArrayList<>();
        accelator = new Accelator();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCar(String name){
        cars.add(new Car(name));
    }

    public void moveCar(Car car){
        if(accelator.accel()){
            car.moveForward();
        }
    }

    public void raceCar(){
        cars.stream().forEach(this::moveCar);
    }
}
