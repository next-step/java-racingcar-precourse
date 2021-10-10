package racinggame.controller;

import racinggame.common.Constant;
import racinggame.common.enums.Messages;
import racinggame.domain.CarFacroty;
import racinggame.domain.Cars;
import racinggame.utils.Utils;
import racinggame.view.CarView;

import java.util.NoSuchElementException;

public class CarController {

    private final CarView carView;

    public CarController(CarView carView) {
        this.carView = carView;
    }

    public CarFacroty validInputCarNames() {
        carView.printMessage(Messages.CAR_NAME_INPUT.getMessage());
        String input = Utils.getInputString();
        CarFacroty carFacroty = null;
        try {
            carFacroty = new CarFacroty(input);
        } catch (NoSuchElementException e) {
            carView.printMessage(e.getMessage());
            this.validInputCarNames();
        }
        return carFacroty;
    }

    public int validInputNumberGames() {
        carView.printMessage(Messages.NUMBER_ATTEMPT.getMessage());
        String input = Utils.getInputString();
        int result = 0;
        try {
            result = this.validChracter(input);
        } catch (NoSuchElementException e) {
            carView.printMessage(e.getMessage());
            this.validInputNumberGames();
        }
        return result;
    }

    private int validChracter(String input) {
        if(!Utils.getCharacterCheck(input)) {
            throw new NoSuchElementException(Messages.GAME_NUMBER_CHRACTER_CHECK.getMessage(Constant.STR_ERROR));
        }
        return Utils.getStringToInt(input);
    }

    public void calculatePrint(int attempt, Cars cars) {
        for (int i = 0; i < attempt; i++) {
            cars.play(Utils.getRandomList(cars.getCarsSize()));
            carView.printStatus(cars.getCars());
            carView.printLine();
        }
    }
}
