package racinggame.controller;

import racinggame.dto.GameTurnCntDTO;
import racinggame.utils.InputParser;
import racinggame.vo.GameTurnCnt;

public class GameTurnCntReader {
    private IOController ioController;
    private InputParser inputParser;

    public GameTurnCntReader(IOController ioController) {
        this.ioController = ioController;

        this.inputParser = new InputParser();
    }

    public GameTurnCnt read() {
        GameTurnCntDTO input = this.ioController.AskGameTurnCnt();
        GameTurnCnt turnCnt = tryGetParsed(input);

        if (!turnCnt.isValid()) {
            turnCnt = repeatReadGameTurnCnt();
        }

        return turnCnt;
    }

    private GameTurnCnt repeatReadGameTurnCnt() {
        GameTurnCnt gameTurnCnt = new GameTurnCnt();

        while (!gameTurnCnt.isValid()) {
            GameTurnCntDTO gameTurnCntInput = this.ioController.ReAskGameTurnCnt();
            gameTurnCnt = tryGetParsed(gameTurnCntInput);
        }

        return gameTurnCnt;
    }

    private GameTurnCnt tryGetParsed(GameTurnCntDTO gameTurnCnt) {
        try {
            return this.inputParser.parse(gameTurnCnt);
        } catch (IllegalArgumentException e) {
            this.ioController.NotifyInvalidGameTurnCnt();
        }

        return new GameTurnCnt();
    }
}
