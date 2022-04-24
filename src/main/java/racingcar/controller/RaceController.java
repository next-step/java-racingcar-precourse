package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.ConsoleHandler;

public class RaceController {

    private final ConsoleHandler consoleHandler;

    public RaceController() {
        this.consoleHandler = new ConsoleHandler();
    }

    public void raceStart() {
        Cars cars = getCarsWithUserInput();
        int roundNumber = getRoundNumberWithUserInput();

        runRound(cars, roundNumber);
        raceResult(cars);
    }

    private Cars getCarsWithUserInput() {
        while (true) {
            try {
                System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
                return new Cars(consoleHandler.readCarNames());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getRoundNumberWithUserInput() {
        while (true) {
            try {
                System.out.println("시도할 회수는 회인가요?");
                return consoleHandler.readRoundNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void runRound(Cars cars, int roundNumberInput) {
        for (int i = 0; i < roundNumberInput; i++) {
            cars.runRound();
            System.out.println();   // 라운드 출력 구분
        }
    }

    private void raceResult(Cars cars) {
        cars.getWinner();
    }

}
