package racingcar.model.progress;

import java.util.List;

public class MoveScores {
    private final List<MoveScore> moveScores;

    private MoveScores(List<MoveScore> moveScores) {
        this.moveScores = moveScores;
    }

    public static MoveScores of(List<MoveScore> moveScores) {
        return new MoveScores(moveScores);
    }

    public MoveScore get() {
        int sum = 0;
        for (MoveScore moveScore : moveScores) {
            sum += moveScore.get();
        }
        return MoveScore.of(sum);
    }
}
