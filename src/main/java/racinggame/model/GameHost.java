package racinggame.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;

public class GameHost {

    ArrayList<Car> carList;
    int roundCnt;

    public GameHost(ArrayList<Car> carList, int roundCnt) {
        this.carList = carList;
        this.roundCnt = roundCnt;
    }

    public ArrayList<Car> recordingRaceList;

    public void recordByRound(int roundCnt) {
        for (int i = 0; i < roundCnt; i++) {
            Racing.racingAllCars(carList);  //-> return : calculated carList
            //add -> update set carList
        }
    }
}