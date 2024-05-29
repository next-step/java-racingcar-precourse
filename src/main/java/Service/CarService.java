package Service;

import Model.Car;
import java.util.ArrayList;
import java.util.Collections;

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
        Collections.sort(cars, (a,b) -> b.getDistance() - a.getDistance());

        int winnerDistance = cars.get(cars.size()-1).getDistance();
        for(int i = cars.size()-1; i >= 0; i--){
            Car car = cars.get(i);
            if(car.getDistance() == winnerDistance){
                winners.add(car);
            }
        }

        return winners;
    }
}
