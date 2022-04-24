package racingcar.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.constants.ErrorMessage;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

public class RacingCarFactory {

    public static RacingCars makeCars(final String input) {
        final List<RacingCar> racingCars = new ArrayList<>();
        final String[] carNames = input.split(",");
        validateCarNames(carNames);
        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
        return new RacingCars(racingCars);
    }

    private static void validateCarNames(final String[] carNames) {
        final Set<String> carNamesSet = new HashSet<>();
        for (final String carName : carNames) {
            checkCarNameAlreadySet(carNamesSet, carName);
            carNamesSet.add(carName);
        }
    }

    private static void checkCarNameAlreadySet(final Set<String> carNamesSet, final String carName) {
        if(carNamesSet.contains(carName)){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_IS_DUPLICATE);
        }
    }

}
