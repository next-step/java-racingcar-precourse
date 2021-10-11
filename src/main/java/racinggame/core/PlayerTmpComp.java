package racinggame.core;

import java.util.Comparator;

public class PlayerTmpComp implements Comparator<PlayerTmp> {
    @Override
    public int compare(PlayerTmp playerTmp1, PlayerTmp playerTmp2) {
        return Integer.compare(
            playerTmp1.getPlayerScore().getScore(),
            playerTmp2.getPlayerScore().getScore()
        );
    }
}
