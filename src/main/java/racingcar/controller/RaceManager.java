package racingcar.controller;

import racingcar.domain.PlayCars;
import racingcar.domain.RaceCount;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class RaceManager {
    public static PlayCars generateCars() {
        PlayCars playCars;
        while (true){
            try {
                String carList = InputView.getCarNames();
                playCars = new PlayCars(carList);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return playCars;
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

    public static void start(PlayCars playCars, RaceCount raceCount) {
        int index = 0;

        ResultView.printStartResult();
        while ( !raceCount.isLast(index) ) {
            playCars.play();
            index++;
        }
        ResultView.printCars(playCars);
    }




}
