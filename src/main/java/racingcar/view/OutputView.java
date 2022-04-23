package racingcar.view;

import racingcar.constant.Message;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    public static void showMsgGameResult() {
        System.out.println(Message.MSG_OUTPUT_GAME_RESULT);
    }
    public static void showCarsPath(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.println(car.getName() + " : " + car.getPath());
        }
        System.out.println();
    }

    public static void showWinners(Cars cars) {
        System.out.println(Message.MSG_OUTPUT_FINAL_WINNER + cars.getWinners());
    }
}
