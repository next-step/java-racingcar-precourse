package racinggame.utils;

import nextstep.utils.Randoms;

import racinggame.core.Player;

import java.util.List;

public class GameUtil {

    public static void playGame(final List<Player> players) {
        for (Player player : players) {
            player.addScore(GameUtil.getMovement(Randoms.pickNumberInRange(0,9)));
            player.printResult();
        }
    }

    public static Integer getMovement(final Integer num) {
        if (num >= 4) {
            return 1;
        }
        return 0;
    }

}
