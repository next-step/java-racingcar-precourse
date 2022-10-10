package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.exception.IllegalArgumentException;

public class CarNames {
    private final ArrayList<CarName> carNames;
    public static final String SEPARATOR = ",";

    public CarNames(String names) throws IllegalArgumentException {
        carNames = new ArrayList<>();
        List<String> nameList = new ArrayList<>(Arrays.asList(names.split(SEPARATOR)));

        for (String name : nameList ) {
            carNames.add(new CarName(name));
        }
    }

    public ArrayList<CarName> getCarNames() {
        return carNames;
    }

}
