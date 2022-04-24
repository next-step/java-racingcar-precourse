package racingcar.domain.racing.racer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import racingcar.domain.racing.car.Car;
import racingcar.domain.racing.car.Cars;
import racingcar.domain.racing.car.accelerator.generator.AcceleratorGenerator;

public class CarRacers {
    private final Map<Racer, Car> racerCarMap;

    CarRacers(Map<Racer, Car> racerCarMap) {
        this.racerCarMap = racerCarMap;
    }

    private CarRacers(Cars cars, AcceleratorGenerator acceleratorGenerator) {
        racerCarMap = generateRacers(cars, acceleratorGenerator);
    }

    public static CarRacers from(Cars cars, AcceleratorGenerator acceleratorGenerator) {
        return new CarRacers(cars, acceleratorGenerator);
    }

    public CarRacers race() {
        Map<Racer, Car> racerCarMap = new LinkedHashMap<>();
        for (Map.Entry<Racer, Car> entry : this.racerCarMap.entrySet()) {
            Racer racer = entry.getKey();
            Car car = entry.getValue();
            racerCarMap.put(racer, racer.drive(car));
        }
        return new CarRacers(racerCarMap);
    }

    public Cars getCars() {
        return Cars.from(new ArrayList<>(racerCarMap.values()));
    }

    public Winner getWinner() {
        return Winner.find(new ArrayList<>(racerCarMap.values()));
    }

    private Map<Racer, Car> generateRacers(Cars cars, AcceleratorGenerator acceleratorGenerator) {
        Map<Racer, Car> racerCarMap = new LinkedHashMap<>();
        for (Car car : cars.getCarList()) {
            racerCarMap.put(Racer.from(acceleratorGenerator), car);
        }
        return racerCarMap;
    }
}
