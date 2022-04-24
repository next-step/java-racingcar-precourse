package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.PlayCount;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Controller {
    public static void start(Cars cars, PlayCount playCount) {
        int index = 0;

        ResultView.printStartResult();
        while ( !playCount.isLast(index) ) {
            cars.play();
            index++;
        }
        ResultView.printCars(cars);
    }

    public static PlayCount makePlayCount() {
        PlayCount playCount;
        while (true) {
            try {
                playCount = new PlayCount(InputView.askTryCount());
                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return playCount;
    }

    public static Cars makeCars() {
        Cars cars;
        while (true){
            try {
                String carList = InputView.askCars();
                cars = new Cars(carList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return cars;
    }
}
