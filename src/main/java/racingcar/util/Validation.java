package racingcar.util;

import static racingcar.util.Constans.LIMIT_CAR_NAME;
import static racingcar.util.Constans.REGEX_CAR_ROUND_NUMBER;
import static racingcar.util.Constans.SPLIT_CAR_NAME_DELIMITER;
import static racingcar.util.Messages.ERROR_CAR_NAME_DUPLICATION;
import static racingcar.util.Messages.ERROR_CAR_NAME_LIMIT;
import static racingcar.util.Messages.ERROR_RACING_ROUND_NUMBER;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validation {
    public void validationCarName(String carNames) {
        String[] carNameArray = carNames.split(SPLIT_CAR_NAME_DELIMITER);
        validationCarNameSize(carNameArray);
        validationCarNameDuplication(carNameArray);
    }

    private void validationCarNameDuplication(String[] carNameArray) {
        List<String> carNameList = Arrays.asList(carNameArray);
        Set<String> setCarNames = new HashSet<>(carNameList);
        if (carNameList.size() != setCarNames.size()){
            throw new IllegalArgumentException(ERROR_CAR_NAME_DUPLICATION);
        }
    }

    private void validationCarNameSize(String[] carNameArray) {
        for(String carName: carNameArray){
            if (carName.length() > LIMIT_CAR_NAME) {
                throw new IllegalArgumentException(ERROR_CAR_NAME_LIMIT);
            }
        }
    }

    public void validationRound(String round) {
        if (!round.matches(REGEX_CAR_ROUND_NUMBER)) {
            throw new IllegalArgumentException(ERROR_RACING_ROUND_NUMBER);
        }
    }
}
