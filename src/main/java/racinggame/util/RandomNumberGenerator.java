package racinggame.util;

import nextstep.utils.Randoms;
import racinggame.code.CarConfig;

public class RandomNumberGenerator {

    public static int generate() {
        return Randoms.pickNumberInRange(
                CarConfig.NumberRangeStart.getValue(),
                CarConfig.NumberRangeEnd.getValue()
        );
    }
}
