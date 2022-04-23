package racingcar.vo;

import java.util.HashSet;
import java.util.List;
import racingcar.constant.RacingCarNameLength;
import racingcar.constant.ErrorMessage;

public class RacingCarNames {

    private List<String> carNameList;

    public RacingCarNames(List<String> carNameList) {
        for (String carName : carNameList) {
            validateCarNameLength(carName);
        }
        validateDuplication(carNameList);
        this.carNameList = carNameList;
    }

    private void validateCarNameLength(String carName) {
        int carNameLength = carName.length();
        if (carNameLength < RacingCarNameLength.MIN || carNameLength > RacingCarNameLength.MAX) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LIMIT);
        }
    }

    private void validateDuplication(List<String> carNameList){
        int inputCarNameSize = carNameList.size();
        int deleteDuplicationCarNameSize = new HashSet<>(carNameList).size();
        if(inputCarNameSize > deleteDuplicationCarNameSize){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATION);
        }
    }

}
