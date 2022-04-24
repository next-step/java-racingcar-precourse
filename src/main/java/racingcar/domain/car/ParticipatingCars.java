package racingcar.domain.car;


import racingcar.domain.race.RacePreparation;

import java.util.List;

public class ParticipatingCars {
    private List<Car> cars;

    public ParticipatingCars(String[] allParticipateCars) {
        CarNameValidation.validation(allParticipateCars);
        RacePreparation racePreparation = new RacePreparation();
        this.cars = racePreparation.carRegistration(allCarName);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}
