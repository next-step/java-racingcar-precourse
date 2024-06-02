package controller;

import java.util.List;
import model.RacingCar;
import service.GameService;
import view.GameView;

public class GameController {

    private final GameService gameService = new GameService();
    private final GameView gameView = new GameView();
    private List<RacingCar> racingCars;
    private int numRounds;

    /**
     * 자동차 경주 게임 메서드
     */
    public void startGame() {
        setUpGame();
        while (numRounds > 0) {
            playGameByRound();
            numRounds--;
        }
        getGameResult();
    }

    /**
     * 자동차 경주 게임 준비 메서드
     */
    private void setUpGame() {
        getCarsName();
        getRounds();
    }

    /**
     * 자동차 경주 게임 결과 처리 메서드
     */
    private void getGameResult() {
        int maxPosition = gameService.getMaxPosition(racingCars);
        List<String> winners = gameService.determineWinner(racingCars, maxPosition);
        gameView.displayWinner(winners);
    }

    /**
     * 시도 횟수 입력 처리 메서드
     */
    private void getRounds() {
        boolean isValidRoundsFlag = false;
        int inputRounds = 0;
        while (!isValidRoundsFlag) {
            inputRounds = gameView.inputRounds();
            try {
                isValidRoundsFlag = gameService.validateRounds(inputRounds);
            } catch (IllegalArgumentException e) {
                gameView.outputException(e);
            }
        }
        numRounds = inputRounds;
    }

    /**
     * 자동차 이름 입력 처리 메서드
     */
    private void getCarsName() {
        boolean isValidCarNameFlag = false;
        String inputCarNames = null;
        while (!isValidCarNameFlag) {
            inputCarNames = gameView.inputCarNames();
            try {
                isValidCarNameFlag = gameService.validateCarNames(inputCarNames);
            } catch (IllegalArgumentException e) {
                gameView.outputException(e);
            }
        }
        racingCars = gameService.createCarList(inputCarNames);
    }

    /**
     * 라운드별 게임 진행 처리 메서드
     */
    private void playGameByRound() {
        for (RacingCar racingCar : racingCars) {
            int randomNum = gameService.generateCarRandomNum(racingCar);
            gameService.determineCarMove(randomNum, racingCar);
        }
        gameView.displayCurrentRound(racingCars);
    }
}
