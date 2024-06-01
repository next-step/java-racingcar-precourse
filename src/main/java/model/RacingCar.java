package model;

public class RacingCar {

    private int currentScore;
    private int totalScore;
    private final String carName;

    public RacingCar(int currentScore, int totalScore, String carName) {
        this.currentScore = currentScore;
        this.totalScore = totalScore;
        this.carName = carName;
    }


    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getCarName() {
        return carName;
    }
}
