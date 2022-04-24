package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiter {
    private static final String DELIMITER = ",";

    private Delimiter() {
    }

    public static List<CarName> separateCarNames(String inputNames) {
        List<String> names = Arrays.asList(inputNames.split(DELIMITER));
        List<CarName> carNames = new ArrayList<>();
        for (String name : names) {
            carNames.add(new CarName(name));
        }

        return carNames;
    }

    public static String getDELIMITER() {
        return DELIMITER;
    }
}
