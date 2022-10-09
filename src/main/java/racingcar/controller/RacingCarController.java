package racingcar.controller;

import static racingcar.domain.RacingCarName.convertRacingCarNames;
import static racingcar.view.RacingCarInputView.readUserInput;
import static racingcar.view.RacingCarOutputView.printEmptyLine;
import static racingcar.view.RacingCarOutputView.printIllegalArgumentErrorMessage;
import static racingcar.view.RacingCarOutputView.printRacingCarNameDirection;
import static racingcar.view.RacingCarOutputView.printRacingResult;
import static racingcar.view.RacingCarOutputView.printRacingResultDirection;
import static racingcar.view.RacingCarOutputView.printRacingTimeDirection;
import static racingcar.view.RacingCarOutputView.printRacingWinners;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCarName;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingTime;

/**
 * 자동차 경주 게임 컨트롤러
 */
public class RacingCarController {

    public void process() {
        List<RacingCarName> racingCarNames = getRacingCarNames();
        RacingCars racingCars = createRacingCars(racingCarNames);
        RacingTime racingTime = getRacingTime();
        playRacing(racingTime, racingCars);
        findRacingWinner(racingCars);
    }

    private List<RacingCarName> getRacingCarNames() {
        printRacingCarNameDirection();
        try {
            String racingCarName = readUserInput();
            return convertRacingCarNames(racingCarName);
        } catch(IllegalArgumentException e) {
            printIllegalArgumentErrorMessage(e);
            return getRacingCarNames();
        }
    }

    private RacingTime getRacingTime() {
        printRacingTimeDirection();
        try {
            return new RacingTime(readUserInput());
        } catch (IllegalArgumentException e) {
            printIllegalArgumentErrorMessage(e);
            return getRacingTime();
        }
    }

    private RacingCars createRacingCars(List<RacingCarName> racingCarNames) {
        List<RacingCar> racingCars = new ArrayList<>();
        for(RacingCarName racingCarName: racingCarNames) {
            racingCars.add(new RacingCar(racingCarName));
        }
        return new RacingCars(racingCars);
    }

    private void playRacing(RacingTime racingTime, RacingCars racingCars) {
        printEmptyLine();
        printRacingResultDirection();
        for(int time = 0; time < racingTime.getRacingTime(); time++) {
            printCurrentRacingResult(racingCars.playRacing());
            printEmptyLine();
        }
    }

    private void printCurrentRacingResult(List<RacingCar> racingCars) {
        for(RacingCar racingCar: racingCars) {
            printRacingResult(racingCar.printCurrentRacingLocation());
        }
    }

    private void findRacingWinner(RacingCars racingCars) {
        String winners = racingCars.findWinners();
        printRacingWinners(winners);
    }
}
