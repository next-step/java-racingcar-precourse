package model;

import java.util.ArrayList;
import java.util.List;

import static util.RandomUtil.getRandom;

public class Race {
    private static final int GO_CONDITION = 4;
    private static final String NEW_LINE = "\n";
    private static final String JOIN_KEYWORD = ", ";

    private List<Car> cars;
    private int maxScore;

    public Race(List<Car> cars) {
        this.cars = cars;
        this.maxScore = 0;
    }

    private void setMaxScore(int score) {
        if (score > maxScore) {
            this.maxScore = score;
        }
    }

    public void play() {
        for (Car car : cars) {
            if (getRandom() >= GO_CONDITION) {
                car.go();
            }
            setMaxScore(car.getScore());
        }
    }

    public String getWinner() {
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getScore() == maxScore) {
                winners.add(car.getName());
            }
        }
        return String.join(JOIN_KEYWORD, winners);
    }

    @Override
    public String toString() {
        StringBuilder status = new StringBuilder();

        for (Car car : this.cars) {
            status.append(car.toString()).append(NEW_LINE);
        }

        return status.toString();
    }
}
