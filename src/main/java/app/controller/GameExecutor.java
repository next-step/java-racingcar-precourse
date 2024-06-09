package app.controller;

import app.model.RacingCarGame;
import app.view.GameInterface;

import java.util.InputMismatchException;

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
        while (racingCarGame.getAttemptCnt() == 0) {
            try {
                racingCarGame.setAttemptCnt(gameInterface.getAttemptCount());
            } catch (NumberFormatException e) {
                gameInterface.printErrorMessage("숫자만 입력해주세요.");
            } catch (IllegalArgumentException e) {
                gameInterface.printErrorMessage(e.getMessage());
            }
        }
        gameInterface.printMessage("\n실행 결과");
        while (!racingCarGame.isFinished()) {
            racingCarGame.proceed();
            gameInterface.printAttemptResult(racingCarGame.getCarList());
        }
    }

}
