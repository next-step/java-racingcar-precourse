package racingcar.view;

import racingcar.race.CarDto;
import racingcar.view.message.Distance;
import racingcar.view.message.Message;

import java.io.PrintStream;
import java.util.List;

public class OutputView {
    private final PrintStream output;
    private final Message message;
    
    public OutputView(PrintStream output, Message message) {
        this.output = output;
        this.message = message;
    }

    public void printResult(List<List<CarDto>> result) {
        printTitle();
        printContentWith(result);
    }

    private void printTitle() {
        output.println();
        output.println(message.resultTitle());
    }

    private void printContentWith(List<List<CarDto>> result) {
        for (List<CarDto> cars : result) {
            printMoveDistancesWith(cars);
            output.println();
        }
    }

    private void printMoveDistancesWith(List<CarDto> cars) {
        for (CarDto car : cars) {
            final String carName = car.name();
            final Distance distance = Distance.from(car.position());
            output.println(message.moveDistance(carName, distance));
        }
    }

    public void printWinners(List<String> winners) {
        output.println(message.winners(winners));
    }


    public void printError(String errorMessage) {
        output.println(message.error(errorMessage));
    }
}
