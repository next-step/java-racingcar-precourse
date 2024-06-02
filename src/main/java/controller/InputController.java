package controller;

import model.RaceValidator;
import view.InputView;

public class InputController {

    private final RaceValidator raceValidator;
    private final InputView inputView;

    public InputController() {
        raceValidator = new RaceValidator();
        inputView = new InputView();
    }

    public String[] processingUserInputCarsName() {
        try{
            return raceValidator.checkSplitCarsName(inputView.carsNameInput());
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] " + e.getMessage() + " 다시 입력하세요.");
            return processingUserInputCarsName();
        }
    }

    public int processingUserInputTryNumber() {
        try {
            return raceValidator.checkValidTryNumber(inputView.tryNumberInput());
        }catch (IllegalArgumentException illegalArgumentException){
            System.out.println("[ERROR] " + illegalArgumentException.getMessage() + " 다시 입력하세요.");
            return processingUserInputTryNumber();
        }
    }
}
