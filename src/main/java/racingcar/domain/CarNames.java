package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.service.InputValidator;

public class CarNames {

    private final List<CarName> carNames;

    private CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public static CarNames of(final String carNamesInput) {
        InputValidator.validateCarNamesInput(carNamesInput);
        final String[] carNameArray = carNamesInput.split(",");
        validateCarNamesSize(carNameArray);
        return new CarNames(createCarNameList(carNameArray));
    }

    private static void validateCarNamesSize(final String[] carNameArray) {
        if (carNameArray.length < 2) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAMES_LESS_THAN_TWO.getMessage());
        }
    }

    private static void validateCarNamesDuplication(final List<CarName> carNameList, final Set<String> carNameSet) {
        if (carNameList.size() != carNameSet.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAMES_DUPLICATED.getMessage());
        }
    }

    private static List<CarName> createCarNameList(final String[] carNameArray) {
        final List<CarName> carNameList = new ArrayList<>();
        final Set<String> carNameSet = new HashSet<>();
        for (String carName : carNameArray) {
            carNameList.add(CarName.of(carName));
            carNameSet.add(carName);
        }
        validateCarNamesDuplication(carNameList, carNameSet);
        return carNameList;
    }

    public int getSize() {
        return carNames.size();
    }

    public CarName getCarName(final int index) {
        return carNames.get(index);
    }

}
