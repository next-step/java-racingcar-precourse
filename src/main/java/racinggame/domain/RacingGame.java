package racinggame.domain;

import racinggame.domain.exceptions.BusinessException;
import racinggame.domain.exceptions.FinishGameException;
import racinggame.domain.strategy.MoveStrategy;

import java.util.Objects;

public class RacingGame {

    private Cars cars;
    private Boolean isFinish;

    public RacingGame(final Cars cars) {
        this.cars = cars;
    }

    public RacingGame(final Cars cars, final boolean isFinish) {
        this.cars = cars;
        this.isFinish = isFinish;
    }

    public RacingGame next(final MoveStrategy moveStrategy) {
        checkFinishGame();
        cars.move(moveStrategy);
        return new RacingGame(cars, isFinish);
    }

    private void checkFinishGame() {
        if (isFinish) {
            throw new FinishGameException();
        }
    }

    private void checkWinners() {
        if (!isFinish) {
            throw new BusinessException("종료되지 않은 게임은 우승자가 없습니다.");
        }
    }

    public Winners winners() {
        checkWinners();
        return new Winners(this.cars.winners());
    }

    public void finish() {
        this.isFinish = true;
    }

    public Cars getCars() {
        return new Cars(cars);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGame that = (RacingGame) o;
        return isFinish == that.isFinish && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, isFinish);
    }
}
