package racingcar.model.input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarNames {
    private static final int MIN_SIZE = 1;
    private static final int MAX_SIZE = 7;

    private static final String UNDER_SIZE_ERROR_MESSAGE = String.format("[ERROR] %d대 이상의 자동차를 입력해주세요!", MIN_SIZE);
    private static final String OVER_SIZE_ERROR_MESSAGE = String.format("[ERROR] %d대 이하의 자동차를 입력해주세요!", MAX_SIZE);
    private static final String NOT_UNIQUE_ERROR_MESSAGE = "[ERROR] 중복된 자동차 이름이 존재합니다!";

    private final List<CarName> carNames = new ArrayList<>();

    public CarNames(List<String> names) {
        validateCarNames(names);
        for (String name : names) {
            carNames.add(new CarName(name));
        }
    }

    public void validateCarNames(List<String> names) {
        int carNamesSize = names.size();
        if (carNamesSize < MIN_SIZE)
            throw new IllegalArgumentException(UNDER_SIZE_ERROR_MESSAGE);
        if (carNamesSize > MAX_SIZE)
            throw new IllegalArgumentException(OVER_SIZE_ERROR_MESSAGE);
        if (carNamesSize != countUniqueNames(names))
            throw new IllegalArgumentException(NOT_UNIQUE_ERROR_MESSAGE);
    }

    private int countUniqueNames(List<String> names) {
        Map<String, Boolean> carNamesMap = new HashMap<>();
        for (String name : names) {
            carNamesMap.put(name, true);
        }
        return carNamesMap.size();
    }

    public List<CarName> getCarNames() {
        return carNames;
    }
}
