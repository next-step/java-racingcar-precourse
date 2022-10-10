package racingcar.domain.car;

import java.util.*;

import static racingcar.domain.ErrorMessage.DUPLICATE_CAR_NAME;

public class CarNames {

    private List<CarName> carNames;

    public CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public static CarNames createCarNamesWithStringCarName(List<String> carNameList) {
        validCarNamesDuplicate(carNameList);

        List<CarName> carNames = new ArrayList<>();
        for (String carName : carNameList) {
            carNames.add(CarName.createCarName(carName));
        }

        return new CarNames(carNames);
    }

    private static void validCarNamesDuplicate(List<String> carNameList) {
        Set<String> carNameSet = new HashSet<>(carNameList);
        if (carNameSet.size() != carNameList.size()) {
            throw new IllegalArgumentException(DUPLICATE_CAR_NAME);
        }
    }

    public static CarNames createCarNamesWithCarName(List<CarName> carNames) {
        return new CarNames(carNames);
    }

    public List<CarName> getCarNames() {
        return Collections.unmodifiableList(carNames);
    }

    public int getSize() {
        return carNames.size();
    }
}
