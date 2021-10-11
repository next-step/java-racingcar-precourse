package racinggame.core;

import nextstep.utils.Randoms;

import java.util.List;

public class Game {

    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;

    private final List<Player> Players;

    public Game(final List<Player> Players) {
        this.Players = Players;
    }

    public void play() {
        for (Player Player : this.Players) {
            Player.getPlayerScore().addScore(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
            Player.printResult();
        }
    }

}
