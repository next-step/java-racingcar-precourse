package racinggame;

import racinggame.domain.game.Game;
import racinggame.domain.users.User;

public class Application {
    public static void main(String[] args) {
        // TODO 자동차 경주 게임 구현

        Game racingGame = new Game(new User());
        String[] carNames = racingGame.userInputCarNames();
        int round = racingGame.userInputRound();
        racingGame.init(round, carNames);

        racingGame.play();

    }
}
