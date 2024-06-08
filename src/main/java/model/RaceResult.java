package model;

import java.util.List;

public class RaceResult {

    private final List<CarStates> raceResult;

    public RaceResult(List<CarStates> raceResult) {
        this.raceResult = raceResult;
    }

    public List<String> getWinners() {
        CarStates finalCarStates = raceResult.get(raceResult.size() - 1);
        return finalCarStates.getFrontRunnerNames();
    }

    public List<CarStates> getRaceResult() {
        return raceResult;
    }
}
