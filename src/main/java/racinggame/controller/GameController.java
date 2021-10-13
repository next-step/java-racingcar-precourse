package racinggame.controller;

import racinggame.model.Cars;
import racinggame.model.RacingGame;
import racinggame.vo.GameTurnCnt;
import racinggame.vo.PlayerNames;

public class GameController {
    private RacingGame racingGame;

    private PlayerNamesReader playerNamesReader;
    private GameTurnCntReader gameTurnCntReader;
    private IOController ioController;

    private Cars playerCars;
    private GameTurnCnt gameTurnCnt;

    private boolean isSetup;

    public GameController() {
        this.racingGame = new RacingGame();

        this.ioController = new IOController();
        this.playerNamesReader = new PlayerNamesReader(this.ioController);
        this.gameTurnCntReader = new GameTurnCntReader(this.ioController);

        this.playerCars = new Cars();
        this.gameTurnCnt = new GameTurnCnt();

        this.isSetup = false;
    }

    public void setup() {
        PlayerNames playerNames = this.playerNamesReader.read();
        this.playerCars.add(playerNames);

        this.gameTurnCnt = this.gameTurnCntReader.read();

        this.isSetup = true;
    }

    public void launch() {
        if (!this.isSetup) {
            this.ioController.NotifyGameNotSetup();
            return;
        }

        Cars winnerCars = this.racingGame.play(this.playerCars, this.gameTurnCnt);

        this.ioController.NotifyWinners(winnerCars);
    }
}
