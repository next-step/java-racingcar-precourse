package racingcar.controller;

import racingcar.utils.ValidationUtils;
import racingcar.domain.ManageCar;
import racingcar.view.InputView;

public class RacingCar {

    private ManageCar manageCar;
    private String userInputCarNames;
    private String playRepeatCount;

    public void startGame(){
        initGameInfo();
        makeCarInfoList();
        playRacingGame();
    }

    private void initGameInfo() {
        ValidationUtils validationUtils = new ValidationUtils();
        do {
            this.userInputCarNames = InputView.getCarsNameInput();
        } while (!validationUtils.validName(userInputCarNames));

        do {
            playRepeatCount = InputView.getPlayRepeatInput();
        } while (!validationUtils.validRepeat(playRepeatCount));
    }

    public void makeCarInfoList() {
        manageCar = new ManageCar(userInputCarNames, playRepeatCount);
    }

    private void playRacingGame() {
        manageCar.playGame();
    }

}
