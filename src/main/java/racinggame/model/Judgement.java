package racinggame.model;

import java.util.ArrayList;

public class Judgement {

    String[] winnter;
    int highScore;

    public static ArrayList<Car> judgeCarList = new ArrayList<Car>();

    public static void configurateJudgeCarList(ArrayList<Car> givenList, int roundCnt) {
        for(int i = givenList.size() - givenList.size() / roundCnt; i < givenList.size(); i++) {
            judgeCarList.add(givenList.get(i));
        }
    }

}
