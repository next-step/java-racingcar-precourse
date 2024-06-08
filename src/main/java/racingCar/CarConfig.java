package racingCar;

import racingCar.repository.CarMemoryRepository;
import racingCar.repository.CarRepository;
import racingCar.service.CarService;

public class CarConfig {
    private static final CarRepository carRepository = new CarMemoryRepository();
    private static final CarService carService = new CarService(carRepository);

    private CarConfig() {}

    public static CarService getCarService() {
        return carService;
    }

    public static CarRepository getCarRepository() {
        return carRepository;
    }
}
