package racingcar.racing;

import java.util.List;
import java.util.function.Consumer;

public class CumulativeRounds {
    private List<CumulativeRound> cumulativeRounds;

    public CumulativeRounds(final Rounds rounds) {
        validateRounds(rounds);
        this.cumulativeRounds = cumulative(rounds);
    }

    private List<CumulativeRound> cumulative(final Rounds rounds) {
        return rounds.mapToList(round -> new CumulativeRound(round, rounds.cumulativeRoundResults(round)));
    }

    private void validateRounds(final Rounds rounds) {
        if (!rounds.isFinish()) {
            throw new IllegalStateException("[ERROR] 모든 실행이 완료 되지 않았습니다.");
        }
    }

    public void each(final Consumer<CumulativeRound> consumer) {
        for (CumulativeRound cumulativeRound : cumulativeRounds) {
            consumer.accept(cumulativeRound);
        }
    }
}
