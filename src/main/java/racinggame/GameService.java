package racinggame;

import racinggame.domain.AttemptCount;
import racinggame.domain.Car;
import racinggame.domain.CarName;
import racinggame.domain.RacingCars;
import java.util.ArrayList;
import java.util.List;

import static racinggame.dto.GameView.*;

public class GameService {

    public void play() {
        RacingCars racingCars = this.getRacingCars();
        AttemptCount attemptCount = this.getAttemptCount();

        this.race(racingCars, attemptCount);
    }

    private void race(RacingCars racingCars, AttemptCount attemptCount) {
        printResultMessage();
        String winners = racingCars.race(attemptCount);
        printGameResult(winners);
    }

    protected RacingCars getRacingCars() {
        try {
            List<Car> cars = this.getCarsWith(enterCarNames());
            return new RacingCars(cars);
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            return this.getRacingCars();
        }
    }

    private List<Car> getCarsWith(String inputCarName) {
        List<Car> cars = new ArrayList<>();
        for (String car : inputCarName.split(",")) {
            cars.add(this.getCar(car));
        }
        return cars;
    }

    private Car getCar(String carName) {
        return new Car(new CarName(carName));
    }

    protected AttemptCount getAttemptCount() {
        try {
            String count = enterAttemptCount();
            return new AttemptCount(Integer.parseInt(count));
        } catch (IllegalArgumentException exception) {
            printErrorMessage(exception.getMessage());
            return this.getAttemptCount();
        }
    }

}
