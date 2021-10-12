package racinggame;

import racinggame.domain.Cars;
import racinggame.domain.Message;
import racinggame.domain.Player;

public class Game {
    private static final Message ASK_NAMES_MESSAGE = new Message("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");

    private final Player player;

    public Game(Player player) {
        this.player = player;
    }

    public void start() {
        ASK_NAMES_MESSAGE.print();
        Cars cars = new Cars(player.inputNames());
        race(cars);
        cars.findWinners().makeWinnersMessage().print();
    }

    private void race(Cars cars) {
        cars.moveForwardOrStop();
        cars.makeResultMessage().print();
    }
}
