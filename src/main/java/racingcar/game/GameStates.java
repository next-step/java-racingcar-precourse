package racingcar.game;

import racingcar.game.util.AbstractImmutableList;

public class GameStates extends AbstractImmutableList<GameState> {
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
