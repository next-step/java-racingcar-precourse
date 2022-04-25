package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    private final String ERROR_DUPLICATE_CAR_NAME = "[ERROR] 차 이름은 중복될 수 없습니다.";

    private final List<CarName> carNames;

    private CarNames(String userInput) {
        String[] inputNames = userInput.split(",");
        List<CarName> inputCarNames = new ArrayList<>();
        for (String name : inputNames) {
            CarName carName = CarName.createCarName(name);
            validateCarName(inputCarNames, carName);
            inputCarNames.add(carName);
        }
        this.carNames = inputCarNames;
    }

    private void validateCarName(List<CarName> inputCarNames, CarName carName) {
        if (isDuplicate(inputCarNames, carName)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_CAR_NAME);
        }
    }

    private boolean isDuplicate(List<CarName> inputCarNames, CarName carName) {
        return inputCarNames.contains(carName);
    }

    public static CarNames getCarNamesFromInput(String userInput) {
        return new CarNames(userInput);
    }

    public List<CarName> getCarNames() {
        return this.carNames;
    }
}
