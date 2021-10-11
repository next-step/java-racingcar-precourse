package racinggame.core;

import nextstep.utils.Randoms;

import java.util.List;

public class Game {

    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;

    private final List<PlayerTmp> playerTmps;

    public Game(final List<PlayerTmp> playerTmps) {
        this.playerTmps = playerTmps;
    }

    public void play() {
        for (PlayerTmp playerTmp : this.playerTmps) {
            playerTmp.getPlayerScore().addScore(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
            playerTmp.printResult();
        }
    }

}
