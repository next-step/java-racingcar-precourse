package racingcar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.domain.TryCount;
import racingcar.dto.MoveResult;
import racingcar.dto.RaceResult;

public class Race {

    private TryCount tryCount;

    private List<String> names;

    private final Cars cars;

    public Race(Integer tryCount, List<String> names, MoveStrategy moveStrategy) {
        this.tryCount = new TryCount(tryCount);
        this.names = names;
        this.cars = new Cars(names, moveStrategy);
    }

    public RaceResult start() {
        List<MoveResult> moveLogs = new ArrayList<>();
        while (!this.tryCount.isComplete()) {
            MoveResult moveResult = cars.move();
            moveLogs.add(moveResult);
            this.tryCount = tryCount.getNextTryCount();
        }
        List<String> winners = findWinner(moveLogs);

        return new RaceResult(winners, moveLogs);
    }

    private List<String> findWinner(List<MoveResult> moveLogs) {
        List<Integer> moveCounts = new ArrayList<>();

        for (String name : names) {
            moveCounts.add(0);
        }

        int max = 0;
        for (MoveResult moveResult : moveLogs) {
            for (int i = 0; i < moveCounts.size(); i++) {
                Boolean isMoved = moveResult.getMoveLog().get(i);
                Integer currentCount = moveCounts.get(i);
                if (isMoved) {
                    moveCounts.set(i, currentCount + 1);
                    max = Math.max(max, currentCount + 1);
                }
            }
        }

        List<String> winners = new ArrayList<>();
        for (int i = 0; i < moveCounts.size(); i++) {
            if (moveCounts.get(i) == max) {
                winners.add(names.get(i));
            }
        }

        return winners;
    }

}
