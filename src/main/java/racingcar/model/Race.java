package racingcar.model;

import racingcar.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private static final String DELIMITER = ",";

    private RacingCars racingCars;
    private Round round;

    public void joinRacing(String carsInput) {
        List<Car> cars = new ArrayList<>();
        List<String> carNames = StringUtils.splitByDelimiter(carsInput, DELIMITER);
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        racingCars = new RacingCars(cars);
    }

    public void initRound(String roundInput) {
        this.round = new Round(roundInput);
    }

    public boolean open() {
        return !round.isOver();
    }

    public Winners end(RaceResults raceResults){
        return new Winners(raceResults);
    }

    public RaceResults run() {
        round.go();
        return new RaceResults(racingCars.race());
    }
}
