package controller;

import view.InputView;
import view.OutputView;

public class RacingCarFrontController {

    private final RacingCarController racingCarController;
    private final OutputView outputView;


    public RacingCarFrontController(RacingCarController racingCarController,
        OutputView outputView) {
        this.racingCarController = racingCarController;
        this.outputView = outputView;
    }

    /**
     * 애플리케이션 실행 메서드. 입력 뷰를 생성하고  입력에 따라 레이싱 카 생성 및 게임 실행을 반복적으로 시도합니다.
     */
    public void run() {
        try (InputView inputView = new InputView()) {
            executeWithRetry(this::createRacingCars, inputView);
            executeWithRetry(this::playRacing, inputView);
        }
    }

    /**
     * 레이싱 카를 생성하는 메서드. 입력 뷰에서 입력을 받아 컨트롤러에 전달합니다.
     */
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

    /**
     * 레이싱 게임을 실행하는 메서드. 입력 뷰에서 round를 입력 받아 컨트롤러에 전달합니다.
     */
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

    /**
     * 입력 작업을 반복적으로 시도하는 메서드.
     */
    private void executeWithRetry(InputTask task, InputView inputView) {
        boolean success = false;
        while (!success) {
            success = task.execute(inputView);
        }
    }

    /**
     * 입력 작업을 위한 함수형 인터페이스.
     */
    @FunctionalInterface
    private interface InputTask {

        boolean execute(InputView inputView);
    }
}
