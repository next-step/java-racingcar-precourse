package racingcar.domain.game;

import racingcar.domain.car.CarNames;

public class GameResult {

    private GameRoundResults gameRoundResults;
    private CarNames winnerCarNames;

    private GameResult(GameRoundResults gameRoundResults, CarNames winnerCarNames) {
        this.gameRoundResults = gameRoundResults;
        this.winnerCarNames = winnerCarNames;
    }

    public static GameResult createGameResult(GameRoundResults gameRoundResultList, CarNames winnerCars) {
        return new GameResult(gameRoundResultList, winnerCars);
    }

    public GameRoundResults getGameRoundResults() {
        return gameRoundResults;
    }

    public CarNames getWinnerCars() {
        return winnerCarNames;
    }
}
