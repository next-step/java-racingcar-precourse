package racingcar.domain.creator;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarList;

import java.util.Arrays;

public class RacingCarListCreator {

    public static RacingCarList create(int minPosition, int maxPosition) {
        RacingCar pobi = RacingCarCreator.create("pobi", minPosition);
        RacingCar sun = RacingCarCreator.create("sun", minPosition);
        RacingCar jo = RacingCarCreator.create("jo", maxPosition);
        return RacingCarList.testInstance(Arrays.asList(pobi, sun, jo));
    }

}
