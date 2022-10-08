package racingcar.Machine;

import racingcar.domain.service.Game;

public class RacingCarGameMachine {
    private final Game game;

    public RacingCarGameMachine(Game game) {
        this.game = game;
    }

    public void start() {
        try {
            game.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
