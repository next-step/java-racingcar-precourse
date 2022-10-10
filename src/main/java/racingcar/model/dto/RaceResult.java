package racingcar.model.dto;

import java.util.ArrayList;
import java.util.List;

public class RaceResult {

    private List<String> winners;

    public RaceResult() {
        winners = new ArrayList<>();
    }

    public List<String> getWinners() {
        return winners;
    }

    public void setWinners(List<String> winners) {
        this.winners = winners;
    }
}
