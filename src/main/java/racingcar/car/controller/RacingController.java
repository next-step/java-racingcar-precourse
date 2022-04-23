package racingcar.car.controller;

import racingcar.car.GameStatus;
import racingcar.car.model.RacingModel;
import racingcar.car.view.RacingView;

public class RacingController {
    private final RacingView racingView;
    private final RacingModel racingModel;
    private final String ERROR_INPUT = "";

    public RacingController() {
        this.racingView = new RacingView();
        this.racingModel = new RacingModel();
    }

    public void startRace() {
        racingModel.createCars(getInput(GameStatus.CAR_NAME)); /* 차 이름 입력후 검증, racingModel에 Cars 설정 */
        int racingNumber = Integer.parseInt(getInput(GameStatus.RACING_NUMBER)); /* Racing 횟수 입력 후 검증, Int로 Cast */
        for (int racingCount = 0; racingCount < racingNumber; racingCount++) {
            racingView.printProgress(racingModel.move());
        }
        racingView.printWinner(racingModel.electWinner());
    }

    private String getInput(GameStatus gameStatus) {
        String input = ERROR_INPUT;
        while (input.equals(ERROR_INPUT)) {
            input = validateInput(gameStatus);
        }
        return input;
    }

    private String validateInput(GameStatus gameStatus) {
        String input;
        try {
            input = racingModel.validateInput(racingView.getInput(gameStatus), gameStatus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            input = ERROR_INPUT;
        }
        return input;
    }
}
