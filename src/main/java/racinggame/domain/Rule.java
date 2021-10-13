package racinggame.domain;

import nextstep.utils.Randoms;
import racinggame.common.Const;

public class Rule {
    public static boolean isforward() {
        return Randoms.pickNumberInRange(0, 9) >= Const.FORWARD_STANDARD_NUMBER;
    }
}
