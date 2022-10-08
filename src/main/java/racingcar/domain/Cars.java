package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars = new ArrayList<>();
    private final MovingStrategy movingStrategy = new RandomNumberMovingStrategy();

    public Cars(final List<CarName> carNames) {
        for (final CarName name : carNames) {
            this.cars.add(new Car(name));
        }
    }

    public PlayResult play() {
        for (final Car car : cars) {
            car.racing(movingStrategy);
        }
        return new PlayResult(toDtos());
    }

    public PlayResult winners() {
        List<CarDTO> result = new ArrayList<>();
        List<CarDTO> dtos = toDtos();
        dtos.sort((a, b) -> b.getDistance().compareTo(a.getDistance()));
        int maxDistance = dtos.get(0).getDistance();
        while (!dtos.isEmpty() && dtos.get(0).getDistance() == maxDistance) {
            result.add(dtos.get(0));
            dtos.remove(0);
        }
        return new PlayResult(result);
    }

    private List<CarDTO> toDtos() {
        List<CarDTO> result = new ArrayList<>();
        for (final Car car : cars) {
            result.add(new CarDTO(car.getName().getValue(), car.getDistance().intValue()));
        }
        return result;
    }
}
