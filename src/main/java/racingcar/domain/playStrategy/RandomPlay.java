package racingcar.domain.playStrategy;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomPlay implements PlayBehavior {

    private static final int GO_NUM_MIN = 4;

    @Override
    public boolean isGo() {
        return Randoms.pickNumberInRange(0, 9) >= GO_NUM_MIN;
    }

}
