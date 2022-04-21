package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarNames {

    public static final String REGEX = ",";
    public static final String MESSAGE_ERROR_EMPTY_NAMES = "[ERROR] 하나 이상의 자동차 이름을 입력해주세요.";
    public static final String MESSAGE_ERROR_DUPLICATE_NAME = "[ERROR] 중복된 이름이 존재합니다.";
    List<CarName> carNames;

    public CarNames(String names) {
        checkEmpty(names);

        carNames = new ArrayList<>();
        for (String name : names.split(REGEX)) {
            checkDuplicate(names, name);
            this.carNames.add(new CarName(name));
        }
    }

    private void checkEmpty(String names) {
        if (names.trim().isEmpty()) {
            throw new IllegalArgumentException(MESSAGE_ERROR_EMPTY_NAMES);
        }
    }

    private void checkDuplicate(String names, String name) {
        if (Collections.frequency(Arrays.asList(names.split(REGEX)), name) > 1) {
            throw new IllegalArgumentException(MESSAGE_ERROR_DUPLICATE_NAME);
        }
    }

    public List<CarName> getCarNames() {
        return carNames;
    }
}
