package racinggame.utils;

import racinggame.dto.GameTurnCntDTO;
import racinggame.dto.PlayerNamesDTO;
import racinggame.vo.GameTurnCnt;
import racinggame.vo.PlayerNames;

public class InputParser {
    private static final String PLAYER_NAME_INPUT_DELIMITER = ",";

    private InputValidator inputValidator;

    public InputParser() {
        this.inputValidator = new InputValidator();
    }

    public PlayerNames parse(PlayerNamesDTO playerNamesInput) {
        try {
            String[] splitedInput = playerNamesInput.get().split(PLAYER_NAME_INPUT_DELIMITER, 0);

            this.inputValidator.validatePlayerNames(splitedInput);

            PlayerNames playerNames = new PlayerNames(splitedInput);

            return playerNames;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public GameTurnCnt parse(GameTurnCntDTO turnCntInput) {
        try {
            int gameTurnCnt = Integer.parseInt(turnCntInput.get());

            this.inputValidator.validateGameTurnCnt(gameTurnCnt);

            return new GameTurnCnt(gameTurnCnt);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
