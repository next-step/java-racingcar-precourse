package racingcar.vo;

import java.util.HashSet;
import java.util.List;
import racingcar.constant.RacingCarNameLength;
import racingcar.constant.ErrorMessage;

public class RacingCars {

    private List<String> carList;

    public RacingCars(List<String> carList) {
        for (String carName : carList) {
            validateCarNameLength(carName);
        }
        validateCarNameDuplication(carList);
        this.carList = carList;
    }

    private void validateCarNameLength(String carName) {
        int carNameLength = carName.length();
        if (carNameLength < RacingCarNameLength.MIN || carNameLength > RacingCarNameLength.MAX) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LIMIT);
        }
    }

    private void validateCarNameDuplication(List<String> carNameList){
        int inputCarNameSize = carNameList.size();
        int deleteDuplicationCarNameSize = new HashSet<>(carNameList).size();
        if(inputCarNameSize > deleteDuplicationCarNameSize){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATION);
        }
    }

}
