package racingcar.vo;

import camp.nextstep.edu.missionutils.Randoms;

public class Speed {

    public Integer getForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return 1;
        }
        return 0;
    }
}