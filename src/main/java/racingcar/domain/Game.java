package racingcar.domain;

public class Game {
    private Cars cars;
    private RoundNumber roundNumber;

    public Cars cars() {
        return cars;
    }

    public RoundNumber roundNumber() {
        return roundNumber;
    }

    public void setCars(String carNames) {
        this.cars = new Cars(carNames);
    }

    public void setRoundNumber(String roundNumber) {
        this.roundNumber = new RoundNumber(roundNumber);
    }

    public void startGame() {
        cars.moveCars();
    }
}
