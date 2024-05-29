package Controller;

import Model.Car;
import Service.CarService;
import java.util.ArrayList;

public class CarController {
    private CarService carService;

    public CarController() {
        this.carService = new CarService();
    }

    public ArrayList<Car> getAllCar(){
        return carService.getCars();
    }

    public Car getCar(String name){
        for(Car car : carService.getCars()){
            if(car.getName() == name){
                return car;
            }
        }
        return null;
    }
}
