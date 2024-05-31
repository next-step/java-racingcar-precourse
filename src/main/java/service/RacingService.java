package service;

import view.InputView;

public class RacingService {

    public String[] createCars() {
        String input = InputView.inputCarList();
        input = input.replaceAll(" ", "");
        return input.split(",");
    }
}
