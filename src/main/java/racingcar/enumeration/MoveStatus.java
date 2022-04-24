package racingcar.enumeration;

import racingcar.exception.StaticRacingException;
import racingcar.view.OutputView;

public enum MoveStatus {
    STOP(0, 4),
    MOVING_FORWARD(4, 10);

    private final int startBoundary;
    private final int endBoundary;

    MoveStatus(int lowerBoundary, int upperBoundary) {
        this.startBoundary = lowerBoundary;
        this.endBoundary = upperBoundary;
    }

    public static boolean isMoved(final long randomNumber) {
        return getValidStatus(randomNumber) == MOVING_FORWARD;
    }

    private static MoveStatus getValidStatus(final long move) {
        if (STOP.isInBoundary(move)) {
            return STOP;
        }

        if (MOVING_FORWARD.isInBoundary(move)) {
            return MOVING_FORWARD;
        }

        OutputView.printErrorMessage(StaticRacingException.INVALID_MOVE_RANGE_EXCEPTION.getMessage());
        throw StaticRacingException.INVALID_MOVE_RANGE_EXCEPTION;
    }

    private boolean isInBoundary(final long move) {
        return move >= startBoundary && move < endBoundary;
    }

}
