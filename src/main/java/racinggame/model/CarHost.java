package racinggame.model;

import java.util.ArrayList;

public class CarHost {

    Racing racing;
    Judgement judgement;
    //ArrayList<Car> racingRecord = racing.getRacingRecord();
    String[] winner = judgement.getWinnerList();

    public CarHost(ArrayList<Car> carList) {
        //new Racing(carList);
        //new Judgement(racingRecord);
    }

}