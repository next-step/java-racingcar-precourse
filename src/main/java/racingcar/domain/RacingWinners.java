package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jinyoung
 * @since 2022/04/23
 */
public class RacingWinners {

    private final List<RacingPlayer> racingWinners;
    private int maxMovingForwardCount;

    private RacingWinners(List<RacingPlayer> racingWinners) {
        this.racingWinners = racingWinners;
        this.maxMovingForwardCount = 0;
    }

    public List<RacingPlayer> getRacingWinners() {
        return racingWinners;
    }

    public static RacingWinners getRacingWinners(RacingPlayers racingPlayers) {
        final RacingWinners racingWinners = new RacingWinners(new ArrayList<>());
        for (RacingPlayer racingPlayer : racingPlayers.getRacingPlayers()) {
            racingWinners.determineThePlayerIsWinner(racingPlayer);
        }
        return racingWinners;
    }

    private void determineThePlayerIsWinner(RacingPlayer racingPlayer) {
        if (racingPlayer.getMovingForwardCount() == this.maxMovingForwardCount) {
            this.getRacingWinners().add(racingPlayer);
        }

        if (racingPlayer.getMovingForwardCount() > this.maxMovingForwardCount) {
            this.getRacingWinners().clear();
            this.getRacingWinners().add(racingPlayer);
            this.maxMovingForwardCount = racingPlayer.getMovingForwardCount();
        }
    }
}
