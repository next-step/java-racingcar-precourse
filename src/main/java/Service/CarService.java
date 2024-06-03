package Service;

import Model.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

    public Car getCar(String name){
        for(Car car : getCars()){
            if(car.getName() == name){
                return car;
            }
        }
        return null;
    }

    public ArrayList<Car> getWinner(){
        ArrayList<Car> winners = new ArrayList<>();

        int maxDistance = cars.stream()
            .max(Comparator.comparing(Car::getDistance))
            .orElse(null)
            .getDistance();

        for(Car car: cars){
            if(car.getDistance() == maxDistance){
                winners.add(car);
            }
        }
        return winners;
    }
}
