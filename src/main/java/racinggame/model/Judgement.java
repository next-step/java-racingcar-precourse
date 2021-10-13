package racinggame.model;

import java.util.ArrayList;

public class Judgement {

    static ArrayList<String> winnerList = new ArrayList<String>();

    public static ArrayList<Car> judgeCarList = new ArrayList<Car>();

    public static void configurateJudgeCarList(ArrayList<Car> givenList, int roundCnt) {
        for(int i = givenList.size() - givenList.size() / roundCnt; i < givenList.size(); i++) {
            judgeCarList.add(givenList.get(i));
        }
    }
//  1/2/3
//  3/2/1
    public static int findHighScore(ArrayList<Car> judgeCarList) {
        int highScore = judgeCarList.get(0).confirmNowPosition();
        for (int i = 1; i < judgeCarList.size(); i++) { // 0 1 2
            highScore = findHighScoreAlgorithm(judgeCarList.get(i).confirmNowPosition(), highScore);
        }
        return highScore;
    }

    public static int findHighScoreAlgorithm(int comparisonTarget, int stanDardNumber) {
        if(comparisonTarget >= stanDardNumber) {
            return comparisonTarget;
        } return stanDardNumber;
    }


    public static ArrayList<String> findWinnerName(ArrayList<Car> judgeCarList) {
        int highScore = findHighScore(judgeCarList);
        for(int i = 0; i < judgeCarList.size(); i++) {
            if(judgeCarList.get(i).confirmNowPosition() == highScore ){
                winnerList.add(judgeCarList.get(i).confirmCarName());
            }
        }
        return winnerList;
    }




}
