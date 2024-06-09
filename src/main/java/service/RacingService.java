package service;

import repository.CarRepository;
import repository.CarRepositoryImpl;
import utility.StringSplitter;

public class RacingService {
    private final CarRepository carRepository = new CarRepositoryImpl();
    private final StringSplitter sp = new StringSplitter();

    public CarRepository getCarRepository(){
        return carRepository;
    }

    public void enrollCars(String carNames) {
        String[] nameArr = sp.splitter(carNames);
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
