package racinggame.ui;

import nextstep.utils.Console;
import racinggame.domain.Cars;
import racinggame.domain.Racing;
import racinggame.domain.exceptions.CarException;

public class InputView {
    private static final String INPUT_RACING_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";


    public static Racing startRacing(Cars cars, int attemptCount) {

        return new Racing(cars, attemptCount);
    }

    public static String inputCarNames() {
        System.out.println(INPUT_RACING_CAR_NAME_MESSAGE);
        return Console.readLine();
    }

    public static int inputAttemptCount() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        int attemptCount = Integer.parseInt(Console.readLine());
        return attemptCount;
    }

    public static Cars createCars() {
        String carNames = inputCarNames();

        try {
            Cars cars = new Cars(carNames);
        } catch (CarException e) {
            System.out.println(e.getMessage());
        }

        return new Cars(carNames);
    }

}
