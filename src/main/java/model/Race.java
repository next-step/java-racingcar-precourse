package model;

import java.util.List;

import static util.RandomUtil.getRandom;

public class Race {
    private List<Car> cars;
    private int maxScore;

    public Race(List<Car> cars) {
        this.cars = cars;
        this.maxScore = 0;
    }

    private void setMaxScore(int score){
        if(score > maxScore){
            this.maxScore = score;
        }
    }

    public void play() {
        for (Car car : cars) {
            if (getRandom() > 3) {
                car.go();
            }
            setMaxScore(car.getScore());
        }
    }

    @Override
    public String toString() {
        StringBuilder status = new StringBuilder();

        for (Car car : this.cars) {
            status.append(car.toString()).append("\n");
        }

        return status.toString();
    }
}
