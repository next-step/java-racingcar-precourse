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

    public void step1() {
        while (racingCarGame.getCarList() == null) {
            try {
                racingCarGame.setCarList(gameInterface.getRacingCarNames());
            } catch (IllegalArgumentException e) {
                gameInterface.printErrorMessage(e.getMessage());
            }
        }
    }

    public void step2() {
        while (racingCarGame.getAttemptCnt() == 0) {
            try {
                racingCarGame.setAttemptCnt(gameInterface.getAttemptCount());
            } catch (NumberFormatException e) {
                gameInterface.printErrorMessage("숫자만 입력해주세요.");
            } catch (IllegalArgumentException e) {
                gameInterface.printErrorMessage(e.getMessage());
            }
        }
    }

    public void step3() {
        gameInterface.printMessage("\n실행 결과");
        while (!racingCarGame.isFinished()) {
            racingCarGame.proceed();
            gameInterface.printAttemptResult(racingCarGame.getCarList());
        }
    }

    public void step4() {
        gameInterface.printWinner(racingCarGame.getWinnerList());
    }

    public void exec() {
        step1();    // 1. 자동차 이름 입력
        step2();    // 2. 시도할 회수 입력
        step3();    // 3. 게임 진행 (경주)
        step4();    // 4. 최종 우승자 출력
    }

}
