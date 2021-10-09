package racinggame.utils;

import nextstep.utils.Randoms;

import racinggame.core.Player;
import racinggame.core.PlayerComp;

import java.util.ArrayList;
import java.util.Collections;
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

    public static void printLastResult(final List<Player> players) {
        StringBuilder sb = new StringBuilder();

        sb.append("최종 우승자는 ");
        for(Player player : getWinners(players)) {
            sb.append(player.getName());
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append(" 입니다.");

        System.out.println(sb);
    }

    public static List<Player> getWinners(final List<Player> players) {
        List<Player> winners = new ArrayList<>();

        Player winner = Collections.max(players, new PlayerComp());

        for (Player player : players) {
            addWinner(winners, player, winner.getScore());
        }

        return winners;
    }

    public static void addWinner(final List<Player> winners,
                                 final Player player,
                                 final Integer winnerScore) {
        if (player.getScore().equals(winnerScore)) {
            winners.add(player);
        }
    }

}
