package racingcar.controller;

import racingcar.model.GameCount;
import racingcar.model.GameHistory;
import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class GameController {

    private RacingCars racingCars;
    private GameCount gameCount;
    private final GameHistory gameHistory = new GameHistory();

    public void initRacingCars(String input) {
        racingCars = RacingCars.createRacingCarsFromInput(input);
    }

    public void initGameCount(String input) {
        gameCount = new GameCount(input);
    }

    public void play() {

        while(!gameCount.isEnd()) {
            moveCars();
            gameCount.play();
        }
    }

    private void moveCars() {
        for(RacingCar racingCar : racingCars) {
            racingCar.move();
            record(racingCar.toString());
        }
        record("");
    }

    private void record(String history) {
        gameHistory.record(history);
    }

    public String getGameResult() {
        return gameHistory.toString();
    }

    public String getWinners() {
        StringBuilder winner = new StringBuilder();
        for(RacingCar racingCar : racingCars) {
            int winnerDistance = racingCars.getMaxDistance();
            addWinner(racingCar, winner, winnerDistance);
        }

        String result = winner.toString();
        return result.substring(0, result.length() - 2);
    }

    private void addWinner(RacingCar car, StringBuilder winner, int winnerDistance) {
        if(car.getDistance() == winnerDistance) {
            winner.append(car.getName());
            winner.append(", ");
        }
    }
}
