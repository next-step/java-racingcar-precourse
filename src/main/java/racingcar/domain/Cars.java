package racingcar.domain;

import racingcar.utils.NumberRule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {

    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public RacingResultsMap race(int tryNumber) {
        Map<Integer, RacingResults> racingResultsMap = new HashMap<>();
        RacingResults racingResults = initializeRacingResult();
        int trialNumber = 0;
        while(trialNumber++ < tryNumber) {
            RacingResults beforeRacingResults = racingResults;
            racingResults = getNextRacingResult(beforeRacingResults);
            racingResultsMap.put(trialNumber, racingResults.copyOf());
        }
        return new RacingResultsMap(racingResultsMap);
    }

    private RacingResults initializeRacingResult() {
        List<RacingResult> racingResults = new ArrayList<>();
        for(Car car : cars)
            racingResults.add(new RacingResult(car.getName(), NumberRule.INITIAL_POSITION.getValue()));
        return new RacingResults(racingResults);
    }

    public RacingResults getNextRacingResult(RacingResults racingResults) {
        for(Car car : cars) {
            RacingResult racingResult = racingResults.getByCarName(car.getName());
            racingResult.forwardPosition(car.isForward());
        }
        return racingResults;
    }

}
