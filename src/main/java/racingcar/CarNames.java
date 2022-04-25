package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    private static final String NO_INPUT_STRING = "[ERROR] 문자열이 입력되지 않았습니다.";

    List<CarName> names;

    public CarNames() {
        names = new ArrayList<>();
    }

    public static CarNames create(String inputCarNames) throws IllegalArgumentException {
        validateCarNames(inputCarNames);
        CarNames names = new CarNames();
        for(String carName : inputCarNames.split(",")) {
            names.add(carName);
        }
        return names;
    }

    private void add(String carName) {
        names.add(new CarName(carName));
    }

    private static void validateCarNames(String carNames) {
        if(carNames.isEmpty()) {
            throw new IllegalArgumentException(NO_INPUT_STRING);
        }
    }


    public List<CarName> getList() {
        return names;
    }
}
