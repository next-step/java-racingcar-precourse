package service;

import repository.CarRepository;
import repository.CarRepositoryImpl;

public class RacingService {
    private final CarRepository carRepository = new CarRepositoryImpl();

    public void enrollCars(String carNames) {
        String[] nameArr = carNames.split(",\\s*|\\s+");
        for (String name : nameArr) {
            validateName(name);
            carRepository.add(name);
        }
    }
    protected void validateName(String name) {
        if (name == null || name.length() > 5) {
            throw new IllegalArgumentException("[ERROR] 이름은 5글자를 초과할 수 없습니다.");
        }
    }
}
