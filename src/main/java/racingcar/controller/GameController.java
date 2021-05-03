package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.MoveCount;
import racingcar.view.ResultOutputView;
import racingcar.view.UserInputView;

import java.util.Scanner;

public class GameController {
    private final UserInputView inputView;
    private final ResultOutputView outputView;

    public GameController(Scanner scanner) {
        this.inputView = new UserInputView(scanner);
        this.outputView = new ResultOutputView(scanner);
    }

    public void run() {
        responseResult(requestCars(), requestMoveCount());
    }

    private Cars requestCars() {
        try {
            return new Cars(inputView.requestCarNames());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return requestCars();
    }

    private MoveCount requestMoveCount() {
        try {
            return new MoveCount(inputView.requestMoveCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return requestMoveCount();
    }

    private void responseResult(Cars cars, MoveCount count) {
        outputView.responseMoveResult();
        for (int i = 0, max = count.getCount(); i < max; i++) {
            cars.move();
            outputView.responseMoveResult(cars);
        }
        outputView.responseWinners(cars.getWinners());
    }
}
