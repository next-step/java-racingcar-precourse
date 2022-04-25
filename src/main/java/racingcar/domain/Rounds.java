package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

import static racingcar.domain.RoundManager.FIRST_ROUND;

public class Rounds {

    private final Map<RoundNumber, Round> rounds;

    public Rounds(int totalRound) {
        this.rounds = mapRounds(totalRound);
    }

    private Map<RoundNumber, Round> mapRounds(int totalRound) {
        Map<RoundNumber, Round> rounds = new HashMap<>();
        for (int i = FIRST_ROUND; i <= totalRound; i++) {
            rounds.put(new RoundNumber(i), new Round());
        }
        return rounds;
    }

    public Round getRound(RoundNumber roundNumber) {
        return rounds.get(roundNumber);
    }
}
