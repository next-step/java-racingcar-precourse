package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.util.RandomNumber;

public class RacingService {
    private final RacingCars racingCars = new RacingCars();
    private final RandomNumber randomNumber = new RandomNumber();

    public void round() {
        for (Car car : racingCars.getCarList()) {
            car.setPosition(racingCars.forward(randomNumber.getNumber()));
        }
    }

    public void init(String inputValue) {
        racingCars.createCar(inputValue);
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

}
