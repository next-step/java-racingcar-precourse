package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.model.InputHandler;
import racingcar.model.Winner;
import racingcar.view.GameView;

import java.util.List;

public class GameController {

    private final InputHandler inputHandler;
    private Cars cars;

    public GameController() {
        this.inputHandler = new InputHandler();
    }

    public void start() {
        String inputCars = GameView.askCarsInput();
        cars = Cars.makeCars(inputCarNames(inputCars));

        String inputTry = GameView.askTryInput();
        int round = inputTryCounts(inputTry);

        runGame(round, cars);
    }

    private void runGame(int count, Cars cars) {
        GameView.showGameResult();
        while (count-- > 0) {
            cars.move(cars.generateRandomNumbers());
            System.out.println(cars.toString());
        }
        end(cars);
    }

    private List<String> inputCarNames(String inputCars) {
        try {
            return inputHandler.toCarNames(inputCars);
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return inputCarNames(Console.readLine());
        }
    }

    private int inputTryCounts(String inputTryCounts) {
        try {
            return inputHandler.toInt(inputTryCounts);
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return inputTryCounts(Console.readLine());
        }
    }

    private void end(Cars cars) {
        Winner winner = new Winner(cars);
        System.out.println(winner.toString());
    }
}
