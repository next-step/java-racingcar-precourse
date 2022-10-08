package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.RacingCars;
import racingcar.model.Round;
import racingcar.view.OutputView;

public class RoundManager {
    private final Round round;
    private final RacingCars racingCars;

    public RoundManager(Round round, RacingCars racingCars) {
        this.round = round;
        this.racingCars = racingCars;
    }

    public void playRound() {
        for(int i=0; i<round.getRound(); i++) {
            moveCars();
            printRound();
        }
    }

    public void moveCars() {
        for(int i=0; i<racingCars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            racingCars.get(i).moveOrNot(randomNumber);
        }
    }

    public void printRound() {
        for(int i=0; i< racingCars.size(); i++) {
            racingCars.get(i).printPosition();
        }
        OutputView.printLine();
    }
}
