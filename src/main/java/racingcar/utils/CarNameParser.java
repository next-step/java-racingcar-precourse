package racingcar.utils;

import java.util.Arrays;

public class CarNameParser {

    public static final String NAME_DELIMITER = ",";
    public static final int MIN_SIZE = 1;
    public static final int MAX_SIZE = 5;
    public static final String BLANK_PATTERN = " ";

    public static String[] parseCarName(String carNameStr) {
        String[] carNames = carNameStr.split(NAME_DELIMITER);
        for (String carName : carNames) {
            validateCarNameSize(carName);
            validateBlankInCarName(carName);
        }
        return carNames;
    }

    public static void validateCarNameSize(String name) {
        if(name.length() < MIN_SIZE || name.length() > MAX_SIZE){
            throw new IllegalArgumentException("[ERROR] 이름은 " + MIN_SIZE + "자 이상 " + MAX_SIZE + "자 이하여야 합니다.");
        }
    }

    public static void validateBlankInCarName(String name) {
        if(name.contains(BLANK_PATTERN)){
            throw new IllegalArgumentException("[ERROR] 이름에는 공백이 들어갈 수 없습니다.");
        }
    }
}
