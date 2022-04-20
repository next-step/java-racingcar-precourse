package racingcar.game;

import racingcar.game.util.AbstractMutableList;

public class GameStates extends AbstractMutableList<GameState> {
    public GameStates() {
        super();
    }

    public GameStates(GameState state) {
        super(state);
    }

    public GameStates(GameStates states, GameState... more) {
        super(states.list, more);
    }

    public GameState getLast() {
        if (list.size() < 1) return null;
        return list.get(list.size() - 1);
    }
}
