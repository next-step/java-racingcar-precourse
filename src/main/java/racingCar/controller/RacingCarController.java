package racingCar.controller;

import racingCar.model.RacingCarModel;
import racingCar.view.UI;

public class RacingCarController {

    public static void main(String[] args) {
        UI ui = new UI();
        String[] UserInputCarName;
        RacingCarModel racingCarModel;
        RacingCarUtil racingCarUtil = new RacingCarUtil();

        UserInputCarName = racingCarUtil.getUserInputCarName(ui);
        if (UserInputCarName == null) {
            ui.notifyExit();
            return;
        }

        racingCarModel = new RacingCarModel();
        racingCarModel.initCarStats(UserInputCarName);
        racingCarUtil.setAttempts(racingCarModel, ui);

        ui.notifyThisIsResult();

        racingCarUtil.doRacing(racingCarModel.getCarStatus(), racingCarModel.getAttempts(), ui);

        ui.printWinner(racingCarUtil.retWinner(racingCarModel.getCarStatus()));
        ui.close();

    }

}


