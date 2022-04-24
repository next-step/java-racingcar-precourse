package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import racingcar.constant.Digit;
import racingcar.view.RacingGameView;

public class RacingGameImp implements RacingGame {

    private Cars cars;
    private RaceNumber raceNumber;

    @Override
    public void init() {
        getCarName();
        getRaceNumber();
    }

    @Override
    public void run() {
        RacingGameView.printResultMessage();
        while (!raceNumber.isZero()) {
            this.driveCars(cars);
            raceNumber.minus();
        }
        this.printWinner(cars);
    }

    private void getCarName() {
        try {
            RacingGameView.getReqCarNameMessage();
            cars = new Cars(RacingGameView.getUserInput());
        } catch (IllegalArgumentException e) {
            RacingGameView.printMessage(e.getMessage());
            getCarName();
        }
    }

    private void getRaceNumber() {
        try {
            RacingGameView.getReqRaceNumberMessage();
            raceNumber = new RaceNumber(RacingGameView.getUserInput());
        } catch (IllegalArgumentException e) {
            RacingGameView.printMessage(e.getMessage());
            getRaceNumber();
        }
    }

    private void driveCars(Cars cars) {
        for (int i = Digit.ZERO.getNumber(); i < cars.getNumberOfCars(); i++) {
            cars.carDrive(i,
                pickNumberInRange(Digit.START_RANGE.getNumber(), Digit.END_RANGE.getNumber()));
            RacingGameView.printMessage(cars.getCarStatus(i));
        }
        RacingGameView.printLineBreak();
    }

    private void printWinner(Cars cars) {
        RacingGameView.printWinner();
        RacingGameView.printMessage(cars.getWinner());
    }

}
