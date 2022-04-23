package racingcar.nextstep.infrastructure.racing;

import racingcar.nextstep.domain.car.Car;
import racingcar.nextstep.domain.car.Cars;
import racingcar.nextstep.domain.racing.service.RacingReferee;

import java.util.ArrayList;
import java.util.List;

public class RacingRefereeImpl implements RacingReferee {

    @Override
    public Cars findWinners(Cars cars) {
        final int position = findMaxPosition(cars);
        return findWinnersWithMaxPosition(cars, position);
    }

    private Cars findWinnersWithMaxPosition(Cars cars, int position) {
        List<Car> winnerCars = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getCarPosition().getValue() == position) {
                winnerCars.add(car);
            }
        }
        return Cars.of(winnerCars);
    }

    private int findMaxPosition(Cars cars) {
        int max = Integer.MIN_VALUE;
        for (Car car : cars.getCars()) {
            if (car.getCarPosition().getValue() > max) {
                max = car.getCarPosition().getValue();
            }
        }
        return max;
    }
}
