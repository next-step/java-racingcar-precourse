package racingcar.model.car.generator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.car.name.CarNames;
import racingcar.model.car.RacingCar;
import racingcar.model.car.RacingCars;
import racingcar.view.Display;

public class RacingCarsGenerator {

    public static RacingCars generate() {
        RacingCars racingCars = null;
        while (racingCars == null) {
            racingCars = createRacingCars();
        }

        return racingCars;
    }

    private static RacingCars createRacingCars() {
        RacingCars racingCars = null;

        try {
            racingCars = enterRacingCars(lineUp());
        } catch (IllegalArgumentException e) {
            Display.printExceptionMessage(e);
        }

        return racingCars;
    }

    private static CarNames lineUp() {
        Display.printLineUpMessage();
        return new CarNames(Console.readLine());
    }

    private static RacingCars enterRacingCars(CarNames carNames) {
        List<RacingCar> racingCarList = new ArrayList<>();
        while (carNames.hasNext()) {
            racingCarList.add(racingCar(carNames));
        }

        return new RacingCars(racingCarList);
    }

    private static RacingCar racingCar(CarNames carNames) {
        return new RacingCar(carNames.next());
    }
}
