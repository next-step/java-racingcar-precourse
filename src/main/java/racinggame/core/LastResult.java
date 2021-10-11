package racinggame.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LastResult {

    private final List<Player> Players;

    public LastResult(final List<Player> Players) {
        this.Players = Players;
    }

    public void printLastResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자는 ");
        for(Player Player : getWinners(this.Players)) {
            sb.append(Player.getPlayerName().getName());
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append(" 입니다.");

        System.out.println(sb);
    }

    private List<Player> getWinners(final List<Player> Players) {
        List<Player> winners = new ArrayList<>();
        Player winner = Collections.max(Players, new PlayerComp());
        for (Player Player : Players) {
            addWinnerIfSameScore(winners, Player, winner);
        }
        return winners;
    }

    private void addWinnerIfSameScore(final List<Player> winners,
                                      final Player player,
                                      final Player winner) {
        if (isSameScore(player.getPlayerScore().getScore(), winner.getPlayerScore().getScore())) {
            winners.add(player);
        }
    }

    private boolean isSameScore(final int targetScore,
                                final int sourceScore) {
        return targetScore == sourceScore;
    }

}
