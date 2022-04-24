package racingcar.car;

public class Car {
    public static int SCORE_MIN = 0;
    public static int SCORE_MAX = 9;
    public static int GO_MIN_SCORE = 4;
    public static String ERROR_SCORE_UNDERFLOW = "[ERROR] 너무 작은 값입니다. %d";
    public static String ERROR_SCORE_OVERFLOW = "[ERROR] 너무 큰 값입니다. %d";

    String name;
    int move;

    public Car(String name){
        this.name = name;
    }

    public void inputScore(int score){
        validScoreRange(score);
        if (score >= GO_MIN_SCORE){
            go();
        }
    }
    private void validScoreRange(int score){
        if (score < SCORE_MIN){
            throw new IllegalArgumentException(String.format(ERROR_SCORE_UNDERFLOW, score));
        }
        if (score > SCORE_MAX){
            throw new IllegalArgumentException(String.format(ERROR_SCORE_OVERFLOW, score));
        }
    }

    public void go(){
        this.move += 1;
    }

    public int getMove(){
        return this.move;
    }

    public String getName(){
        return this.name;
    }

}
