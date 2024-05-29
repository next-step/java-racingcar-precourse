package Service;

import Model.Car;
import java.util.ArrayList;

public class CarService {
    private ArrayList<Car> cars;

    public CarService(){
        cars = new ArrayList<>();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void addCar(String name){
        cars.add(new Car(name));
    }
}
