package racingcar.domain.engine;

import racingcar.domain.car.Distance;
import racingcar.vo.racenumber.RaceNumber;

public class Engine {
    private static final Distance NOT_GO_DISTANCE = Distance.from(0);
    private RaceNumber movableMinRaceNumber;
    private Distance movableDistance;

    public Engine(int movableMinRaceNumber, int movableDistance) {
        this.movableMinRaceNumber = RaceNumber.from(movableMinRaceNumber);
        this.movableDistance = Distance.from(movableDistance);
    }

    public Distance goForward(RaceNumber raceNumber) {
        if (raceNumber.compareTo(movableMinRaceNumber) >= 0) {
            return movableDistance;
        }
        return NOT_GO_DISTANCE;
    }
}
