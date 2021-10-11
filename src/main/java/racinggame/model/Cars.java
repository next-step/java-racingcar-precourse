package racinggame.model;

import java.util.ArrayList;

import static racinggame.common.Constant.*;
import static racinggame.common.ValidationUtils.*;

public class Cars {
    private static ArrayList<Car> cars;

    public Cars() {
    }

    public Cars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public static ArrayList<Car> getCars() {
        return cars;
    }

    public static void setCars(ArrayList<Car> cars) {
        Cars.cars = cars;
    }

    public static ArrayList<Car> makeCarsByInputName(String inputNames) {
        ArrayList<Car> cars = new ArrayList<Car>();
        String[] carNames = inputNames.split(NAME_REGEX);
        for(String name : carNames) {
            if(!validName(name)) {
                throw new IllegalArgumentException(ERROR_PREFIX + ERR_CAR_NAME_LEN);
            }
            cars.add(new Car(name, 0));
        }
        return cars;
    }
}
