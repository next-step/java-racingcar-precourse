package racingcar;

import java.util.Arrays;
import java.util.List;

public class Cars {

    public static List<String> carNamesToList(String carNames) {
        return Arrays.asList(carNames.split(","));
    }

}
