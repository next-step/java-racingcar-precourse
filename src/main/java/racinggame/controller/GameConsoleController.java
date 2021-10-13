package racinggame.controller;

import racinggame.environments.GlobalVariables;
import racinggame.model.Cars;
import racinggame.model.RacingGame;
import racinggame.utils.InputParser;
import racinggame.view.InputView;
import racinggame.view.OutputView;

public class GameConsoleController {
    private static final int ILLEGAL_GAME_TURN_COUNT = -1;

    private RacingGame racingGame;
    private InputParser inputParser;

    private IOController ioController;

    private Cars playerCars;
    private int gameTurnCnt;

    public GameConsoleController() {
        this.racingGame = new RacingGame();
        this.inputParser = new InputParser();

        this.ioController = new IOController();

        this.playerCars = new Cars();
        this.gameTurnCnt = 0;
    }

    public void setup() {
        readPlayerNames();
        readGameTurnCount();
    }

    private void readPlayerNames() {
        String playerNamesInput = this.ioController.AskPlayerNames();

        String[] playerNames = tryParsePlayerNames(playerNamesInput);

        if (playerNames == null) {
            playerNames = repeatReadPlayerNames();
        }

        this.playerCars.add(playerNames);
    }

    private String[] repeatReadPlayerNames() {
        String[] playerNames = null;

        while (playerNames == null) {
            String playerNamesInput = this.ioController.AskValidPlayerNames();

            playerNames = tryParsePlayerNames(playerNamesInput);
        }

        return playerNames;
    }

    private String[] tryParsePlayerNames(String input) {
        try {
            String[] playerNames = this.inputParser.splitPlayerNames(input);

            return playerNames;
        } catch (IllegalArgumentException e) {
            this.ioController.NotifyInvalidPlayerNames();
        }

        return null;
    }

    private void readGameTurnCount() {
        String gameTurnCntInput = this.ioController.AskGameTurnCount();

        int turnCnt = tryParseGameTurnCntInput(gameTurnCntInput);

        if (turnCnt < GlobalVariables.MIN_GAME_TURN_COUNT) {
            turnCnt = repeatReadGameTurnCount();
        }

        this.gameTurnCnt = turnCnt;
    }

    private int repeatReadGameTurnCount() {
        int gameTurnCnt = ILLEGAL_GAME_TURN_COUNT;

        while (gameTurnCnt < GlobalVariables.MIN_GAME_TURN_COUNT) {
            String gameTurnCntInput = this.ioController.AskValidGameTurnCount();

            gameTurnCnt = tryParseGameTurnCntInput(gameTurnCntInput);
        }

        return gameTurnCnt;
    }

    private int tryParseGameTurnCntInput(String gameTurnCntInput) {
        try {
            return this.inputParser.parseGameTurnCnt(gameTurnCntInput);
        } catch (IllegalArgumentException e) {
            this.ioController.NotifyInvalidGameTurnCnt();
        }

        return ILLEGAL_GAME_TURN_COUNT;
    }

    public void playGame() {
        Cars winnerCars = this.racingGame.play(this.playerCars, this.gameTurnCnt);

        this.ioController.NotifyWinners(winnerCars);
    }
}
