package racingcar.model;

import racingcar.constant.Symbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiter {

    public static List<CarName> separateCarName(String inputNames) {
        List<String> names = Arrays.asList(inputNames.split(Symbol.DELIMITER.getValue()));
        List<CarName> carNames = new ArrayList<CarName>();
        for(String name : names) {
            carNames.add(new CarName(name));
        }

        return carNames;
    }

}
