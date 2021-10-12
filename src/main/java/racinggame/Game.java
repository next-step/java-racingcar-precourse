package racinggame;

import racinggame.domain.AttemptNumber;
import racinggame.domain.RacingCars;
import racinggame.utils.Message;
import racinggame.domain.Player;
import racinggame.domain.Winners;
import racinggame.exception.RacingGameException;

public class Game {
    private static final Message ASK_NAMES_MESSAGE = new Message("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    private static final Message ASK_ATTEMPT_NUMBER_MESSAGE = new Message("시도할 회수는 몇회인가요?");

    private final Player player;

    public Game(Player player) {
        this.player = player;
    }

    public void start() {
        Winners winners = race(getValidCars(), getValidAttemptNumber());
        winners.makeWinnersMessage().print();
    }

    private RacingCars getValidCars() {
        try {
            ASK_NAMES_MESSAGE.print();
            return new RacingCars(player.inputNames());
        } catch (RacingGameException e) {
            new Message(e.getMessage()).printError();
            return getValidCars();
        }
    }

    private AttemptNumber getValidAttemptNumber() {
        try {
            ASK_ATTEMPT_NUMBER_MESSAGE.print();
            return player.inputAttemptNumber();
        } catch (RacingGameException e) {
            new Message(e.getMessage()).printError();
            return getValidAttemptNumber();
        }
    }

    private Winners race(RacingCars racingCars, AttemptNumber attemptNumber) {
        if (attemptNumber.isOver()) {
            return racingCars.findWinners();
        }

        attemptNumber.decrement();
        racingCars.moveForwardOrStop();
        racingCars.makeResultMessage().print();
        return race(racingCars, attemptNumber);
    }
}
