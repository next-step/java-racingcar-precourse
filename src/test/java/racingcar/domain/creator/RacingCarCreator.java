package racingcar.domain.creator;

import racingcar.domain.RacingCar;

public class RacingCarCreator {

    public static RacingCar create(String name, int position) {
        return RacingCar.testInstance(name, position);
    }

}
