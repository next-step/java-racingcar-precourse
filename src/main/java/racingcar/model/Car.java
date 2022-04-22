package racingcar.model;

public class Car {
    public static final int MIN_MOVE_NUMBER = 0;
    public static final int MAX_MOVE_NUMBER = 9;
    private final int STANDARD_NUMBER = 4;

    private final Name name;
    private final Score score;

    public Car(String name) {
        this.name = new Name(name);
        this.score = new Score();
    }

    public Car(String name, int score) {
        this.name = new Name(name);
        this.score = new Score(score);
    }

    public void moveCar(int randomNumber){
        if(randomNumber >= STANDARD_NUMBER){
            this.score.addScore();
            this.score.maxScoreCompare();
        }
    }

    public boolean isWinner() {
        return this.score.isMaxScore();
    }

    public String getName() {
        return this.name.getName();
    }

    public String getMoveMark() {
        return this.score.getMark();
    }
}
