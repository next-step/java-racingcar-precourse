package racingcar.controller;

import racingcar.constant.GameMessage;
import racingcar.model.collection.CarGroups;

public class RacingCarGame {

    private CarGroups carGroups;

    private int tryCount;

    public RacingCarGame() {
    }

    public void setCarGroups(String carGroups) {
        this.carGroups = new CarGroups(carGroups);
    }

    public void setTryCount(String tryCount) {
        validateTryCount(tryCount);
        this.tryCount = Integer.parseInt(tryCount);
    }

    private void validateTryCount(String tryCount) {
        for (char countChar : tryCount.toCharArray()) {
            if (countChar < '0' || countChar > '9') {
                throw new IllegalArgumentException(GameMessage.NOT_VALID_TRYCOUNT_NUMBER_MESSAGE);
            }
        }
    }

    public void play() {
        for (int i = 0; i < tryCount; i++) {
            carGroups.moveAll();
            carGroups.showLocations();
        }
        showResult();
    }

    private void showResult() {
        String winners = carGroups.getWinners();
        System.out.printf(GameMessage.SHOW_WINNER_MESSAGE, winners);
    }

}
