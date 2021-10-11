package racinggame.utils;

import nextstep.utils.Randoms;

import racinggame.core.Player;
import racinggame.core.PlayerComp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameUtil {

    private static final int MAX_NUM = 9;
    private static final int MIN_NUM = 0;

    private static final int GAIN_POINT_NUM = 4;

    public static void playGame(final List<Player> players) {
        for (Player player : players) {
            player.addScore(getMovement(Randoms.pickNumberInRange(MIN_NUM, MAX_NUM)));
            player.printResult();
        }
    }

    private static int getMovement(final int num) {
        if (num >= GAIN_POINT_NUM) {
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

    private static List<Player> getWinners(final List<Player> players) {
        List<Player> winners = new ArrayList<>();

        Player winner = Collections.max(players, new PlayerComp());

        for (Player player : players) {
            addWinner(winners, player, winner.getScore());
        }

        return winners;
    }

    private static void addWinner(final List<Player> winners,
                                 final Player player,
                                 final int winnerScore) {
        if (isSameScore(player.getScore(), winnerScore)) {
            winners.add(player);
        }
    }

    private static boolean isSameScore(final int targetScore,
                                final int sourceScore) {
        return targetScore == sourceScore;
    }

}
