package domain;

import java.util.ArrayList;
import java.util.List;

public class CarsGenerator {
    private static final String CAR_NAME_SEPERATOR = ",";

    public static Cars generate(String carNames) {
        return generate(carNames.split(CAR_NAME_SEPERATOR));
    }

    public static Cars generate(String[] carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        return new Cars(carList);
    }
}
