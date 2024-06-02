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

    public void startGame() {
//        사용자로부터 자동차 이름 입력 받기
        getCarsName();
//        사용자로부터 시도 횟수 입력 받기
        getRounds();
        while (numRounds > 0) {
//            라운드별 게임 진행
            playGameByRound();
            numRounds--;
        }
        getGameResult();
    }

    private void getGameResult() {
//        최고 점수 판단
        int maxPosition = gameService.getMaxPosition(racingCars);
//        우승자 판단
        List<String> winners = gameService.determineWinner(racingCars, maxPosition);
//        우승자 출력
        gameView.displaywinner(winners);
    }

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

    private void playGameByRound() {
        for (RacingCar racingCar : racingCars) {
//            자동차별 0에서 9사이 무작위 난수 생성
            int randomNum = gameService.generateCarRandomNum(racingCar);
//            난수값이 4 이상인 경우 전진
            gameService.determineCarMove(randomNum, racingCar);
        }
//            UI 표기
        gameView.displayCurrentRound(racingCars);
    }
}
