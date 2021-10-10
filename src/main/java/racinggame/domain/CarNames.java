package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class CarNames {
    public static final String CAR_NAME_SEPARATORS = ",";

    String carNames;

    public CarNames(String playInput) {
        this.carNames = playInput;
    }

    public List<Name> entryNameList() {
        String[] nameArray = carNames.split(CAR_NAME_SEPARATORS);
        List<Name> names = new ArrayList<>();
        for (String carName : nameArray) {
            names.add(new Name(carName));
        }
        return names;
    }

    public String[] entryCarNameArray() {
        return carNames.split(CAR_NAME_SEPARATORS);
    }
}
