package racingcar.ui;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.AttemptCount;
import racingcar.domain.Cars;
import racingcar.exception.domain.CarNameException;
import racingcar.exception.domain.CarsException;
import racingcar.exception.ui.AttemptCountEmptyException;
import racingcar.exception.ui.AttemptCountTypeException;

public class InputView {
    private static final String INPUT_CARS_MESSAGE = "경주할자동차이름(이름은쉼표(,)기준으로구분)";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 회수";

    public static Cars racing() {
        Racing racing = new Racing(createCars(), inputAttemptCount());
        return racing.start();
    }

    public static Cars createCars() {
        try {
            System.out.println(INPUT_CARS_MESSAGE);
            String inputs = Console.readLine();
            return new Cars(inputs);
        } catch (CarNameException e) {
            System.out.println(e.getMessage());
            return createCars();
        } catch (CarsException e) {
            System.out.println(e.getMessage());
            return createCars();
        }
    }

    private static AttemptCount inputAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        String attemptCountToString = Console.readLine();

        try {
            return new AttemptCount(attemptCountToString);
        } catch (AttemptCountTypeException e) {
            System.out.println(e.getMessage());
            return inputAttemptCount();
        } catch (AttemptCountEmptyException e) {
            System.out.println(e.getMessage());
            return inputAttemptCount();
        }
    }

}
