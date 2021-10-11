package racinggame.utils;

import racinggame.environments.GlobalVariables;

public class InputValidator {
    public void validatePlayerNames(String[] playerNames) {
        if (playerNames.length == 0) {
            throw new IllegalArgumentException();
        }

        for (String playerName : playerNames) {
            validatePlayerName(playerName);
        }
    }

    private void validatePlayerName(String playerName) {
        if (playerName.length() < GlobalVariables.MIN_PLAYER_NAME_LENGTH || playerName.length() > GlobalVariables.MAX_PLAYER_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void validateGameTurnCnt(int gameTurnCnt) {
        if (gameTurnCnt < GlobalVariables.MIN_GAME_TURN_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
