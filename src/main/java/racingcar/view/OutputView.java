package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Winner;
import racingcar.utils.ViewUtils;

import java.util.List;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private OutputView() {

    }

    public static void printResult(List<Car> game) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : game) {
            stringBuilder.append(car.name()).append(" : ").append(ViewUtils.drawLine(car.position())).append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void printWinner(List<Winner> winnerList) {
        System.out.println("최종 우승자 : " + ViewUtils.printWinners(winnerList));
    }

    public static void printErrorMessage(String test) {
        System.out.println(ERROR_MESSAGE + " " + test);
    }
}
