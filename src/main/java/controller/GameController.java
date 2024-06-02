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
        this.racingCars = gameService.getCarNames();
////        사용자로부터 시도 횟수 입력 받기
//        this.numRounds = gameService.getRounds();
//        while (numRounds > 0) {
////            라운드별 게임 진행
//            playGameByRound();
//            numRounds--;
//        }
////        우승자 판단
//        List<String> winners = gameService.determineWinner();
////        우승자 출력
//        gameView.displaywinner(winners);
    }

//    private void playGameByRound() {
//        for (RacingCar racingCar : racingCars) {
////            자동차별 0에서 9사이 무작위 난수 생성
//            gameService.generateCarRandomNum(racingCar);
////            난수값이 4 이상인 경우 전진
//            gameService.determineCarMove(racingCar);
//        }
////            UI 표기
//        gameView.displayCurrentRound(racingCars);
//    }
}
