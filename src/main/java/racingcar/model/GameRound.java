package racingcar.model;

import racingcar.code.GameRoundErrorCode;

public class GameRound {

    private static final String REGEX = "[0-9]+";

    private static final String ZERO = "0";

    private final int gameRound;

    public GameRound(final String gameRound) {
        roundNull(gameRound);
        roundEmpty(gameRound);
        roundZero(gameRound);
        roundNumber(gameRound);
        this.gameRound = Integer.parseInt(gameRound);
    }

    public int getGameRound() {
        return this.gameRound;
    }

    private void roundNumber(final String round) {
        if (!round.matches(REGEX)) {
            throw new IllegalArgumentException(GameRoundErrorCode.NUMBER.getMessage());
        }
    }

    private void roundNull(final String round) {
        if (isNull(round)) {
            throw new IllegalArgumentException(GameRoundErrorCode.NULL.getMessage());
        }
    }

    private void roundEmpty(final String round) {
        if(round.trim().isEmpty()) {
            throw new IllegalArgumentException(GameRoundErrorCode.EMPTY.getMessage());
        }
    }

    private void roundZero(final String round) {
        if(ZERO.equals(round)) {
            throw new IllegalArgumentException(GameRoundErrorCode.ZERO.getMessage());
        }
    }

    private boolean isNull(final String round) {
        return round == null || "".equals(round);
    }
}
