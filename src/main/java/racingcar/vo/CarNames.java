package racingcar.vo;

import java.util.LinkedList;
import java.util.List;

public class CarNames {
    private List<CarName> carNames;

    public CarNames(String input) {
        this.carNames = new LinkedList<>();
        for (String carName : input.split(",")) {
            carNames.add(new CarName(carName));
        }
    }

    public List<CarName> getCarNames() {
        return this.carNames;
    }
}
