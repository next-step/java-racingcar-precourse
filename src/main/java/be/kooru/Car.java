package be.kooru;

public class Car {

    //모든 원시값과 문자열을 포장한다.
    private static final int CAR_NAME_MAX_SIZE = 5;
    private static final int CAR_ONE_STEP_STANDARD = 4;

    String name;
    int score;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int number) {
        this.score += scoreCalculator(number);
    }

    protected void validateCarName(String name) {
        if (name.length() > CAR_NAME_MAX_SIZE)
            throw new IllegalArgumentException("Over Car Name Length");

    }

    protected int scoreCalculator(int value) {
        return value >= CAR_ONE_STEP_STANDARD ? 1 : 0;
    }

}
