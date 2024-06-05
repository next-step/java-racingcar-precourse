package dto;

import java.util.List;
import java.util.Map;

public class RacingResponse {

    Map<String, List<Integer>> raceResult;
    List<String> winner;

    public Map<String, List<Integer>> getRaceResult() {
        return raceResult;
    }

    public void setRaceResult(Map<String, List<Integer>> raceResult) {
        this.raceResult = raceResult;
    }

    public List<String> getWinner() {
        return winner;
    }

    public void setWinner(List<String> winner) {
        this.winner = winner;
    }

    protected RacingResponse(Map<String, List<Integer>> raceResult, List<String> winner) {
        this.raceResult = raceResult;
        this.winner = winner;
    }

    public static RacingResponse of(Map<String, List<Integer>> raceResult, List<String> winner) {
        return new RacingResponse(raceResult, winner);
    }
}
