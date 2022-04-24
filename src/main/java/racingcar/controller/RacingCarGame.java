package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.List;

public class RacingCarGame implements Game {
    private static RacingCarGame racingCarGame;
    private final Input input;
    private final Output output;

    private RacingCarGame() {
        this.input = Input.getInstance();
        this.output = Output.getInstance();
    }

    public static RacingCarGame getInstance() {
        if(racingCarGame == null) {
            racingCarGame = new RacingCarGame();
        }
        return racingCarGame;
    }

    @Override
    public void run() {
        List<String> carNames = carNameRequest();
        int round = roundRequest();
        Cars cars = Cars.of(carNames);
        raceStart(cars, round);
        List<String> winnerCarNames = cars.getWinnerCarNames();
        output.printResult(winnerCarNames);
    }

    private void raceStart(Cars cars, int round) {
        for (int i = 0; i < round; i++) {
            cars.race();
            output.printProcess(cars.getCars());
        }
    }

    private int roundRequest() {
        try {
            output.printRoundRequest();
            return input.getRound();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return roundRequest();
        }
    }

    private List<String> carNameRequest() {
        try {
            output.printCarNameRequest();
            return input.getCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return carNameRequest();
        }
    }
}
