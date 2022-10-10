package racingcar.model;

public class GameResult {
    private Spot maxSpot;
    private Cars winners;

    public GameResult(Spot maxSpot, Cars winners) {
        this.maxSpot = maxSpot;
        this.winners = winners;
    }

    public GameResult addWinner(Car car) {
        this.winners.add(car);
        return this;
    }

    public Cars winners() {
        return this.winners;
    }

    public Spot maxSpot() {
        return this.maxSpot;
    }
}
