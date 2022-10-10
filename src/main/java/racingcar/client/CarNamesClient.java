package racingcar.client;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.util.Lists;
import racingcar.domain.Cars;

import java.util.List;

public class CarNamesClient {
    private static final String INPUT_MESSAGE_FOR_CAR_NAMES = "경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)";
    private static final String SEPARATOR_INPUT_CAR_NAME = ",";

    private CarNamesClient() {
    }

    public static Cars inputCarNamesUntilSuccess() {
        printInputMessageForCarName();

        while (true) {
            List<String> carNames = inputCarNames();

            try {
                return Cars.fromStringList(carNames);
            } catch (Exception exception) {
                ErrorMessageClient.printErrorMessage(exception.getMessage());
            }
        }
    }

    private static List<String> inputCarNames() {
        String carNamesString = Console.readLine();

        return Lists.list(
                carNamesString.split(SEPARATOR_INPUT_CAR_NAME)
        );
    }

    private static void printInputMessageForCarName() {
        System.out.println(INPUT_MESSAGE_FOR_CAR_NAMES);
    }
}
