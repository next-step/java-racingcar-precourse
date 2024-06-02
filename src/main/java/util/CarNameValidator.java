package util;

import java.util.List;

public class CarNameValidator implements InputValidator {

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String CAR_NAME_ERROR_MESSAGE = "자동차 이름의 길이가 " + CAR_NAME_MAX_LENGTH + "를 초과하였습니다.";
    private static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "중복된 자동차 이름이 있습니다.";

    @Override
    public void checkInputValue(Object input) {
        List<String> carNameList = (List<String>) input;
        for (String carName : carNameList) {
            checkCarName(carName);
        }
        // 중복된 자동차 이름이 있는 경우 예외 발생
        if (carNameList.size() != carNameList.stream().distinct().count()) {
            raiseIllegalArgumentException(DUPLICATE_CAR_NAME_ERROR_MESSAGE);
        }
    }

    private void checkCarName(String carName) {
        // 자동차 이름의 길이가 최대 길이보다 초과하면 예외 발생
        if (carName.length() > CAR_NAME_MAX_LENGTH) {
            raiseIllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }
}
