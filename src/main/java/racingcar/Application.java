package racingcar;

import static racingcar.module.Validator.validateRacingCarNames;
import static racingcar.module.Validator.validateRacingCount;

import racingcar.module.Display;
import racingcar.module.RacingComputer;

public class Application {

    public static void main(String[] args) {
        Display display = new Display();
        try {
            String carNames = display.inputRacingCarNames();
            validateRacingCarNames(carNames);
            String racingCount = display.inputRacingCount();
            validateRacingCount(racingCount);

            RacingComputer computer = new RacingComputer(carNames, Integer.parseInt(racingCount));
            computer.compute();
            display.printRacingResult(computer.getCars());
            display.printWinners(computer.getWinnerNames());
        } catch (IllegalArgumentException e) {
            display.printError(e);
        }
    }

}
