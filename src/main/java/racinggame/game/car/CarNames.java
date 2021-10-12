package racinggame.game.car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarNames {
    private static final String CAR_NAME_DELIMITER = ",";

    private final List<CarName> carNames;


    public CarNames(String inputValue) {
        this.carNames = new ArrayList<>();
        this.carNames.addAll(makeCarNames(inputValue));
    }

    public boolean isValid() {
        if(this.carNames.isEmpty()) {
            return false;
        }
        int invalidNameCount = getInvalidNameCount(this.carNames);
        return invalidNameCount <= 0;
    }

    public List<CarName> getCarNames() {
        return carNames;
    }


    private int getInvalidNameCount(List<CarName> carNames) {
        int invalidCount = 0;
        for(CarName carName: carNames) {
            invalidCount = plusIfInvalid(invalidCount, carName);
        }
        return invalidCount;
    }

    private int plusIfInvalid(int invalidCount, CarName carName) {
        if(!carName.isValid()) {
            return invalidCount + 1;
        }
        return invalidCount;
    }

    private List<CarName> makeCarNames(String inputValue) {
        List<CarName> carNames = new ArrayList<>();

        if(!inputValue.contains(CAR_NAME_DELIMITER)) {
            carNames.add(new CarName(inputValue));
            return carNames;
        }

        String[] splitValue = inputValue.split(CAR_NAME_DELIMITER);
        for (String name : splitValue) {
            carNames.add(new CarName(name));
        }
        return carNames;
    }


}
