package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.Constants;

public class GameRoundRandomNumberGanerator {
    public int generateRacingCarGameRoundNumber() {
        return Randoms.pickNumberInRange(Constants.RACING_CAR_GAMME_ROUND_RANGE_MIN_NUM, Constants.RACING_CAR_GAMME_ROUND_RANGE_MAX_NUM);
    }
}
