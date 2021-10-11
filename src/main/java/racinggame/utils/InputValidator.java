package racinggame.utils;

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
        if (playerName.length() < 1 || playerName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public void validateGameTurnCnt(int gameTurnCnt) {
        if (gameTurnCnt <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
