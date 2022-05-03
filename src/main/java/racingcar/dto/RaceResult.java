package racingcar.dto;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    private List<String> winners;

    private List<MoveResult> moveLogs;

    public RaceResult() {
        this.winners = new ArrayList<>();
        this.moveLogs = new ArrayList<>();
    }

    public RaceResult(List<String> winners, List<MoveResult> moveLogs) {
        this.winners = winners;
        this.moveLogs = moveLogs;
    }

    public List<String> getWinners() {
        return winners;
    }

    public List<MoveResult> getMoveLogs() {
        return moveLogs;
    }

    public void addMoveResult(MoveResult moveResult) {
        this.moveLogs.add(moveResult);
    }

}
