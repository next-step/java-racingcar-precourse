package racinggame.view;

import nextstep.utils.Console;
import racinggame.exception.ErrorCode;
import racinggame.exception.RaceGameException;
import racinggame.utils.RaceValidation;

import java.util.Arrays;
import java.util.List;

import static racinggame.constants.RaceGameConstants.*;

public class InputView {

    public List<String> getUserInputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        return convertCarNames(cars);
    }

    public int getUserInputTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();
        RaceValidation.validateNumberMatch(count);
        return Integer.parseInt(count);
    }

    private List<String> convertCarNames(String inputString) {
        RaceValidation.validateEmptyName(inputString);
        String[] cars = inputString.split(SPLIT_REGEX);
        for (String car : cars) {
            RaceValidation.validateLengthOverName(car);
        }
        return Arrays.asList(cars);
    }

}
