package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.GameProcess;
import racingcar.domain.RacingGame;

import static racingcar.constant.Message.RESULT_HEAD_MESSAGE;
import static racingcar.constant.Message.RESULT_CAR_INFO;
import static racingcar.constant.Constant.BAR;
import static racingcar.constant.Message.RESULT_CAR_NAME;

public class OutputView {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void EnterMessage() {
        System.out.println();
    }

    public static void printResult(RacingGame racingGame) {
        printMessage(RESULT_HEAD_MESSAGE);
        printGameProcesses(racingGame.getGameProcesses());
        printWinner(racingGame.getWinner());
    }


    private static void printGameProcesses(GameProcess gameProcess) {
        for (Cars process : gameProcess.getProcesses()) {
            printEachGameProcess(process);
            EnterMessage();
        }
    }

    private static void printEachGameProcess(Cars process) {
        for (Car car : process.getCarList()) {
            System.out.printf(RESULT_CAR_INFO, car.getCarName(), addBarWithCarPosition(car.getPosition()));
        }

    }

    private static String addBarWithCarPosition(int position) {
        StringBuilder stringBuilder = new StringBuilder();
        while (position > 0) {
            stringBuilder.append(BAR);
            position--;
        }
        return stringBuilder.toString();
    }

    private static void printWinner(Cars winner) {
        System.out.printf(RESULT_CAR_NAME, Cars.getWinnerCarName(winner));
    }


}
