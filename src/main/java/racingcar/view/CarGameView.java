package racingcar.view;

import racingcar.controller.CarGameController;
import racingcar.controller.CarGameResponse;
import racingcar.domain.CarNames;
import racingcar.domain.MoveCount;

public class CarGameView {

    private final CarGameController carGameController;
    private final CarInputController carInputController;

    private static final String RACE_RESULT_PROMPT = "각 차수별 실행 결과";
    private static final String WINNER_PROMPT = "최종 우승자 : ";

    public CarGameView(CarGameController carGameController, CarInputController carInputController) {
        this.carGameController = carGameController;
        this.carInputController = carInputController;
    }

    public void play() {
        CarNames carNames = getCarNames();
        MoveCount moveCount = getMoveCount();

        CarGameResponse carGameResponse = carGameController.play(carNames, moveCount);

        System.out.println(RACE_RESULT_PROMPT);
        System.out.println(carGameResponse.getRaceResult());
        System.out.println(WINNER_PROMPT + carGameResponse.getWinners());
    }

    private MoveCount getMoveCount() {
        try {
            return carInputController.inputMoveCount();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다");
            return getMoveCount();
        }
    }

    private CarNames getCarNames() {
        try {
            return carInputController.inputCarNames();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이름은 5자 이하만 가능합니다");
            return getCarNames();
        }
    }

}
