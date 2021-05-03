package com.tjnam.racingcargame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Cars cars;
    private RacingTime racingTime;
    private List<Car> winners;

    private static CarNameInputGetter carNameInput = new CarNameInputGetter();
    private static RacingTimeInputGetter racingTimeInput= new RacingTimeInputGetter();

    public void start(){
        List<CarName> carNameList = carNameInput.getCarNameInput();
        List<Car> carsList = new ArrayList<Car>();
        for (CarName carName : carNameList) {
            carsList.add(new Car(carName));
        }
        cars = new Cars(carsList);
        racingTime = new RacingTime(racingTimeInput.getUserInput());
        race();
    }

    private void race(){
        do {
            cars.raceCars();
            racingTime.use();
        } while(racingTime.getRemained() > 0);
        getWinner();
        printWinner();
    }

    private void getWinner(){
        winners = cars.getWinner();
    }

    private void printWinner(){
        List<String> carNames = new ArrayList<String>();
        for (Car car : winners){
            carNames.add(car.getCarName());
        }
        System.out.print(String.join(", ", carNames));
        System.out.println("가 최종 우승했습니다");
    }
}
