package racingcar.domain.car;

import java.util.Objects;
import racingcar.domain.car.vo.Round;
import racingcar.domain.policy.MovePolicy;

public final class CarRaceTrack {

    private final MovePolicy movePolicy;
    private final Cars cars;
    private final History history;

    public CarRaceTrack(MovePolicy movePolicy, Cars cars, History history) {
        this.movePolicy = movePolicy;
        this.cars = cars;
        this.history = history;
    }

    public CarRaceTrack round(Round round) {
        Cars afterCars = cars;
        History afterHistory = history;
        for (int i = 0; i < round.value(); i++) {
            afterCars = afterCars.move(movePolicy);
            afterHistory = afterHistory.add(afterCars);
        }
        return new CarRaceTrack(movePolicy, afterCars, afterHistory);
    }

    public History history() {
        return history;
    }

    public Cars winners() {
        return cars.winners();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarRaceTrack raceTrack = (CarRaceTrack) o;
        return Objects.equals(movePolicy, raceTrack.movePolicy) && Objects.equals(cars, raceTrack.cars)
            && Objects.equals(history, raceTrack.history);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movePolicy, cars, history);
    }
}
