package com.tjnam.racingcargame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private List<Car> cars = new ArrayList<Car>();;
    private List<Car> winners;

    public Cars(List<Car> carList){
        for(Car car : carList) {
            cars.add(car);
        }
    }

    public void raceCars(){
        cars.stream().filter(car-> car.judgeMove())
                .forEach(car->car.moveCar());
        printCarsPositionStatus();
    }

    public List<Car> getWinner(){
        List<Car> winners = new ArrayList<Car>();
        Collections.sort(cars);
        int index = 0;
        Car winner = cars.get(index);
        int winnerPosition = winner.getPosition();
        while(winnerPosition == cars.get(index).getPosition()) {
            winners.add(cars.get(index));
            index++;
        }
        return winners;
    }

    private void printCarsPositionStatus(){
        cars.stream().forEach(car->car.printStatus());
        printLine();
    }

    private void printLine(){
        System.out.println("");
    }
}
