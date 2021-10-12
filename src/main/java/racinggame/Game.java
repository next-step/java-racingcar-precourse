package racinggame;

import racinggame.domain.AttemptNumber;
import racinggame.domain.Cars;
import racinggame.domain.Message;
import racinggame.domain.Player;

public class Game {
    private static final Message ASK_NAMES_MESSAGE = new Message("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    private static final Message ASK_ATTEMPT_NUMBER_MESSAGE = new Message("시도할 회수는 몇회인가요?");

    private final Player player;

    public Game(Player player) {
        this.player = player;
    }

    public void start() {
        ASK_NAMES_MESSAGE.print();
        Cars cars = new Cars(player.inputNames());
        ASK_ATTEMPT_NUMBER_MESSAGE.print();
        AttemptNumber attemptNumber = player.inputAttemptNumber();
        race(cars, attemptNumber);
        cars.findWinners().makeWinnersMessage().print();
    }

    private void race(Cars cars, AttemptNumber attemptNumber) {
        if (attemptNumber.isOver()) {
            return;
        }
        attemptNumber.decrement();
        cars.moveForwardOrStop();
        cars.makeResultMessage().print();
        race(cars, attemptNumber);
    }
}
