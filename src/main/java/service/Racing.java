package service;

import domain.Car;
import domain.Cars;

import java.util.List;

public class Racing {

    private Cars cars;

    public Cars getDeviceValue(String carNames) {
        return new Cars(carNames);
    }

    public Racing(String carNames) {
        this.cars =  getDeviceValue(carNames);
    }

    public Cars getCars() {
        return cars;
    }

    public void getRunningCycle(String runCount){

        for(int i=0; i < Integer.parseInt(runCount); i++){
            cars.moveForward(cars);
            makeRacingBarEachCars(cars.getCars());
        }
    }

    public void makeRacingBarEachCars(List<Car> cars){
        for(Car car : this.cars.getCars()){
            System.out.println(car.getCarName().getName()+":"+car.getCarDistance().getDistanceByBar());
        }
        System.out.println();
    }

}
