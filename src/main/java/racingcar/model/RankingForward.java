package racingcar.model;

import racingcar.entity.Cars;
import racingcar.view.OutputResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class RankingForward {
    public static void setCarsRanking(Cars cars) {
        int maxMoveCount = Collections.max(cars.getCarMap().values());

        List<String> champion = new ArrayList<>();
        for (Map.Entry<String, Integer> car : cars.getCarMap().entrySet()) {
            setChampion(car, maxMoveCount, champion);
        }
        OutputResult.printChampion(String.join(", ", champion));
    }

    private static void setChampion(Map.Entry<String, Integer> car, int maxMoveCount, List<String> champion) {
        if (car.getValue() == maxMoveCount) {
            champion.add(car.getKey());
        }
    }
}
