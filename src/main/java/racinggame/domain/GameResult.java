package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    private final List<LapResult> lapResults = new ArrayList<>();

    public void add(LapResult lapResult) {
        lapResults.add(lapResult);
    }

    public List<String> getWinners() {
        LapResult lastLapResult = getLastLapResult();
        List<Record> bestRecords = lastLapResult.getBestRecords();
        return mapNames(bestRecords);
    }

    public List<LapResult> getLapResults() {
        return lapResults;
    }

    private List<String> mapNames(List<Record> bestRecords) {
        List<String> winners = new ArrayList<>();
        for (Record bestRecord : bestRecords) {
            winners.add(bestRecord.getName());
        }
        return winners;
    }

    private LapResult getLastLapResult() {
        return lapResults.get(lapResults.size() - 1);
    }
}
