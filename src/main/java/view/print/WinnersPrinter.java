package view.print;

import java.util.ArrayList;
import java.util.List;

import domain.winner.Winner;
import domain.winner.Winners;

public class WinnersPrinter {
    private static final String WINNER_JOIN = ", ";

    private Winners winners;

    public WinnersPrinter(Winners winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        List<String> winnerNames = new ArrayList<>();

        for (Winner winner : winners.getWinners()) {
            winnerNames.add(winner.getCarName().toString());
        }

        String winners = String.join(WINNER_JOIN, winnerNames);

        return String.format("%s가 최종 우승했습니다.", winners);
    }
}
