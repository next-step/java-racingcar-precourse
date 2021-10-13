package racinggame.model;

import nextstep.utils.Randoms;

import java.util.ArrayList;

public class GameHost {

    ArrayList<Car> recordingRaceList;

    public GameHost(ArrayList<Car> carList, int roundCnt) {
        Racing.racingByRound(carList, roundCnt);
        this.recordingRaceList = Racing.recordingRaceList;
        Judgement.configurateJudgeCarList(this.recordingRaceList, roundCnt);
        ArrayList<Car> judgeList = Judgement.judgeCarList;

        ArrayList<String> winnerList = Judgement.findWinnerName(judgeList);

        System.out.println(" :: 우승자 :: ");
        System.out.println(winnerList);


    }

    public ArrayList<Car> getRecordingRaceList() {
        return recordingRaceList;
    }
}