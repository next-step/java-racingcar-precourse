package racingcar.vo;

import java.util.HashSet;
import java.util.List;
import racingcar.constant.CarNameLength;
import racingcar.constant.ErrorMessage;

public class CarNames {

    private List<String> carNameList;

    public CarNames(List<String> carNameList) {
        for (String carName : carNameList) {
            validateCarNameLength(carName);
        }
        validateDuplication(carNameList);
        this.carNameList = carNameList;
    }

    private void validateCarNameLength(String carName) {
        int carNameLength = carName.length();
        if (carNameLength < CarNameLength.MIN || carNameLength > CarNameLength.MAX) {
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
