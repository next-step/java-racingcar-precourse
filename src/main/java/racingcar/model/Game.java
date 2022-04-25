package racingcar.model;

import racingcar.model.rule.CarMoveRule;
import racingcar.model.rule.PlayCountRule;

public class Game {
    CarMoveRule carMoveRule;
    PlayCountRule playCountRule;
    RacingCars racingCars;
    PlayCount playCount;

    GameStatus gameStatus;

    public Game(CarMoveRule carMoveRule, PlayCountRule playCountRule) {
        this.carMoveRule = carMoveRule;
        this.playCountRule = playCountRule;
        this.gameStatus = GameStatus.INIT;
    }

    public void setRacingCars(String carNames) {
        racingCars = new RacingCars(carNames, carMoveRule);
    }

    public void setPlayCount(String playCount) {
        this.playCount = new PlayCount(playCount, playCountRule);
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void playGame() {
        for (int i = 0; i < playCount.getPlayCount(); i++) {
            racingCars.playRound();
        }
        racingCars.setWinners();
    }

    public CurrentResult getCurrentResult() {
        return racingCars.getCurrentResult();
    }

    public WinnerResult getWinnersResult() {
        return racingCars.getWinnerOutPutResult();
    }

}
