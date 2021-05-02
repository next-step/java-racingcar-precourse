package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {

    public static List<RacingCar> create(String carsName) {

        String[] carName = carsName.split(",");
        List<RacingCar> racingCars = new ArrayList<>();

        for (String s : carName) {
            RacingCar racingCar = new RacingCar(s);
            racingCars.add(racingCar);
        }

        return racingCars;
    };
}
