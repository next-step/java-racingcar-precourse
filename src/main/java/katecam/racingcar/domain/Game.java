package katecam.racingcar.domain;

import java.util.List;

public class Game {
    private final Cars cars;
    private final int numberToAttempt;
    private int attemptedNumber;

    public Game(List<String> carNames, int carNumber) {
        this.cars = Cars.of(carNames);
        this.numberToAttempt = carNumber;
    }

    public List<Car> getCars(){
        return this.cars.getCars();
    }

    public List<Car> getWinners(){
        if (!isEnded()) throw new IllegalStateException("게임 종료 안됨");
        return cars.getWinners();
    }

    public void playTurn() {
        if (isEnded()) throw new IllegalStateException("게임이 이미 종료됨");
        cars.moveAll();
        attemptedNumber++;
    }

    public boolean isEnded(){
        return this.attemptedNumber == this.numberToAttempt;
    }

    public int getNumberToAttempt() {
        return numberToAttempt;
    }

    public int getAttemptedNumber() {
        return attemptedNumber;
    }
}
