package be.kooru;

public class Car {

    //모든 원시값과 문자열을 포장한다.
    // Car에 관련한 Validation 로직은 Car Domain에서 책임지고 관리하는게 맞다고 판단.
    public static final int CAR_NAME_MAX_SIZE = 5;

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

    protected void addScore(int score) {
        this.score += score;
    }

    private void validateCarName(String name) {
        if (name.length() > CAR_NAME_MAX_SIZE)
            throw new IllegalArgumentException("Over Car Name Length");

    }
}
