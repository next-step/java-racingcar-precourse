package racingcar.controller;

import racingcar.domain.CarList;
import racingcar.util.MessageUtils;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

public class RaceingcarController {
    private final InputView inputView;
    private final OutPutView outPutView;

    public RaceingcarController(InputView inputView,
                                OutPutView outPutView) {
        this.inputView = inputView;
        this.outPutView = outPutView;
    }

    /** 레이싱 게임 시작 */
    public void start() {
        CarList carList = inputCarNames();
        tryRace(carList);
        outPutView.winnerPrint(carList);
    }

    /* 차의 이름들을 입력 받는 메서드 */
    private CarList inputCarNames() {
        CarList carList;
        try {
            carList = new CarList(inputView.inputCarName());
        } catch (IllegalArgumentException e) {
            System.out.println(MessageUtils.getErrorMessage(e.getMessage()));
            return inputCarNames();
        }
        return carList;
    }

    /* 횟수 만큼 전진과 후진을 함*/
    private void tryRace(CarList carList) {
        int tryNumber = inputView.inputTry();
        for (int i = 0; i < tryNumber; i++) {
            carList.race();
            outPutView.carsStatusPrint(carList);
        }
    }
}
