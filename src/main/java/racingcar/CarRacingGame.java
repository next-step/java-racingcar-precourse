package racingcar;

import racingcar.controller.RacingController;

public class CarRacingGame {
    private RacingController racingController;

    public CarRacingGame(RacingController controller) {
        this.racingController = controller;
    }

    public void runRacingCarGame() {
        initRacing();
        runRacing();
        showWinners();
    }

    private void runRacing() {
        System.out.println(Constans.MESSAGE_GAME_RESULT.getMessage());

        for (int i = 0; i < racingController.getTryCount(); i++) {
            racingController.runRacing();
            racingController.showRacingStatus();
        }
    }


    private void showWinners() {
        racingController.showWinners();
    }

    private void initRacing() {
        initRacingCars();
        initRacingTry();
    }

    private void initRacingTry() {
        try {
            racingController.setTryNumber(inputRacingTrys());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initRacingTry();
        }
    }
    private String inputRacingCarList() {
        System.out.println(Constans.MESSAGE_GAME_INPUT_CAR_LIST.getMessage());
        String list = camp.nextstep.edu.missionutils.Console.readLine();
        return list;
    }

    private String inputRacingTrys() {
        System.out.println(Constans.MESSAGE_GAME_INPUT_TRY_NUMBER.getMessage());
        String tryTotal = camp.nextstep.edu.missionutils.Console.readLine();
        return tryTotal;
    }


    private void initRacingCars() {
        try {
            racingController.setRacingCarLineUp(inputRacingCarList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            initRacingCars();
        }
    }
}
