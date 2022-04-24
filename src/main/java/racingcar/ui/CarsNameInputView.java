package racingcar.ui;

import static racingcar.constant.ErrorStatus.CAR_NAME_PATTERN_NOT_MATCHED;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import racingcar.constant.InputStatus;
import racingcar.domain.Cars;

public class CarsNameInputView {

    private static final Pattern pattern = Pattern.compile("^[a-zA-Z,]*$");
    private static InputStatus status = InputStatus.INPUT_IN_PROGRESS;

    public static Cars get() {
        Cars cars = new Cars(new ArrayList<>());
        while (status.isContinue()) {
            cars = getCarsFromInput();
        }
        return cars;
    }

    private static Cars getCarsFromInput() {
        try {
            String input = InputView.getConsoleInputWithMessage("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)기준으로 구분)");
            validateConsoleInput(input);
            status = InputStatus.INPUT_END;
            return new Cars(convertToList(input));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            status = InputStatus.INPUT_IN_PROGRESS;
        }
        return null;
    }

    private static void validateConsoleInput(String input) {
        if (!pattern.matcher(input).find()) {
            throw new IllegalArgumentException(CAR_NAME_PATTERN_NOT_MATCHED.getMessage());
        }
    }

    private static List<String> convertToList(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

}
