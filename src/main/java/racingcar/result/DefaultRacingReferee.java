package racingcar.result;

import racingcar.car.Car;
import racingcar.car.CarGroup;

import java.util.*;

enum DefaultRacingReferee implements RacingReferee {

    INSTANCE;

    @Override
    public RacingResult determine(CarGroup carGroup) {
        final List<Car> cars = carGroup.asList();
        final Map<Integer, List<Car>> carMap = new HashMap<>(cars.size());
        int maxPosition = cars.get(0).position();
        for (Car car : cars) {
            final List<Car> carsByPosition = carMap.computeIfAbsent(car.position(), position -> new ArrayList<>());
            carsByPosition.add(car);
            maxPosition = Math.max(maxPosition, car.position());
        }
        final List<Car> winningCars = carMap.get(maxPosition);
        return RacingResult.of(winningCars);
    }
}
