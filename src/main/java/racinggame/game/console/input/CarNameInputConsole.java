package racinggame.game.console.input;

import nextstep.utils.Console;
import racinggame.game.car.CarNames;

public class CarNameInputConsole extends BaseInputConsole<CarNames> {

    private CarNames carNames;

    public CarNameInputConsole(String inputMessage,
                               String errorMessage) {
        super(inputMessage, errorMessage);
    }

    @Override
    public CarNames getInputValue() {
        boolean doRepeat = true;

        while (doRepeat) {
            super.printInputMessage();
            String inputValue = Console.readLine();
            boolean isValidPolicy = isValidPolicy(inputValue);
            doRepeat = !isValidPolicy;
            super.printErrorMessageIfNotValid(isValidPolicy);
        }

        return this.carNames;
    }

    @Override
    protected boolean isValidPolicy(String inputValue) {
        this.carNames = new CarNames(inputValue);
        return this.carNames.isValid();
    }

}
