package racingcar.car.model;

import racingcar.car.GameStatus;
import racingcar.car.model.domain.CarsManager;
import racingcar.car.model.dto.CarDTO;
import racingcar.car.model.validator.*;

import java.util.ArrayList;
import java.util.List;

public class RacingModel {
    private final List<Validator> validators = new ArrayList<>();
    private CarsManager carsManager;

    public RacingModel() {
        getValidators();
    }

    private void getValidators() {
        validators.add(new ValidateRacingNumberIntputCannotParseInteger());
        validators.add(new ValidateRacingNumberInputRangeOverOne());
        validators.add(new ValidateCarNameInputSplitResultSizeMoreThanZero());
        validators.add(new ValidateCarNameInputCheckCarNameLength());
    }

    public String validateInput(String input, GameStatus gameStatus) {
        for (Validator validator : validators) {
            executeValidate(validator, gameStatus, input);
        }
        return input;
    }

    private boolean executeValidate(Validator validator, GameStatus gameStatus, String input) {
        if (validator.canValidate(gameStatus) == false)
            return true;
        return validator.validate(input);
    }

    public void createCars(String input) {
        carsManager = new CarsManager(input);
    }

    public ArrayList<CarDTO> move() {
        return carsManager.move();
    }

    public ArrayList<CarDTO> electWinner() {
        return carsManager.electWinner();
    }
}
