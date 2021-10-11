package racinggame.car.domain;

import racinggame.Enum.Error;
import racinggame.car.utils.CarsUtil;

public class CarName {
    String name;

    public CarName(String inputName) {
        this.name = CarsUtil.CarName(inputName.trim());
    }

    public String getName() {
        return this.name;
    }
}
