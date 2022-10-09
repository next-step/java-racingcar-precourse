package racingcar.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Minwoo Kim
 * @date 2022/10/09
 */
public class ScoreBoard {

    private final List<RacingCar> racingCarStats = new ArrayList<>();

    public List<RacingCar> getRacingCarStats() {
        return racingCarStats;
    }

    public List<String> findWinners() {
        Map<Integer, List<String>> map = new HashMap<>();
        int max = 0;
        for (RacingCar racingCar : racingCarStats) {
            if (racingCar.getPosition() >= max) {
                max = racingCar.getPosition();
                map.putIfAbsent(max, new ArrayList<>());
                map.get(max).add(racingCar.getName());
            }
        }
        return map.get(max);
    }

    public void addNewRacingCars(List<String> carNames) {
        for (String carName : carNames) {
            racingCarStats.add(new RacingCar(carName));
        }
    }

    public void moveAllCars() {
        for (RacingCar car : racingCarStats) {
            car.moveOrNot();
        }
    }
}
