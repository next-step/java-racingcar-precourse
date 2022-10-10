package racingcar.models;

import java.util.HashMap;
import java.util.Set;

public class RacingScore {
    HashMap<Car, Integer> scores = new HashMap<>();

    public void addScore(Car car, int score) {
        this.scores.put(car, score);
    }

    public HashMap<Car, Integer> getScores() {
        return scores;
    }

    public int size() {
        return this.getScores().size();
    }

    public Set<Car> getCars() {
        return this.getScores().keySet();
    }
    public int getScoreOf(Car car) {
        return this.getScores().get(car);
    }

    private void mergeHashMap(HashMap<Car, Integer> map1, HashMap<Car, Integer> map2) {
        map2.forEach((key, value) -> map1.merge(key, value, Integer::sum));
    }

    public void merge(RacingScore...racingScores) {
        for (RacingScore racingScore : racingScores) {
            this.mergeHashMap(this.getScores(), racingScore.getScores());
        }
    }
}
