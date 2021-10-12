package racinggame.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Winners {
    List<Winner> winners;

    public Winners(List<Winner> winners) {
        initWinners(winners);
    }

    private void initWinners(List<Winner> winners) {
        if (winners != null && winners.size() > 0) {
            this.winners = winners;
            this.winners.sort(Comparator.comparing(Winner::getName));
            return;
        }
        this.winners = new ArrayList<>();
    }

    public void report() {
        String winnersName = getWinnersName();
        System.out.println("최종 우승자는 " + winnersName + " 입니다.");
    }

    private String getWinnersName() {
        StringBuilder sb = new StringBuilder();
        for (Winner winner : winners) {
            sb.append(winner.getName())
                    .append(" ");
        }
        return sb.toString().trim().replaceAll(" ", ",");
    }
}
