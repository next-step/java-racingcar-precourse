package racingcar.global.validate;

import racingcar.domain.InputData;
import racingcar.domain.validate.ValidateNameList;
import racingcar.domain.validate.ValidateNameSet;
import racingcar.domain.validate.ValidateResult;
import racingcar.global.config.CarConfig;

public class ValidateCar {

    private ValidateCar() {}

    public static boolean isValidCarZeroNameLength(InputData inputData) {
        String[] inputArr = inputData.getSplitInputData(",");
        if (inputArr.length == 0){
            return true;
        }
        ValidateResult validateResult = new ValidateResult();
        for (int i = 0; i < inputArr.length; i++){
            carZeroNameLengthCheck(validateResult, inputArr[i]);
        }
        return validateResult.getValidateResult();
    }

    public static boolean isInvalidCarNameLength(InputData inputData) {
        String[] inputArr = inputData.getSplitInputData(",");
        ValidateResult validateResult = new ValidateResult();
        for (int i = 0; i < inputArr.length; i++){
            carNameLengthCheck(validateResult, inputArr[i]);
        }
        return validateResult.getValidateResult();
    }

    public static boolean isDuplicatedCarName(InputData inputData) {
        String[] inputArr = inputData.getSplitInputData(",");
        ValidateNameList validateNameList = new ValidateNameList();
        ValidateNameSet validateNameSet = new ValidateNameSet();
        for (int i = 0; i < inputArr.length; i++){
            validateNameList.add(inputArr[i]);
            validateNameSet.add(inputArr[i]);
        }
        return validateNameList.getValidateNameListSize() != validateNameSet.getValidateNameSetSize();
    }

    private static ValidateResult carZeroNameLengthCheck(ValidateResult validateResult, String inputSplitData) {
        if (!validateResult.getValidateResult())
            validateResult.setValidateResult(CarConfig.MIN_CAR_NAME_LENGTH == inputSplitData.length());
        return validateResult;
    }

    private static ValidateResult carNameLengthCheck(ValidateResult validateResult, String inputSplitData) {
        if (!validateResult.getValidateResult())
            validateResult.setValidateResult(inputSplitData.length() > CarConfig.MAX_CAR_NAME_LENGTH);
        return validateResult;
    }

}

