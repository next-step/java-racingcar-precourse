package racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    List<Winner> winners;

    public Winners(RaceResults raceResults) {
        this.winners = judgeWinners(raceResults);
    }

    private List<Winner> judgeWinners(RaceResults raceResults) {
        List<Winner> winners = new ArrayList<>();
        int leadDistance = raceResults.calculateLeadDistance();
        for (RaceResult raceResult : raceResults.getRaceResults()) {
            addWinner(winners, raceResult, leadDistance);
        }
        return winners;
    }

    private void addWinner(List<Winner> winners, RaceResult raceResult, int leadDistance) {
        if (raceResult.isLeadRacer(leadDistance)) {
            winners.add(new Winner(raceResult.getName()));
        }
    }

    public void report() {
        String winnersName = getWinnersName();
        System.out.println("최종 우승자는 " + winnersName + " 입니다.");
    }

    private String getWinnersName() {
        StringBuilder sb = new StringBuilder();
        for (Winner winner : winners) {
            sb.append(winner.getName() + " ");
        }

        return sb.toString().trim().replaceAll(" ", ",");
    }
}
