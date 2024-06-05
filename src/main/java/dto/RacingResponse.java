package dto;

import java.util.List;
import java.util.Map;

public class RacingResponse {

    List<Map<String, List<Integer>>> raceResult;
    List<String> winner;

    public List<Map<String, List<Integer>>> getRaceResult() {
        return raceResult;
    }

    public void setRaceResult(List<Map<String, List<Integer>>> raceResult) {
        this.raceResult = raceResult;
    }

    public List<String> getWinner() {
        return winner;
    }

    public void setWinner(List<String> winner) {
        this.winner = winner;
    }

    protected RacingResponse(List<Map<String, List<Integer>>> raceResult, List<String> winner) {
        this.raceResult = raceResult;
        this.winner = winner;
    }

    public static RacingResponse of(List<Map<String, List<Integer>>> raceResult, List<String> winner) {
        return new RacingResponse(raceResult, winner);
    }
}
