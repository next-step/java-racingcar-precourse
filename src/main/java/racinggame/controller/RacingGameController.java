package racinggame.controller;

import racinggame.view.InputView;

public class RacingGameController {

    public static void startRacing() {
        String[] carNameList = InputView.enterCars();
        for (String s : carNameList) {
            System.out.println("s = " + s);
        }
    }
}
