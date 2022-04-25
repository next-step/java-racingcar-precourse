package racingcar.application;

import racingcar.core.exception.ValidationException;
import racingcar.core.validate.Validation;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Round;
import racingcar.ui.GameView;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    private GameView gameView;

    private Validation validation;

    public RacingService() {
        this.gameView = new GameView();
        this.validation = new Validation();
    }

    public void run() {
        Cars cars = inputCarName();
        Round roundCount = inputRacingRound();

        for (int i = 0; i < roundCount.getRound(); i++) {
            gameView.displayResults(cars.playRound());
        }
        gameView.finalResult(cars.getWinner());
    }

    private Cars inputCarName() {
        Cars racingCars = null;
        try {
            racingCars = new Cars(createCars(validation.validateList(gameView.inputCarName())));

        } catch (ValidationException ve) {
            gameView.displayError(ve.getMessage());
            inputCarName();
        }
        return racingCars;
    }

    private List<Car> createCars(List<String> racingCars) {
        List<Car> cars = new ArrayList<>();
        for (String name : racingCars) {
            cars.add(new Car(validation.validateName(name)));
        }
        return cars;
    }

    private Round inputRacingRound() {
        Round round = null;
        try {
            round = new Round(validation.validateRound(gameView.inputRacingRound()));
        } catch (ValidationException ve) {
            gameView.displayError(ve.getMessage());
            inputRacingRound();
        }
        return round;
    }
}
