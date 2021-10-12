package racinggame.domain;

import racinggame.msg.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNames {
    ArrayList<CarName> carNames;

    public CarNames(String carNames) {
        validateCarNames(carNames);
        setCarNames(carNames);
    }

    public ArrayList<CarName> getCarNames() {
        return carNames;
    }

    private void setCarNames(String originCarNames) {
        String[] tmpCarNames = originCarNames.split(",");
        for (int namesIdx = 0; namesIdx < tmpCarNames.length; namesIdx++) {
            CarName carName = new CarName(tmpCarNames[namesIdx]);
            carNames.add(carName);
        }
    }

    private void validateCarNames(String originCarNames) {
        isNotNull(originCarNames);
        List<String> carNamesGroup = splitCarNames(originCarNames);
        isValidNumberOfName(carNamesGroup);
        isValidCarNames(carNamesGroup);
    }

    private List<String> splitCarNames(String originCarNames) {
        return new ArrayList<>(Arrays.asList(originCarNames.split(",")));
    }

    private void isNotNull(String originCarNames) {
        if (originCarNames == null) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_CAN_NOT_BE_NULL);
        }
    }

    private void isValidCarNames(List<String> originCarNames) {
        for (String originCarName : originCarNames) {
            CarName carName = new CarName(originCarName);
        }
    }

    private void isValidNumberOfName(List<String> originCarNames) {
        if (originCarNames.size() <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_CAR_NAMES_CAN_BE_POSITIVE);
        }
    }
}
