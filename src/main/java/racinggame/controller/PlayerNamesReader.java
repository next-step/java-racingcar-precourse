package racinggame.controller;

import racinggame.dto.PlayerNamesDTO;
import racinggame.utils.InputParser;
import racinggame.vo.PlayerNames;

public class PlayerNamesReader {
    private IOController ioController;
    private InputParser inputParser;

    public PlayerNamesReader(IOController ioController) {
        this.ioController = ioController;

        this.inputParser = new InputParser();
    }

    public PlayerNames read() {
        PlayerNamesDTO input = this.ioController.AskPlayerNames();
        PlayerNames playerNames = tryGetParsed(input);

        if (playerNames == null) {
            playerNames = repeatReadPlayerNames();
        }

        return playerNames;
    }

    private PlayerNames repeatReadPlayerNames() {
        PlayerNames playerNames = null;

        while (playerNames == null) {
            PlayerNamesDTO input = this.ioController.ReAskPlayerNames();
            playerNames = tryGetParsed(input);
        }

        return playerNames;
    }

    private PlayerNames tryGetParsed(PlayerNamesDTO input) {
        try {
            return this.inputParser.parse(input);
        } catch (IllegalArgumentException e) {
            this.ioController.NotifyInvalidPlayerNames();
        }

        return null;
    }
}
