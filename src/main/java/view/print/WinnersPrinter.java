package view.print;

import domain.CarName;
import domain.Winner;
import domain.Winners;

import java.util.ArrayList;
import java.util.List;

public class WinnersPrinter {
    private Winners winners;

    public WinnersPrinter(Winners winners) {
        this.winners = winners;
    }

    @Override
    public String toString() {
        List<String> winnerNames = new ArrayList<>();

        for(Winner winner : winners.getWinners()) {
            winnerNames.add(winner.getCarName().toString());
        }

        String winners = String.join(", ", winnerNames);

        return String.format("%s가 최종 우승했습니다.", winners);
    }
}
