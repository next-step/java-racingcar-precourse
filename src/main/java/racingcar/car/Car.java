package racingcar.car;

public class Car {
    public static final int SCORE_MIN = 0;
    public static final int SCORE_MAX = 9;
    public static final int GO_MIN_SCORE = 4;
    public static final int NAME_LENGTH_MAX = 5;
    public static final String ERROR_SCORE_UNDERFLOW = "[ERROR] 너무 작은 값입니다. %d";
    public static final String ERROR_SCORE_OVERFLOW = "[ERROR] 너무 큰 값입니다. %d";
    public static final String ERROR_INPUT_EMPTY = "[ERROR] 입력이 비어있습니다.";
    public static final String ERROR_INPUT_TOO_LONG_NAME = "[ERROR] 이름이 너무 깁니다. %s";

    String name;
    int move;

    public Car(String name){
        validateNameLength(name);
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

    public static void validateNameLength(String carName){
        if (carName.isEmpty()){
            throw new IllegalArgumentException(ERROR_INPUT_EMPTY);
        }

        if (carName.length() > Car.NAME_LENGTH_MAX){
            throw new IllegalArgumentException(String.format(ERROR_INPUT_TOO_LONG_NAME, carName));
        }
    }
}
