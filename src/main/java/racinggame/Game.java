package racinggame;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    int maxPlace = 0;
    List<Car> winnerCars = new ArrayList<>();

    public void play() {
        int rollCount = 0;
        List<Car> cars = new ArrayList<>();
        // carClass, gameClass
        // rollCount
        // moveCar, printCarsPlace
        // printWinner
        printWinnerResult(cars);
    }
    //printCarPlace
    private void printCarsPlace(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.getPlaceToString());
        });
    }

    //printWinner
    private void printWinnerResult(List<Car> cars) {
        for (Car car: cars) {
            setMaxPlace(car.getPlace());
        }
        cars.forEach(car -> addWinnerCar(car));

        String winnerString = carsToString(winnerCars);
        System.out.println("최종 우승자는 " + winnerString +  " 입니다. ");
    }

    public String carsToString(List<Car> cars){
        String winnerCarString = "" ;
        for (Car car: cars) {
            winnerCarString = winnerCarString + ", " + car.getName();
        }
        winnerCarString = winnerCarString.substring(2, winnerCarString.length());
        return winnerCarString;
    }


    private void setMaxPlace(int maxPlace){
        if (this.maxPlace < maxPlace) this.maxPlace = maxPlace;
    }

    private void addWinnerCar(Car car){
        if(car.getPlace() == this.maxPlace) winnerCars.add(car);
    }
