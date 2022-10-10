package racingcar.referee.domain;

import racingcar.car.domain.Car;
import racingcar.car.domain.CarPosition;

import static racingcar.referee.ui.OutputPlayRound.printPlayRound;

public class Referee {

    private static final String SHOW_RESULT = "실행 결과";
    private final RacingCars racingCars;
    private MovingNumber movingNumber;

    public Referee(RacingCars racingCars, MovingNumber movingNumber) {
        this.racingCars = racingCars;
        this.movingNumber = movingNumber;
    }

    public void playAllRound() {
        System.out.println(SHOW_RESULT);
        do {
            playRound();
        } while (!isMovingNumberZero());
    }

    private boolean isMovingNumberZero() {
        return this.movingNumber.equals(new MovingNumber(0));
    }

    public void playRound() {
        this.racingCars.move();
        this.movingNumber = this.movingNumber.subtract();
        printPlayRound(racingCars);
    }

    public WinningCars declareWinningCars() {
        WinningCars winningCars = new WinningCars();
        for (Car car : this.racingCars.cars()) {
            addWinningCar(winningCars, car);
        }
        return winningCars;
    }

    private void addWinningCar(WinningCars winningCars, Car car) {
        if (car.carPosition().equals(maxPosition())) {
            winningCars.add(car);
        }
    }

    private CarPosition maxPosition() {
        CarPosition maxPosition = new CarPosition();
        for (Car car : this.racingCars.cars()) {
            maxPosition = compareCarPosition(maxPosition, car);
        }
        return maxPosition;
    }

    private static CarPosition compareCarPosition(CarPosition maxPosition, Car car) {
        if (maxPosition.compareTo(car.carPosition()) < 0) {
            maxPosition = car.carPosition();
        }
        return maxPosition;
    }

    public MovingNumber movingNumber() {
        return this.movingNumber;
    }
}
