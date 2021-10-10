package racinggame.domain;

import java.util.List;

public class RaceFinishResult {

    private final List<RaceRound> raceRounds;

    public RaceFinishResult(List<RaceRound> raceRounds) {
        this.raceRounds = raceRounds;
    }

    public List<RaceRound> getRaceRounds() {
        return raceRounds;
    }

    public String getRaceWinners() {
        RaceRound round = getLastRaceRound();
        return round.getRaceRoundWinners();
    }

    private RaceRound getLastRaceRound() {
        return raceRounds.get(raceRounds.size() - 1);
    }

}
