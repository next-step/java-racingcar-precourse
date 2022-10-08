package racingcar.service;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;
import racingcar.util.Message;
import racingcar.view.OutputView;

public class GameManager {
    private final RacingCars racingCars;
    private RacingCars winners;

    public GameManager(RacingCars racingCars) {
        this.racingCars = racingCars;
        winners = new RacingCars();
    }

    public void calculateResult() {
        int maxPosition = 0;

        for(int i=0; i<racingCars.size(); i++) {
            RacingCar racingCar = racingCars.get(i);
            maxPosition = getMaxPositionAndInitWinnerList(racingCar, maxPosition);
            addWinnerIfEqualsMaxPosition(racingCar, maxPosition);
        }
    }

    private int getMaxPositionAndInitWinnerList(RacingCar racingCar, int maxPosition) {
        if(racingCar.getPosition() > maxPosition) {
            winners = new RacingCars();
            return racingCar.getPosition();
        }

        return maxPosition;
    }

    private void addWinnerIfEqualsMaxPosition(RacingCar racingCar, int maxPosition) {
        if(racingCar.getPosition() == maxPosition) {
            winners.add(racingCar);
        }
    }

    public void printResult() {
        OutputView.print(String.format(Message.WINNER.getMessage(), winners.toString()));
    }
}
