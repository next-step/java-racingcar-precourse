package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    public static final String NAME_SPLITTER = ",";

    private final List<CarName> names;

    public CarNames(List<CarName> names) {
        this.names = names;
    }

    public CarNames(String names) {
        List<CarName> carNames = new ArrayList<>();
        for (String name : toArray(names)) {
            carNames.add(new CarName(name));
        }
        this.names = carNames;
    }

    public List<CarName> getNames() {
        return names;
    }

    private String[] toArray(String names) {
        return names.split(NAME_SPLITTER);
    }
}
