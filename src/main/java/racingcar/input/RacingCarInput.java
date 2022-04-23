package racingcar.input;

import racingcar.input.validator.CarNamesValidatorGroup;
import racingcar.view.output.OutputView;
import racingcar.view.input.RacingCarInputMessageInput;

public class RacingCarInput {
    private final CarNamesValidatorGroup carNamesValidatorGroup;
    private final Input input;
    private final String carNames;

    public RacingCarInput(CarNamesValidatorGroup carNamesValidatorGroup) {
        this.carNamesValidatorGroup = carNamesValidatorGroup;
        input = new Input(new RacingCarInputMessageInput());
        carNames = this.validateCarNames();
    }

    private String validateCarNames() {
        String carNamesInput = "";

        try {
            carNamesInput = input.getMessage();
            this.carNamesValidatorGroup.validate(carNamesInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return validateCarNames();
        }

        return carNamesInput;
    }

    public String getCarNames() {
        return carNames;
    }
}
