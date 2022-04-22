package racingcar.domain;

import racingcar.common.PrintMessage;

public class RacingGame {
    private final Cars cars;
    private final RacingRounds rounds;

    public RacingGame(Cars cars, RacingRounds rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void playGame() {
        RandomNumberGenerator generator = new RandomNumberGenerator();
        MovingStrategy strategy = new RandomNumberStrategy(generator);

        while (!rounds.isEndGame()) {
            cars.move(strategy);
            cars.printCarsPosition();
            rounds.endCurrentRound();
        }
    }

    public void endGame() {
        RacingResult result = new RacingResult(cars);
        PrintMessage.print(result.createWinnerMessage());
    }
}
