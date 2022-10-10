package racingcar.controller;

import racingcar.domain.RacingSystem;
import racingcar.view.InputView;
import racingcar.view.OutputView;


public class RacingController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void play() {
        RacingSystem racingSystem = new RacingSystem();

        setUpCars(racingSystem);
        setUpFinishPosition(racingSystem);

        for (int i = 0; i < racingSystem.getFinishPosition(); i++) {
            movingCar(racingSystem);
            outputView.resultMovingString(racingSystem);
        }
        outputView.finalVictoryCarString(racingSystem);


    }

    public void setUpCars(RacingSystem racingSystem) {
        boolean status = true;
        do {
            try {
                racingSystem.setUpCars(inputView.getCarNames());
                status = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (status);

    }

    public void setUpFinishPosition(RacingSystem racingSystem) {
        boolean status = true;
        do {
            try {
                racingSystem.setUpFinishPosition(inputView.getFinishPosition());
                status = false;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (status);
    }

    public void movingCar(RacingSystem racingSystem) {
        for (int i = 0; i < racingSystem.getCars().size(); i++) {
            racingSystem.getCars().get(i).move(racingSystem.getRandomNo());
        }
    }


}
