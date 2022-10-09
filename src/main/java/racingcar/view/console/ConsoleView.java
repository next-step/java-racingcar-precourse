package racingcar.view.console;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.View;

public class ConsoleView implements View {

    @Override
    public void printCarNameInputMessage() {
        System.out.print(INPUT_MESSAGE_CAR_NAME);
    }

    @Override
    public void printAttemptsInputMessage() {
        System.out.print(INPUT_MESSAGE_ATTEMPTS);
    }

    @Override
    public void printRoundResultMessage() {
        System.out.print(OUTPUT_MESSAGE_ROUND_RESULT);
    }

    @Override
    public void printCarForwardResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.printf(OUTPUT_MESSAGE_FORMAT_CAR_FORWARD_RESULT,
                    car.getName().getCarName(),
                    car.getForwardString().getString()
            );
        }
        System.out.println();
    }

    @Override
    public void printWinner(List<String> winnerNames) {
        System.out.print(OUTPUT_MESSAGE_FORMAT_WINNER);
        StringBuilder sb = new StringBuilder(winnerNames.size() * MAXIMUM_NAME_LENGTH);
        for (String winnerName : winnerNames) {
            sb.append(winnerName).append(COMMA);
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    @Override
    public void printErrorMessage(String message) {
        System.out.printf(ERROR_MESSAGE_FORMAT, message);
    }
}
