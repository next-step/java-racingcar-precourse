package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarMovingStrategy;
import racingcar.domain.car.CarName;
import racingcar.domain.car.Distance;
import racingcar.domain.racing.CarStatus;
import racingcar.domain.racing.CarStatuses;
import racingcar.domain.racing.Racing;
import racingcar.domain.racing.RacingCars;

public class Fixtures {
    public static CarMovingStrategy ALWAYS_FORWARD_ONE_STRATEGY = new AlwaysForwardStrategy(1);

    public static CarStatuses carStatusesOf(int distance, String... names) {
        final List<CarStatus> list = new ArrayList<>();
        for (String name : names) {
            final CarStatus status = createCarStatus(name, distance);
            list.add(status);
        }

        return new CarStatuses(list);
    }

    public static CarStatus createCarStatus(String name, int distanceFromStartingPoint) {
        return new CarStatus(new CarName(name), new Distance(distanceFromStartingPoint));
    }

    public static Racing createRacing(int movingTrials, String... carNames) {
        final List<String> nameList = Arrays.asList(carNames);
        final RacingCars racingCars = RacingCars.createdBy(nameList, ALWAYS_FORWARD_ONE_STRATEGY);
        return new Racing(racingCars, movingTrials);
    }

    public static Car createCar(String name, int distance) {
        final Car car = new Car(new CarName(name), new AlwaysForwardStrategy(distance));
        car.move();
        return car;
    }
}
