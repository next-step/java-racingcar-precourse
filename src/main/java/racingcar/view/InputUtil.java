package racingcar.view;

import java.util.Arrays;
import java.util.List;

import static racingcar.common.ErrorMessage.*;

public class InputUtil {
    private static final int NAME_MAX_LENGTH = 5;
    private static final String DELIMITER = ",";
    private static final String NUMBER_REGEX = "[0-9]+";
    private static InputUtil inputUtil;

    private InputUtil() {}

    public static InputUtil getInstance() {
        if(inputUtil == null) {
            inputUtil = new InputUtil();
        }
        return inputUtil;
    }

    public List<String> split(String input) {
        checkInputIsEmpty(input);
        List<String> splitInputs = Arrays.asList(input.replace(" ","").split(DELIMITER));
        carNamesInputValidate(splitInputs);
        return splitInputs;
    }

    private void checkInputIsEmpty(String input) {
        if(input == null || input.trim().length() < 1)
            throw new IllegalArgumentException(EMPTY_INPUT.text());
    }


    private void carNameInputValidate(String carNameInput) {
        if(carNameInput.length() > NAME_MAX_LENGTH)
            throw new IllegalArgumentException(NAME_TO_LONG.text());
    }

    private void carNamesInputValidate(List<String> carNameInputs) {
        for (String carName : carNameInputs){
            carNameInputValidate(carName);
        }
    }

    public int parse(String roundInput) {
        if(roundInput.matches(NUMBER_REGEX)){
            return Integer.parseInt(roundInput);
        }
        throw new IllegalArgumentException(NOT_NUMERIC.text());
    }

}
