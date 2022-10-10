package racingcar.model.race;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;
import racingcar.model.value.ErrorMsg;
import racingcar.model.value.Rule;
import racingcar.view.Input;

/**
 * 경기 매니저 객체
 *
 * @author YONGSEOK CHOI
 * @version 1.0 2022.10.09
 */
public class RaceManager {

    public Cars addCars(final String carInput) {
        validateStringInput(carInput);
        return new Cars(carInput);
    }

    public Trial addTrial(final String trialInput) {
        validateStringInput(trialInput);
        return new Trial(trialInput);
    }

    private void validateStringInput(final String carInput) {
        if (carInput == null || carInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMsg.EMPTY_INPUT);
        }
    }

}
