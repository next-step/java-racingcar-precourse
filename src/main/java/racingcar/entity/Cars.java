package racingcar.entity;

import java.util.Map;
import java.util.LinkedHashMap;

public class Cars {
    private final Map<String, Integer> carMap = new LinkedHashMap<>();

    public Cars() {
        checkCarNameExist("");
        checkCarNameLength("");
        checkCarNameDuplication("");
    }

    public Cars(String inputValue) {
        checkCarNameExist(inputValue);

        for (String carName : inputValue.split(",")) {
            checkCarNameLength(carName);
            checkCarNameDuplication(carName);
        }
    }

    public Map<String, Integer> getCarMap() {
        return carMap;
    }

    private void checkCarNameExist(String carName) {
        if (carName.length() < 1) {
            throw new IllegalStateException("[ERROR] 경주 할 자동차 이름 입력값이 존재하지 않습니다.");
        }
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 경주 할 자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private void checkCarNameDuplication(String carName) {
        if (carMap.containsKey(carName)) {
            throw new IllegalArgumentException("[ERROR] 경주 할 자동차 이름은 중복 될 수 없습니다.");
        }

        carMap.put(carName, 0);
    }
}
