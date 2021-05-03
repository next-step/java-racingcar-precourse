package service;

import domain.Car;
import domain.Cars;

public class Racing {

    private final Cars cars;

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
            makeRacingBarEachCars();
        }
    }

    public void makeRacingBarEachCars(){
        for(Car car : this.cars.getCars()){
            System.out.println(car.getCarName().getName()+":"+car.getCarDistance().getDistanceByBar());
        }
        System.out.println();
    }

    public void getRaceWinner(){
        //cars.getWinnerCar();
        cars.printWinner();
    }

}
