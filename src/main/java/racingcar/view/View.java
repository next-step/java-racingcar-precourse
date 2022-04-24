package racingcar.view;

import racingcar.domain.MoveResult;
import racingcar.domain.Victors;

public interface View {
    String requestInputCarNames();

    int requestInputRacingCount();

    void outputMoveResult(MoveResult moveResult);

    void outputVictors(Victors victors);

    void errorMessage(Exception e);

    void outputExecutionResultGuide();
}
