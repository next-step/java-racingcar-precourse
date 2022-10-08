package racingcar.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarNames {
    public static final String SPLIT_CRITERIA_STRING = ",";
    private final List<CarName> carNameList;

    public CarNames(String carNamesAsString) {
        List<CarName> inputNameList = createCarNames(carNamesAsString);
        validateDuplicateName(inputNameList);
        this.carNameList = inputNameList;
    }

    private List<CarName> createCarNames(String inputNames) {
        List<CarName> carNameList = new ArrayList<>();
        for (String name : inputNames.split(SPLIT_CRITERIA_STRING)) {
            carNameList.add(new CarName(name));
        }
        return carNameList;
    }

    public List<CarName> getList() {
        return carNameList;
    }

    private void validateDuplicateName(List<CarName> carNameList) {
        Set<CarName> duplicateCheckSet = new HashSet<>(carNameList);
        if (duplicateCheckSet.size() != carNameList.size()) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 중복될 수 없습니다.");
        }
    }
}
