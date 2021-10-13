package racinggame.controller;

import racinggame.exception.ValidationException;
import racinggame.model.Car;
import racinggame.model.RacingCars;
import racinggame.model.Round;
import racinggame.service.RacingService;
import racinggame.util.Validation;
import racinggame.view.InputView;
import racinggame.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private InputView inputView;
    private OutputView outputView;
    private Validation validation;

    public RaceController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.validation = new Validation();
    }

    public void run() {
        RacingService racingService = new RacingService(inputCarName());
        racingService.playRounds(inputRacingRound().getRound());
    }

    private RacingCars inputCarName() {
        RacingCars racingCars = null;
        try {
            racingCars = new RacingCars(createCar(validation.validateCarName(inputView.inputCarName())));
        } catch (ValidationException ve) {
            outputView.displayError(ve.getMessage());
            inputCarName();
        }
        return racingCars;
    }

    private Round inputRacingRound() {
        Round round = null;
        try {
            round = new Round(inputView.inputRacingRound());
        } catch (ValidationException ve) {
            outputView.displayError(ve.getMessage());
            inputRacingRound();
        }
        return round;
    }

    private List<Car> createCar(List<String> racingCars) {
        List<Car> carList = new ArrayList<>();
        for (String name : racingCars) {
            carList.add(new Car(name));
        }
        return carList;
    }

}
