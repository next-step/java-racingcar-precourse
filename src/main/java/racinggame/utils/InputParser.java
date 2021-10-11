package racinggame.utils;

public class InputParser {
    private static final String PLAYER_NAME_INPUT_DELIMITER = ",";

    private InputValidator inputValidator;

    public InputParser() {
        this.inputValidator = new InputValidator();
    }

    public String[] splitPlayerNames(String playerNamesInput) {
        try {
            String[] playerNames = playerNamesInput.split(PLAYER_NAME_INPUT_DELIMITER, 0);

            this.inputValidator.validatePlayerNames(playerNames);

            return playerNames;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public int parseGameTurnCnt(String turnCntInput) {
        try {
            int gameTurnCnt = Integer.parseInt(turnCntInput);

            this.inputValidator.validateGameTurnCnt(gameTurnCnt);

            return gameTurnCnt;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
