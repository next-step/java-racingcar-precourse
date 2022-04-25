package racingcar.domain;

import static racingcar.BaseConstants.ERROR_MSG_EMPTY_VALUE;
import static racingcar.BaseConstants.ERROR_MSG_PREFIX;
import static racingcar.BaseConstants.PRINT_MSG_FINAL_RESULT_PREFIX;
import static racingcar.BaseConstants.PRINT_MSG_PLAY_RESULT;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jinyoung
 * @since 2022/04/23
 */
public class RacingPlayers {

    private final List<RacingPlayer> racingPlayers;

    protected RacingPlayers(String racingParticipators) {
        if ("".equals(racingParticipators) || racingParticipators == null) {
            throw new IllegalArgumentException(ERROR_MSG_EMPTY_VALUE);
        }
        this.racingPlayers = new ArrayList<>();
        for (String carPlayerName : racingParticipators.split(",")) {
            this.racingPlayers.add(new RacingPlayer(carPlayerName));
        }
    }

    public static RacingPlayers getRacingPlayersFromUserConsoleInput() {
        final String racingParticipators = Console.readLine();
        try {
            return new RacingPlayers(racingParticipators);
        } catch (IllegalArgumentException iae) {
            System.out.println(ERROR_MSG_PREFIX + iae.getMessage());
            return getRacingPlayersFromUserConsoleInput();
        }
    }

    public List<RacingPlayer> getRacingPlayers() {
        return racingPlayers;
    }

    public void play(RacingMovingRound racingMovingRound) {
        System.out.println(PRINT_MSG_PLAY_RESULT);
        for (int round = 0; round < racingMovingRound.movingNumber(); round++) {
            startRound();
        }
        printFinalResult();
    }

    private void printFinalResult() {
        final RacingWinners racingWinners = RacingWinners.getRacingWinners(this);
        final StringBuilder winnerNames = new StringBuilder();
        for (RacingPlayer winner : racingWinners.getRacingWinners()) {
            winnerNames.append(winner.getCarPlayerName()).append(",");
        }
        System.out.println(PRINT_MSG_FINAL_RESULT_PREFIX + winnerNames.deleteCharAt(winnerNames.length() - 1));
    }

    private void startRound() {
        for (RacingPlayer racingPlayer : this.racingPlayers) {
            racingPlayer.tryMovingForward();
            racingPlayer.printCurrentStatus();
        }
        System.out.println();
    }
}
