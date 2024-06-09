package util;

import java.util.*;
import static exception.ErrorMsg.*;

public class InputValidator {

    public static boolean validateCarName(String[] carNames){
        Set<String> carNameSet = new HashSet<>();

        if(carNames.length < 2) {
            throw new IllegalArgumentException(ERROR_TOO_FEW_CARS);
        }

        for (String carName : carNames) {

            //이름이 null인 경우
            if (carName.isEmpty()) {
                throw new IllegalArgumentException(ERROR_EMPTY_NAME);
            }

            //이름에 공백이 포함된 경우
            if (carName.contains(" ")) {
                throw new IllegalArgumentException(ERROR_SPACE_IN_NAME);
            }

            //이름의 길이가 5초과
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ERROR_NAME_TOO_LONG);
            }

            //영문으로 이루어지지 않은 이름
            if (!carName.matches("^[a-zA-Z]*$")) {
                throw new IllegalArgumentException(ERROR_INVALID_CHARACTER);
            }

            //중복된 이름
            if (!carNameSet.add(carName)) {
                throw new IllegalStateException(ERROR_DUPLICATE_NAME);
            }
        }
        return true;
    }
    public static boolean validateAttemptNum(int attempt){

        if (attempt < 1){
            throw new IllegalArgumentException(ERROR_INVALID_ATTEMPT_NUMBER);
        }
        return true;
    }
}
