package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.BaseConstants.ERROR_MSG_CAR_NAME_MORE_THAN_5;
import static racingcar.BaseConstants.ERROR_MSG_EMPTY_VALUE;
import static racingcar.BaseConstants.MAX_RANDOM_NUMBER_RANGE_OF_MOVING_FORWARD;
import static racingcar.BaseConstants.MIN_MOVING_FORWARD_NUMBER;
import static racingcar.BaseConstants.MIN_RANDOM_NUMBER_RANGE_OF_MOVING_FORWARD;

/**
 * @author jinyoung
 * @since 2022/04/23
 */
public class RacingPlayer {

    private final String carPlayerName;
    private int movingForwardCount;

    public RacingPlayer(String carPlayerName) {
        if ("".equals(carPlayerName) || carPlayerName == null) {
            throw new IllegalArgumentException(ERROR_MSG_EMPTY_VALUE);
        }

        if (carPlayerName.length() > 5) {
            throw new IllegalArgumentException(ERROR_MSG_CAR_NAME_MORE_THAN_5);
        }

        this.carPlayerName = carPlayerName;
        this.movingForwardCount = 0;
    }

    public String getCarPlayerName() {
        return carPlayerName;
    }

    public int getMovingForwardCount() {
        return movingForwardCount;
    }

    public void tryMovingForward() {
        final int randomNumber = pickNumberInRange(
                MIN_RANDOM_NUMBER_RANGE_OF_MOVING_FORWARD, MAX_RANDOM_NUMBER_RANGE_OF_MOVING_FORWARD
        );
        final boolean hasMovingForward = randomNumber >= MIN_MOVING_FORWARD_NUMBER;
        if (hasMovingForward) {
            this.movingForwardCount += 1;
        }
    }

    public void printCurrentStatus() {
        final StringBuilder movingForwardCountString = new StringBuilder();
        final int movingForwardCount = getMovingForwardCount();
        for (int i = 0; i < movingForwardCount; i++) {
            movingForwardCountString.append("-");
        }
        System.out.println(getCarPlayerName() + " : " + movingForwardCountString);
    }
}
