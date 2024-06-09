package app.controller;

import app.model.RacingCarGame;
import app.view.GameInterface;

public class GameExecutor {
    private GameInterface gameInterface;
    private RacingCarGame racingCarGame;

    public GameExecutor(GameInterface gameInterface, RacingCarGame racingCarGame) {
        this.gameInterface = gameInterface;
        this.racingCarGame = racingCarGame;
    }

    public void exec() {
        // 게임 최초 실행 시 동작
        while (racingCarGame.getCarList() == null) {
            try {
                racingCarGame.setCarList(gameInterface.getRacingCarNames());
            } catch (IllegalArgumentException e) {
                gameInterface.printErrorMessage(e.getMessage());
            }
        }
    }

}
