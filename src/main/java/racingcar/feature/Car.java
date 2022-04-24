package racingcar.feature;

public class Car {
    private final CarName carName;
    private final Score score;

    public Car(CarName carName) {
        this.carName = carName;
        this.score = new Score();
    }

    public void action() {
        score.stopOrAdvance();
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getScoreCount() {
        return score.getScoreCount();
    }

    public void printStatus() {
        System.out.println(carName.getCarName() + " : " + score.getScore());
    }

    public boolean isScore(int score) {
        return getScoreCount() == score;
    }
}
