package racingcar.domain.creator;

import racingcar.domain.RacingCar;
import racingcar.domain.WinnerRacingCarList;
import racingcar.domain.creator.RacingCarCreator;

import java.util.Arrays;

public class WinnerRacingCarListCreator {

    public static WinnerRacingCarList create() {
        RacingCar sun = RacingCarCreator.create("sun", 5);
        RacingCar jo = RacingCarCreator.create("jo", 5);
        return WinnerRacingCarList.testInstance(Arrays.asList(sun, jo));
    }

}
