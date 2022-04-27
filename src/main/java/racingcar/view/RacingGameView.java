package racingcar.view;

import racingcar.controller.RacingGameController;
import racingcar.domain.car.Car;
import racingcar.domain.car.WinCars;
import racingcar.global.constant.MessageConfig;

public class RacingGameView {
    private RacingGameController racingGameController;

    public RacingGameView() {
        racingGameController = new RacingGameController();
    }

    public void gameStart() {
        System.out.println(MessageConfig.CAR_NAME_INPUT);
        racingGameController.createCar();
    }

    public void inputPlayCount() {
        System.out.println(MessageConfig.CAR_INPUT_GO_COUNT);
        racingGameController.inputLap();
    }

    public void racingStart() {
        System.out.println(MessageConfig.CAR_RACING_START);
        racingGameController.racingStart();
    }

    public void outputCarDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getDriven(); i++) {
            sb.append("-");
        }
        System.out.println(car.getName() + " : " + sb.toString());
    }

    public void outputWinCars(WinCars winCars) {
        System.out.println(MessageConfig.WIN_RESULT + winCars.getCarsNameString());
    }
}
