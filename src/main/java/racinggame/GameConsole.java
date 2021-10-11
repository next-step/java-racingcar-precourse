package racinggame;

import nextstep.utils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameConsole {
    private final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String ERROR_MESSAGE = "[ERROR] 자동차 이름은 5자리 이하 문자만 입력 가능합니다.";
    private final int CAR_NAME_MAX_LENGTH = 5;
    private final String CAR_NAME_DELIMITER = ",";

    public List<String> getInputValue() {
        List<String> carNames = null;
        boolean doRepeat = true;

        while (doRepeat) {
            printStartMessage();
            String inputValue = Console.readLine();
            carNames = makeCarNames(inputValue);
            boolean isValid = isValid(carNames);
            doRepeat = !isValid;
            printErrorMessageIfNotValid(isValid);
        }

        return carNames;
    }

    private boolean isValid(List<String> carNames) {
        if(carNames.isEmpty()) {
            return false;
        }
        int invalidNameCount = getInvalidNameCount(carNames);
        return invalidNameCount <= 0;
    }

    private int getInvalidNameCount(List<String> carNames) {
        int invalidCount = 0;
        for(String carName: carNames) {
            invalidCount = plusIfInvalid(invalidCount, carName);
        }
        return invalidCount;
    }

    private int plusIfInvalid(int invalidCount, String carName) {
        if(isWhiteSpace(carName)) {
            return invalidCount + 1;
        }
        if(isOverMaxLength(carName)) {
            return invalidCount + 1;
        }
        return invalidCount;
    }

    private boolean isWhiteSpace(String value) {
        return "".equals(value.trim());
    }

    private boolean isOverMaxLength(String carName) {
        return carName.length() > CAR_NAME_MAX_LENGTH;
    }

    private List<String> makeCarNames(String inputValue) {
        List<String> carNames = new ArrayList<>();
        if(!inputValue.contains(CAR_NAME_DELIMITER)) {
            carNames.add(inputValue);
            return carNames;
        }
        String[] splitValue = inputValue.split(CAR_NAME_DELIMITER);
        carNames.addAll(Arrays.asList(splitValue));
        return carNames;
    }

    private void printStartMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    private void printErrorMessageIfNotValid(boolean isValid) {
        if(!isValid) {
            System.out.println(ERROR_MESSAGE);
        }
    }
}
