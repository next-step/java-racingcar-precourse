package racingcar.controller;

import static racingcar.BaseConstants.PRINT_MSG_INPUT_RACING_MOVING_NUMBER;
import static racingcar.BaseConstants.PRINT_MSG_INPUT_RACING_PLAYERS;

import racingcar.domain.RacingMovingRound;
import racingcar.domain.RacingPlayers;

/**
 * @author jinyoung
 * @since 2022/04/23
 */
public class RacingGame {

    public void start() {
        final RacingPlayers racingPlayers = getRacingPlayers();
        final RacingMovingRound racingMovingNumber = getRacingMovingNumber();
        racingPlayers.play(racingMovingNumber);
    }

    private RacingMovingRound getRacingMovingNumber() {
        System.out.println(PRINT_MSG_INPUT_RACING_MOVING_NUMBER);
        return RacingMovingRound.getRacingMovingRound();
    }

    private RacingPlayers getRacingPlayers() {
        System.out.println(PRINT_MSG_INPUT_RACING_PLAYERS);
        return RacingPlayers.getRacingPlayersFromUserConsoleInput();
    }
}
