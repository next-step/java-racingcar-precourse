package racingcar;

import utils.ValidationUtils;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static List<String> carNamesToList(String carNames) {
        List<String> carList = new ArrayList<>();
        for (String carName : carNames.split(",")) {
            ValidationUtils.validName(carName);
            carList.add(carName);
        }
        return carList;
    }

}
