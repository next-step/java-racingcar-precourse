package racingcar.domain.response;

import racingcar.domain.wrap.CurrentRound;

import java.util.List;

/**
 * @author : choi-ys
 * @date : 2022-04-24 오후 1:36
 */
public class RoundResult {
    private CurrentRound currentRound;
    private CarRaceResults carRaceResults;

    private RoundResult(CurrentRound currentRound, CarRaceResults carRaceResults) {
        this.currentRound = currentRound;
        this.carRaceResults = carRaceResults;
    }

    public static RoundResult of(int currentRound, List<CarRaceResult> carRaceResults) {
        return new RoundResult(new CurrentRound(currentRound), new CarRaceResults(carRaceResults));
    }

    public int getCurrentRound() {
        return currentRound.getCurrentRound();
    }

    public List<CarRaceResult> getRaceResults() {
        return carRaceResults.getCarRaceResults();
    }
}
