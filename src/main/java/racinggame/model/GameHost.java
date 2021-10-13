package racinggame.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;

public class GameHost {

    ArrayList<Car> recordingRaceList ;

    public GameHost(ArrayList<Car> carList, int roundCnt) {
        Racing.racingByRound(carList, roundCnt);
        this.recordingRaceList = Racing.recordingRaceList;
    }

}