package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.ResultView;

public class Application {

    private static final InputView inputView = new InputView();
    private static final ResultView resultView = new ResultView();

    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();

        Cars inputCars = createCars();
        int moveCount = inputMoveCount();
        Cars cars = racingCarController.play(inputCars, moveCount);
        resultView.printCars(cars);
    }

    private static int inputMoveCount() {
        Integer moveCount = null;
        while (moveCount == null) {
            moveCount = tryGetMoveCount();
        }
        return moveCount;
    }

    private static Integer tryGetMoveCount() {
        try {
            return inputView.inputCarsMoveCount();
        } catch (NumberFormatException ex) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
        return null;
    }

    private static Cars createCars() {
        Cars cars = null;
        while (cars == null) {
            cars = tryCreate();
        }
        return cars;
    }

    private static Cars tryCreate() {
        try {
            String[] names = inputView.inputCarsNames();
            return new Cars(names);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

}
