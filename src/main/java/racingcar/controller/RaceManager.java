package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.RaceCount;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceManager {
    public static Cars generateCars() {
        Cars cars;
        while (true){
            try {
                String carList = InputView.getCarNames();
                cars = new Cars(carList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return cars;
    }

    public static RaceCount getPlayCount() {
        RaceCount raceCount;
        while (true) {
            try {
                raceCount = new RaceCount(InputView.getRaceCount());
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return raceCount;
    }

    public static void start(Cars cars, RaceCount raceCount) {
        int index = 0;

        ResultView.printStartResult();
        while ( !raceCount.isLast(index) ) {
            cars.play();
            index++;
        }
        ResultView.printCars(cars);
    }




}
