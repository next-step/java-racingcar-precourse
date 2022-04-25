package racingcar.game;

import racingcar.game.util.AbstractImmutableList;

import java.util.ArrayList;
import java.util.List;

public class GameStates extends AbstractImmutableList<GameState> {
    public GameStates() {
        super();
    }

    public GameStates(GameState state) {
        super(state);
    }

    public GameStates(List<GameState> list) {
        super(list);
    }

    public GameStates(GameStates states, GameState... more) {
        super(states.list, more);
    }

    public GameState getLast() {
        if (list.size() < 1) return null;
        return list.get(list.size() - 1);
    }

    public GameStates rest() {
        if (list.size() < 1) new GameStates();
        return new GameStates(new ArrayList<>(list.subList(1, list.size())));
    }
}
