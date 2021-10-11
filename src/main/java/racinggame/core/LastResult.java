package racinggame.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LastResult {

    private final List<PlayerTmp> playerTmps;

    public LastResult(final List<PlayerTmp> playerTmps) {
        this.playerTmps = playerTmps;
    }

    public void printLastResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자는 ");
        for(PlayerTmp playerTmp : getWinners(this.playerTmps)) {
            sb.append(playerTmp.getPlayerName().getName());
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        sb.append(" 입니다.");

        System.out.println(sb);
    }

    private List<PlayerTmp> getWinners(final List<PlayerTmp> playerTmps) {
        List<PlayerTmp> winners = new ArrayList<>();
        PlayerTmp winner = Collections.max(playerTmps, new PlayerTmpComp());
        for (PlayerTmp playerTmp : playerTmps) {
            addWinnerIfSameScore(winners, playerTmp, winner);
        }
        return winners;
    }

    private void addWinnerIfSameScore(final List<PlayerTmp> winners,
                                      final PlayerTmp player,
                                      final PlayerTmp winner) {
        if (isSameScore(player.getPlayerScore().getScore(), winner.getPlayerScore().getScore())) {
            winners.add(player);
        }
    }

    private boolean isSameScore(final int targetScore,
                                final int sourceScore) {
        return targetScore == sourceScore;
    }

}
