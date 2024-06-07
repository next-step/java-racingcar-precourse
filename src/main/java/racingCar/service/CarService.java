package racingCar.service;

import racingCar.repository.CarRepository;

public class CarService {
    private final CarRepository carRepository;

    /**
     * CarConfig로 부터 repository 객체를 가져와 의존성 주입
     * @param carRepository
     */
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;                     // DI
    }
}
