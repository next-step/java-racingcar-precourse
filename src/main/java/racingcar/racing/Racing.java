package racingcar.racing;

import racingcar.car.manager.Cars;

public class Racing {

    private final RacingProperties racingProperties;
    private final RacingMoveCount nowMoveCount;
    private final Cars cars;

    public Racing(RacingProperties racingProperties) {
        this.racingProperties = racingProperties;
        this.nowMoveCount = new RacingMoveCount(0);
        this.cars = new Cars(racingProperties.racingCarNames());
    }

    public void tryMove() {
        this.validMove();
        this.nowMoveCount.plus();
        this.cars.tryMoveAllCar();
    }

    public Cars cars() {
        return this.cars;
    }

    public boolean isEnd() {
        return this.racingProperties.isEndMove(this.nowMoveCount);
    }

    public void validMove() {
        if (isEnd()) {
            throw new IllegalArgumentException("[ERROR] 더이상 움직일 수 없습니다.");
        }
    }

    public WinnerCars winner() {
        return new WinnerCars(this.cars);
    }

}
