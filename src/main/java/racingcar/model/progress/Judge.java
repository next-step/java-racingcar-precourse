package racingcar.model.progress;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.cars.factory.MoveEvent;
import racingcar.model.cars.factory.MoveHistory;

public class Judge {
    public static final MoveScore GO_SCORE = MoveScore.of(1);
    public static final MoveScore STOP_SCORE = MoveScore.of(0);
    private final MinGoScoreInclusive minGoScoreInclusive;

    public Judge(MinGoScoreInclusive minGoScoreInclusive) {
        this.minGoScoreInclusive = minGoScoreInclusive;
    }

    public MoveScores call(MoveHistory moveHistory) {
        return MoveScores.of(this.getMoveScoreList(moveHistory));
    }

    public MoveScore call(MoveEvent moveEvent) {
        return this.judgeEvent(moveEvent);
    }

    public MinGoScoreInclusive getMinGoScoreInclusive() {
        return minGoScoreInclusive;
    }

    private List<MoveScore> getMoveScoreList(MoveHistory moveHistory) {
        List<MoveScore> moveScores = new ArrayList<>();
        for (MoveEvent moveEvent : moveHistory.get()) {
            moveScores.add(this.call(moveEvent));
        }
        return moveScores;
    }

    private MoveScore judgeEvent(MoveEvent event) {
        if (minGoScoreInclusive.isGo(event)) {
            return Judge.GO_SCORE;
        }
        return Judge.STOP_SCORE;
    }
}
