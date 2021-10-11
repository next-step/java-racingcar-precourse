package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class RaceResults {
    private List<RaceResult> raceResults;

    public RaceResults(List<RacingCar> racingCars) {
        this.raceResults = initRaceResult(racingCars);
    }

    private static List<RaceResult> initRaceResult(List<RacingCar> racingCars) {
        List<RaceResult> results = new ArrayList<>();
        for (RacingCar racingCar : racingCars) {
            results.add(new RaceResult(racingCar));
        }
        return results;
    }

    public int calculateLeadDistance() {
        int maxDistance = Integer.MIN_VALUE;
        for (RaceResult raceResult : raceResults) {
            maxDistance = Math.max(maxDistance, raceResult.getDistance());
        }
        return maxDistance;
    }

    public List<RaceResult> getRaceResults() {
        return raceResults;
    }
}
