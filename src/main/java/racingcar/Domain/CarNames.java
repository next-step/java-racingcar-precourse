package racingcar.Domain;

import java.util.ArrayList;
import java.util.List;
import org.junit.platform.commons.util.StringUtils;

public class CarNames {
    private static final String WRONG_CART_NAME_EMPTY = "자동차 이름은 공백이 아니여야 합니다.";
    private static final String WRONG_CART_NAME_OVER = "자동차 이름은 5자 이하만 가능하다.";
    private static final String SEPARATION = ",";
    private static final int NAME_OVER_LENGTH = 5;
    private final List<String> carNameList;

    public CarNames(String inputCarNames) {
        validationEmpty(inputCarNames);
        this.carNameList = conversionToList(inputCarNames);
    }

    private List<String> conversionToList(String inputCarNames) {
        List<String> nameList = new ArrayList<>();
        for (String carName : inputCarNames.split(SEPARATION)) {
            validationName(carName);
            nameList.add(carName);
        }
        return nameList;
    }

    private void validationName(String name) {
        if (name.length() > NAME_OVER_LENGTH) {
            throw new IllegalArgumentException(WRONG_CART_NAME_OVER);
        }
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(WRONG_CART_NAME_EMPTY);
        }
    }

    private void validationEmpty(String inputCarNames) {
        if (StringUtils.isBlank(inputCarNames)) {
            throw new IllegalArgumentException(WRONG_CART_NAME_EMPTY);
        }
    }

    public List<String> getCarNameList() {
        return carNameList;
    }
}
