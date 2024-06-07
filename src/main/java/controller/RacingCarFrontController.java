package controller;

import view.InputView;
import view.OutputView;

public class RacingCarFrontController {

    private final RacingCarController racingCarController;
    private final OutputView outputView;
    private final InputView inputView;

    public RacingCarFrontController(RacingCarController racingCarController,
        OutputView outputView, InputView inputView) {
        this.racingCarController = racingCarController;
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        try (InputView inputView = new InputView()) {
            executeWithRetry(this::createRacingCars, inputView);
            executeWithRetry(this::playRacing, inputView);
        }
    }

    private boolean createRacingCars(InputView inputView) {
        try {
            String input = inputView.enterCarNames();
            racingCarController.createRacingCar(new RacingCarRequest.CreateCarRequest(input));
            return true;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return false;
        }
    }

    private boolean playRacing(InputView inputView) {
        try {
            String input = inputView.enterTryCount();
            RacingCarResponse.ResultGameResponse gameResult = racingCarController.playRacing(
                new RacingCarRequest.RacingRoundRequest(input));
            outputView.printGameResult(gameResult.gameResult());
            return true;
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return false;
        }
    }

    private void executeWithRetry(InputTask task, InputView inputView) {
        boolean success = false;
        while (!success) {
            success = task.execute(inputView);
        }
    }


    @FunctionalInterface
    private interface InputTask {

        boolean execute(InputView inputView);
    }
}
