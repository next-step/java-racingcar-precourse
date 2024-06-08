package util;

import model.BasicCar;
import model.SuperCar;

public class CarFactory {
    public static BasicCar getBasicCar(String carname) {
        return new BasicCar(RacingGameUtil.checkIfCarnameIsValid(carname));
    }

    public static SuperCar getSuperCar(String carname) {
        return new SuperCar(RacingGameUtil.checkIfCarnameIsValid(carname));
    }
}
