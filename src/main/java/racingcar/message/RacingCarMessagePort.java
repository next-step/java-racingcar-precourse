package racingcar.message;

import racingcar.context.Printer;
import racingcar.context.Scanner;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarNames;
import racingcar.domain.car.Cars;
import racingcar.domain.move.TryCount;
import racingcar.domain.winner.Winner;

public class RacingCarMessagePort implements RacingCarMessageAware {

    private RacingCarMessage message = null;

    private final Printer printer;
    private final Scanner scanner;

    public RacingCarMessagePort(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    public Cars getCars() {
        printer.println(getMessage().getNames());
        CarNames carNames = new CarNames(scanner.getNames());
        return new Cars(carNames);
    }

    public TryCount getTry() {
        printer.println(getMessage().getTry());
        return new TryCount(scanner.getTry());
    }

    public void play(Cars cars) {
        for (Car car : cars) {
            printer.println(car.toString());
        }
        printer.println();
    }

    public void finish(Winner winner) {
        printer.println(getMessage().getWinner() + winner.toString());
    }

    public void error(String message) {
        printer.println(message);
    }

    @Override
    public RacingCarMessage getMessage() {
        if (message == null) {
            message = new RacingCarMessage();
        }
        return message;
    }
}
