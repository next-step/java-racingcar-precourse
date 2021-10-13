package racinggame.vo;

import racinggame.environments.GlobalVariables;

public class GameTurnCnt {
    private static final int GAME_TURN_CNT_UNDEFINED_FLAG = -1;

    private int gameTurnCnt;

    public GameTurnCnt() {
        this.gameTurnCnt = GAME_TURN_CNT_UNDEFINED_FLAG;
    }

    public GameTurnCnt(int gameTurnCnt) {
        this.gameTurnCnt = gameTurnCnt;
    }

    public int get() {
        return this.gameTurnCnt;
    }

    public boolean isValid() {
        return gameTurnCnt >= GlobalVariables.MIN_GAME_TURN_COUNT;
    }
}
