package racinggame.domain;

import static nextstep.utils.Randoms.pickNumberInRange;
import static racinggame.domain.GameConfig.*;

public class RacingCar {
    private final RacingCarName racingCarName;
    private int movesCount;

    public RacingCar(final String racingCarName) {
        this.racingCarName = new RacingCarName(racingCarName);
        this.movesCount = 0;
    }

    public String getRacingCarName() {
        return racingCarName.getRacingCarName();
    }

    public int getMovesCount() {
        return movesCount;
    }

    public void movingForward() {
        this.movesCount += 1;
    }

    public void stop() {
        this.movesCount += 0;
    }

    public void isMovingForward() {
        if (pickNumberInRange(START_INCLUSIVE.getValue(), END_INCLUSIVE.getValue()) >= MOVING_FORWARD.getValue()) {
            movingForward();
        }
    }

    public StringBuilder getHyphenCount() {
        StringBuilder hyphen = new StringBuilder();
        for (int i = 0; i < movesCount; i++) {
            hyphen.append("-");
        }
        return hyphen;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(racingCarName.getRacingCarName())
                .append(" : ")
                .append(getHyphenCount())
                .toString();
    }
}
