package racinggame.controller;

import racinggame.domain.Cars;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        Cars cars = inputView.inputCarName();
        int labCount = inputView.inputLabCount();
        playLabs(cars, labCount);
    }

    private void playLabs(Cars cars, int labCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < labCount; i++) {
            cars.race();
            outputView.printCarsPosition(cars);
        }
    }
}
