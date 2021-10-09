package racinggame;

import racinggame.view.InputView;
import racinggame.view.ResultView;

class PlayRacingGame {

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();
    private Cars cars;


    void startGame() {

        String carName = inputView.insertCarNames();
        processException(carName);

        int tryCount = inputView.insertTryCount();

        startCars(cars, tryCount);

    }

    private void processException(String carName) {

        try {
            cars = Cars.of(carName, new RandomMove());

        } catch (Exception e) {
            System.out.println("[ERROR] " + e.getMessage());
            startGame();
        }
    }

    private void startCars(Cars cars, int tryCount) {

        for (int i = 0; i < tryCount; i++) {
            cars.moveCars();
            resultView.printCarsDistance(cars, tryCount);
        }
        resultView.endRacing();
        resultView.printWinners(cars);

    }
}
