package game.model;

import java.util.Map;

public class FinalWinner {

    private final String winner;
    private String waitWinner = "";
    private int winnerScore = 0;

    public FinalWinner(Map<String,Integer> cars){
        this.winner = finalWinnerCheck(cars);
    }

    private String finalWinnerCheck(Map<String,Integer> cars){
        for(String carName : cars.keySet()){
            scoreCompare(cars.get(carName),carName);
        }
        return waitWinner;
    }

    private void scoreCompare(int compareScore, String compare ){
        if(compareScore > winnerScore) {
            winnerScore = compareScore;
            waitWinner = compare;
            return;
        }
        if(compareScore == winnerScore) {
            waitWinner = winner+","+compare;
            return;
        }
    }

    public void printWinner() {
        System.out.print("최종 우승자: "+winner);
    }
}
